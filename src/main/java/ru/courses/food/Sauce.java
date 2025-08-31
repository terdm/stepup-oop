package ru.courses.food;
public class Sauce {
    private final String name;
    private final Spiciness spiciness;

    // Конструктор требует указать название и остроту
    public Sauce(String name, Spiciness spiciness) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название соуса не может быть пустым");
        }
        if (spiciness == null) {
            throw new IllegalArgumentException("Острота соуса должна быть указана");
        }

        this.name = name.trim();
        this.spiciness = spiciness;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Spiciness getSpiciness() {
        return spiciness;
    }

    // Текстовое представление
    @Override
    public String toString() {
        return "Соус " + name + ": " + spiciness.getDescription();
    }

    // Дополнительно: equals и hashCode для корректного сравнения
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Sauce other = (Sauce) obj;
        return name.equals(other.name) && spiciness == other.spiciness;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + spiciness.hashCode();
        return result;
    }
}