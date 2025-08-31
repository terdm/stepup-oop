package ru.courses.main;

import ru.courses.geometry.Point;
import ru.courses.geometry.Line;

public class Main {
    public static void main(String[] args) {
        // Создаем точки
        Point start1 = new Point(1, 1);
        Point end1 = new Point(5, 5);
        Point start2 = new Point(1, 1);
        Point end2 = new Point(5, 5);
        Point start3 = new Point(2, 3);
        Point end3 = new Point(4, 6);

        // Создаем линии
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);
        Line line3 = new Line(start3, end3);

        // Тестируем сравнение
        System.out.println("line1.equals(line2): " + line1.equals(line2)); // true
        System.out.println("line1.equals(line3): " + line1.equals(line3)); // false
        System.out.println("line1 == line2: " + (line1 == line2)); // false

        // Тестируем глубокое клонирование
        Line clonedLine = line1.clone();
        System.out.println("Original: " + line1); // Line{start=(1, 1), end=(5, 5)}
        System.out.println("Clone: " + clonedLine); // Line{start=(1, 1), end=(5, 5)}
        System.out.println("line1.equals(clonedLine): " + line1.equals(clonedLine)); // true
        System.out.println("line1 == clonedLine: " + (line1 == clonedLine)); // false

        // Проверяем, что это действительно глубокие копии
        clonedLine.start.x = 10;
        clonedLine.end.y = 20;
        System.out.println("After modification:");
        System.out.println("Original: " + line1); // Line{start=(1, 1), end=(5, 5)} - не изменилась!
        System.out.println("Clone: " + clonedLine); // Line{start=(10, 1), end=(5, 20)} - изменилась
    }
}