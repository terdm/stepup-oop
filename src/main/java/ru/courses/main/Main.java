package ru.courses.main;

import ru.courses.geometry.Point;
import ru.courses.geometry.PolyLine;

public class Main {
    public static void main(String[] args) {
        // Создаем точки
        Point p1 = new Point(1, 1);
        Point p2 = new Point(5, 5);
        Point p3 = new Point(10, 3);
        Point p4 = new Point(1, 1);
        Point p5 = new Point(5, 5);
        Point p6 = new Point(10, 3);
        Point p7 = new Point(2, 2);

        // Создаем ломаные линии
        PolyLine line1 = new PolyLine(p1, p2, p3);
        PolyLine line2 = new PolyLine(p4, p5, p6); // Такие же точки
        PolyLine line3 = new PolyLine(p1, p2);     // Разное количество точек
        PolyLine line4 = new PolyLine(p1, p7, p3); // Разные точки
        PolyLine line5 = new PolyLine(p1, p2, p3); // Такие же точки

        // Тестируем сравнение
        System.out.println("line1.equals(line2): " + line1.equals(line2)); // true
        System.out.println("line1.equals(line3): " + line1.equals(line3)); // false
        System.out.println("line1.equals(line4): " + line1.equals(line4)); // false
        System.out.println("line1.equals(line5): " + line1.equals(line5)); // true
        System.out.println("line1 == line2: " + (line1 == line2)); // false

        // Тестируем длину
        System.out.println("line1 length: " + line1.length());
        System.out.println("line2 length: " + line2.length());
    }
}