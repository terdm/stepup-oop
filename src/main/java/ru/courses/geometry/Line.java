package ru.courses.geometry;
public class Line implements Cloneable {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
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
        Line other = (Line) obj;
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    // Переопределение hashCode в соответствии с equals
    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    // Переопределение метода clone для глубокого копирования
    @Override
    public Line clone() {
        try {
            Line cloned = (Line) super.clone();
            // Глубокое копирование: клонируем Point объекты
            cloned.start = this.start.clone();
            cloned.end = this.end.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported for Line class");
        }
    }

    // Дополнительно: переопределяем toString для удобства вывода
    @Override
    public String toString() {
        return "Line{start=" + start + ", end=" + end + "}";
    }
}