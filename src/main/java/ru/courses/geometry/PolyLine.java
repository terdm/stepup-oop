package ru.courses.geometry;
import java.util.Arrays;

public class PolyLine {
    public Point[] points;

    public PolyLine(Point... points) {
        this.points = points;
    }

    public double length() {
        double sum = 0;
        for (int i = 1; i < points.length; i++) {
            double len1 = points[i].x - points[i - 1].x;
            double len2 = points[i].y - points[i - 1].y;
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
    }

    // Переопределение метода equals для сравнения по состоянию
    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на ссылочную идентичность
        if (this == obj) {
            return true;
        }

        // 2. Проверка на null и совпадение классов
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        // 3. Приведение типа
        PolyLine other = (PolyLine) obj;

        // 4. Проверка длины массивов
        if (this.points.length != other.points.length) {
            return false;
        }

        // 5. Поэлементное сравнение точек
        for (int i = 0; i < this.points.length; i++) {
            if (!this.points[i].equals(other.points[i])) {
                return false;
            }
        }

        return true;
    }

    // Переопределение hashCode в соответствии с equals
    @Override
    public int hashCode() {
        int result = Arrays.hashCode(points);
        return result;
    }

    // Дополнительно: переопределяем toString для удобства вывода
    @Override
    public String toString() {
        return "PolyLine{points=" + Arrays.toString(points) + "}";
    }
}