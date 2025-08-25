package ru.courses.geometry;
public class Point {
    public int  x;
    public int  y;

    // Конструктор, требует указания обеих координат
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Метод для возврата текстового представления
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Метод для сравнения точек по значениям атрибутов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }


}