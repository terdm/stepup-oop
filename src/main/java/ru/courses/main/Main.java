package ru.courses.main;

// Используем простое имя для нашего класса
import ru.courses.geometry.Point;

public class Main {
    public static void main(String[] args) {
        // Наш класс - по простому имени
        Point geometryPoint = new Point(3, 4);

        // AWT класс - по полному имени
        java.awt.Point awtPoint = new java.awt.Point(10, 20);

        System.out.println("Точка из ru.courses.geometry: " + geometryPoint);
        System.out.println("Точка из java.awt: " + awtPoint);
        System.out.println("Тип geometryPoint: " + geometryPoint.getClass().getName());
        System.out.println("Тип awtPoint: " + awtPoint.getClass().getName());
    }
}
