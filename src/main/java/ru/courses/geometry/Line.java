package ru.courses.geometry;

public class Line {
    private Point start;
    private Point end;

    // Конструктор с двумя точками
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Конструктор с четырьмя целыми числами
    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    // Метод для получения текстового представления
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    // Метод для расчета длины линии
    public double getLength() {
        int deltaX = end.x - start.x;
        int deltaY = end.y - start.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // Геттеры и сеттеры для изменения точек
    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }


}

