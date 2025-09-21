package ru.courses.algebra;

public class Sum {
    public static void main(String[] args) {
        double sum = 0;

        for (String arg : args) {
            if (isValidNumber(arg)) {
                sum += Double.parseDouble(arg);
            }
        }

        System.out.println(sum);
    }

    /**
     * Проверяет строку на соответствие формату числа double
     * с помощью регулярного выражения
     */
    private static boolean isValidNumber(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }

        // Регулярное выражение для проверки формата double чисел
        // Допускает: 123, 123.45, -123, +123, 1.23e-10, 1.23E+10 и т.д.
        String doubleRegex = "^[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:[eE][+-]?\\d+)?$";

        return str.trim().matches(doubleRegex);
    }
}
