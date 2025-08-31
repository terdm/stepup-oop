package ru.courses.food;
public enum Spiciness {
    VERY_SPICY("очень острый"),
    SPICY("острый"),
    NOT_SPICY("не острый");

    private final String description;

    Spiciness(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
