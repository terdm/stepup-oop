package ru.courses.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldNullifier {

    /**
     * Универсальный метод для обнуления полей любого объекта
     * @param obj объект, поля которого нужно обнулить
     */
    public static void nullifyFields(Object obj) {
        if (obj == null) {
            return;
        }

        Class<?> clazz = obj.getClass();

        // Получаем все поля класса, включая приватные
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            try {
                // Делаем поле доступным, даже если оно private
                field.setAccessible(true);

                // Получаем тип поля
                Class<?> fieldType = field.getType();

                // Обнуляем только ссылочные типы, примитивы не трогаем
                if (!fieldType.isPrimitive()) {
                    field.set(obj, null);
                }

            } catch (IllegalAccessException e) {
                System.err.println("Ошибка доступа к полю " + field.getName() + ": " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Ошибка при обработке поля " + field.getName() + ": " + e.getMessage());
            }
        }
    }
}
