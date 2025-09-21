package ru.courses.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Иван Иванов");
    }

    @Test
    void testConstructorAndGetName() {
        assertEquals("Иван Иванов", student.getName());
    }

    @Test
    void testSetName() {
        student.setName("Петр Петров");
        assertEquals("Петр Петров", student.getName());
    }

    @Test
    void testAddValidGrade() {
        student.addGrade(5);
        student.addGrade(4);
        student.addGrade(3);

        List<Integer> grades = student.getGrades();
        assertEquals(3, grades.size());
        assertTrue(grades.contains(5));
        assertTrue(grades.contains(4));
        assertTrue(grades.contains(3));
    }

    @Test
    void testAddInvalidGradeTooLow() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> student.addGrade(1)
        );
        assertEquals("1 is wrong grade", exception.getMessage());
    }

    @Test
    void testAddInvalidGradeTooHigh() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> student.addGrade(6)
        );
        assertEquals("6 is wrong grade", exception.getMessage());
    }

    @Test
    void testGetGradesEncapsulation() {
        // Добавляем оценки
        student.addGrade(5);
        student.addGrade(4);

        // Получаем список оценок
        List<Integer> grades = student.getGrades();

        // Проверяем, что это неизменяемый список
        assertThrows(UnsupportedOperationException.class, () -> grades.add(3));
        assertThrows(UnsupportedOperationException.class, () -> grades.remove(0));
        assertThrows(UnsupportedOperationException.class, () -> grades.set(0, 2));

        // Проверяем, что изменения в оригинальном списке не влияют на возвращенную копию
        student.addGrade(3);
        assertEquals(2, grades.size()); // Возвращенный список не изменился
    }

    @Test
    void testGetAverageGradeWithNoGrades() {
        assertEquals(0.0, student.getAverageGrade());
    }

    @Test
    void testGetAverageGradeWithGrades() {
        student.addGrade(5);
        student.addGrade(4);
        student.addGrade(3);

        assertEquals(4.0, student.getAverageGrade(), 0.001);
    }

    @Test
    void testHasGrades() {
        assertFalse(student.hasGrades());
        student.addGrade(5);
        assertTrue(student.hasGrades());
    }

    @Test
    void testGetGradesCount() {
        assertEquals(0, student.getGradesCount());
        student.addGrade(5);
        assertEquals(1, student.getGradesCount());
        student.addGrade(4);
        assertEquals(2, student.getGradesCount());
    }

    @Test
    void testEqualsAndHashCode() {
        Student student1 = new Student("Иван");
        student1.addGrade(5);
        student1.addGrade(4);

        Student student2 = new Student("Иван");
        student2.addGrade(5);
        student2.addGrade(4);

        Student student3 = new Student("Петр");
        student3.addGrade(5);

        // Проверка equals
        assertEquals(student1, student2);
        assertNotEquals(student1, student3);
        assertNotEquals(student1, null);
        assertNotEquals(student1, new Object());

        // Проверка hashCode
        assertEquals(student1.hashCode(), student2.hashCode());
        assertNotEquals(student1.hashCode(), student3.hashCode());
    }

    @Test
    void testToString() {
        student.addGrade(5);
        student.addGrade(4);

        String result = student.toString();
        assertTrue(result.contains("Иван Иванов"));
        assertTrue(result.contains("grades=[5, 4]") || result.contains("grades=[4, 5]"));
    }

    @Test
    void testGradesListModificationAttempt() {
        student.addGrade(5);
        student.addGrade(4);

        List<Integer> externalList = new ArrayList<>();
        externalList.add(2);
        externalList.add(3);

        // Попытка модификации через полученный список должна выбрасывать исключение
        List<Integer> grades = student.getGrades();
        assertThrows(UnsupportedOperationException.class, () -> grades.addAll(externalList));
    }
}