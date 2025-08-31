package ru.courses.geometry;
public class Point implements Cloneable {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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

        // 3. Приведение типа и сравнение полей
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    // Переопределение hashCode в соответствии с equals
    @Override
    public int hashCode() {
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }

    // Переопределение метода clone для создания копии
    @Override
    public Point clone() {
        try {
            // Вызываем родительский clone() и приводим к Point
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported for Point class");
        }
    }
    @Override
    public String toString() {
        return "Point{x=" + x + ", y=" + y + "}";
    }
}