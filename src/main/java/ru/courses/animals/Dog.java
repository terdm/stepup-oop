package ru.courses.animals;


// Дополнительный класс для тестирования
public class Dog {
    public String name;
    private int age;
    private String breed;
    private static String type = "Domestic";

    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}