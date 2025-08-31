package ru.courses.main;

// Импорты для использования коротких имен методов
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {

    /**
     * Метод для возведения числа X в степень Y
     * @param xStr строка с числом X
     * @param yStr строка с числом Y
     * @return результат возведения X в степень Y
     */
    public static double power(String xStr, String yStr) {
        // Преобразуем строки в числа используя короткое имя метода
        int x = parseInt(xStr);
        int y = parseInt(yStr);

        // Возводим в степень используя короткое имя метода
        return pow(x, y);
    }

    public static void main(String[] args) {
        // Проверяем, что передано достаточно аргументов
        if (args.length < 2) {
            System.out.println("Использование: java Main <число> <степень>");
            System.out.println("Пример: java Main 2 3");
            return;
        }

        try {
            // Вызываем метод power с параметрами командной строки
            double result = power(args[0], args[1]);

            // Выводим результат
            System.out.println(args[0] + " в степени " + args[1] + " = " + result);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: оба аргумента должны быть целыми числами");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}