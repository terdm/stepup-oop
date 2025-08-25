package ru.courses.geometry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolyLine {
    private List<Point> points;

    // Конструктор без параметров
    public PolyLine() {
        this.points = new ArrayList<>();
    }

    // Конструктор с начальным набором точек
    public PolyLine(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    // Метод для добавления точки
    public void addPoint(Point point) {
        points.add(point);
    }

    // Метод для добавления точки по координатам
    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    // Текстовое представление
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Получить массив линий
    public Line[] getLines() {
        if (points.size() < 2) {
            return new Line[0];
        }

        Line[] lines = new Line[points.size() - 1];
        for (int i = 0; i < points.size() - 1; i++) {
            lines[i] = new Line(points.get(i), points.get(i + 1));
        }
        return lines;
    }

    // Получить длину ломаной
    public double getLength() {
        if (points.size() < 2) {
            return 0.0;
        }

        double totalLength = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);
            int deltaX = end.x - start.x;
            int deltaY = end.y - start.y;
            totalLength += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        }
        return totalLength;
    }

    // Получить список точек (для доступа к конкретным точкам)
    public List<Point> getPoints() {
        return points;
    }


}
