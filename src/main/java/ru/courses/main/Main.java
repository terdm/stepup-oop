package ru.courses.main;

import ru.courses.food.Sauce;
import ru.courses.food.Spiciness;

public class Main {
    public static void main(String[] args) {
        // Создаем соусы с разной остротой
        Sauce sriracha = new Sauce("Срирача", Spiciness.VERY_SPICY);
        Sauce tabasco = new Sauce("Табаско", Spiciness.SPICY);
        Sauce mayonnaise = new Sauce("Майонез", Spiciness.NOT_SPICY);

        // Выводим текстовое представление
        System.out.println(sriracha);     // Соус Срирача: очень острый
        System.out.println(tabasco);      // Соус Табаско: острый
        System.out.println(mayonnaise);   // Соус Майонез: не острый

        // Попытка создать соус с некорректными параметрами
        try {
            Sauce invalid = new Sauce("", Spiciness.SPICY);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage()); // Ошибка: Название соуса не может быть пустым
        }

        try {
            Sauce invalid = new Sauce("Кетчуп", null);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage()); // Ошибка: Острота соуса должна быть указана
        }

        // Работа с перечислением остроты
        System.out.println("Все возможные уровни остроты:");
        for (Spiciness level : Spiciness.values()) {
            System.out.println("- " + level.getDescription());
        }
    }
}