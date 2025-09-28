package ru.courses.main;

import ru.courses.animals.Cat;
import ru.courses.animals.Dog;
import ru.courses.utils.FieldNullifier;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
        System.out.println("До обнуления: " + cat);

        FieldNullifier.nullifyFields(cat);
        System.out.println("После обнуления: " + cat);

        // Тестируем на другом классе
        Dog dog = new Dog("Sharik", 5, "Ovcharka");
        System.out.println("\nДо обнуления: " + dog);

        FieldNullifier.nullifyFields(dog);
        System.out.println("После обнуления: " + dog);
    }
}