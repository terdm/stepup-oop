package ru.courses.main;

import ru.courses.geometry.Point;

public class Main {
    public static void main(String[] args) {
        // Создаем точки
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        Point point3 = new Point(5, 6);

        // Тестируем сравнение
        System.out.println("point1.equals(point2): " + point1.equals(point2)); // true
        System.out.println("point1.equals(point3): " + point1.equals(point3)); // false
        System.out.println("point1 == point2: " + (point1 == point2)); // false

        // Тестируем клонирование
        Point clonedPoint = point1.clone();
        System.out.println("Original: " + point1); // Point{x=3, y=4}
        System.out.println("Clone: " + clonedPoint); // Point{x=3, y=4}
        System.out.println("point1.equals(clonedPoint): " + point1.equals(clonedPoint)); // true
        System.out.println("point1 == clonedPoint: " + (point1 == clonedPoint)); // false

        // Проверяем, что это действительно разные объекты
        clonedPoint.x = 10;
        System.out.println("After modification:");
        System.out.println("Original: " + point1); // Point{x=3, y=4}
        System.out.println("Clone: " + clonedPoint); // Point{x=10, y=4}
    }
}