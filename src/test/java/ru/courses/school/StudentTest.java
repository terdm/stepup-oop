package ru.courses.school;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class StudentTest {
    private MockWebServer server;
    private Student student;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start(5352); // Запускаем на порту 5352
        student = new Student("Иван Иванов");
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testAddValidGrade() throws Exception {
        // Настраиваем заглушку для возврата true на валидную оценку
        server.enqueue(new MockResponse()
                .setBody("true")
                .addHeader("Content-Type", "text/plain"));

        student.addGrade(5);

        // Проверяем, что оценка добавлена
        List<Integer> grades = student.getGrades();
        assertEquals(1, grades.size());
        assertEquals(Integer.valueOf(5), grades.get(0));

        // Проверяем, что был сделан правильный запрос
        RecordedRequest request = server.takeRequest();
        assertEquals("/checkGrade?grade=5", request.getPath());
    }

    @Test
    public void testAddInvalidGrade() throws Exception {
        // Настраиваем заглушку для возврата false на невалидную оценку
        server.enqueue(new MockResponse()
                .setBody("false")
                .addHeader("Content-Type", "text/plain"));

        try {
            student.addGrade(1);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("1 is wrong grade", e.getMessage());
        }

        // Проверяем, что оценка НЕ добавлена
        List<Integer> grades = student.getGrades();
        assertTrue(grades.isEmpty());

        // Проверяем, что был сделан запрос
        RecordedRequest request = server.takeRequest();
        assertEquals("/checkGrade?grade=1", request.getPath());
    }

    @Test
    public void testMultipleValidGrades() throws Exception {
        // Настраиваем ответы для нескольких валидных оценок
        server.enqueue(new MockResponse().setBody("true")); // для 5
        server.enqueue(new MockResponse().setBody("true")); // для 4
        server.enqueue(new MockResponse().setBody("true")); // для 3

        student.addGrade(5);
        student.addGrade(4);
        student.addGrade(3);

        List<Integer> grades = student.getGrades();
        assertEquals(3, grades.size());
        assertTrue(grades.contains(5));
        assertTrue(grades.contains(4));
        assertTrue(grades.contains(3));

        // Проверяем все запросы
        assertEquals("/checkGrade?grade=5", server.takeRequest().getPath());
        assertEquals("/checkGrade?grade=4", server.takeRequest().getPath());
        assertEquals("/checkGrade?grade=3", server.takeRequest().getPath());
    }

    @Test
    public void testMixedValidAndInvalidGrades() throws Exception {
        // Настраиваем ответы: valid, invalid, valid
        server.enqueue(new MockResponse().setBody("true"));  // 5 - valid
        server.enqueue(new MockResponse().setBody("false")); // 1 - invalid
        server.enqueue(new MockResponse().setBody("true"));  // 4 - valid

        student.addGrade(5); // должно добавиться

        try {
            student.addGrade(1); // должно выбросить исключение
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("1 is wrong grade", e.getMessage());
        }

        student.addGrade(4); // должно добавиться

        List<Integer> grades = student.getGrades();
        assertEquals(2, grades.size());
        assertTrue(grades.contains(5));
        assertTrue(grades.contains(4));
        assertFalse(grades.contains(1));
    }

    @Test
    public void testRatingCalculation() throws Exception {
        // Сначала добавляем оценки
        server.enqueue(new MockResponse().setBody("true")); // для 5
        server.enqueue(new MockResponse().setBody("true")); // для 4
        server.enqueue(new MockResponse().setBody("true")); // для 3

        // Затем настраиваем ответ для рейтинга
        server.enqueue(new MockResponse()
                .setBody("4") // ожидаемый рейтинг
                 .addHeader("Content-Type", "text/plain"));

        student.addGrade(5);
        student.addGrade(4);
        student.addGrade(3);

        int rating = student.raiting();
        assertEquals(4, rating);

        // Проверяем запрос
        RecordedRequest ratingRequest = server.takeRequest(); // первый запрос
        assertEquals("/checkGrade?grade=5", ratingRequest.getPath());
    }

    @Test
    public void testServiceUnavailable() throws Exception {
        // Настраиваем ошибку сервера
        server.enqueue(new MockResponse().setResponseCode(500));

        try {
            student.addGrade(5);
            fail("Expected Exception due to server error");
        } catch (Exception e) {
            // Ожидаем любое исключение из-за ошибки сервера
            assertTrue(e instanceof Exception);
        }
    }
}