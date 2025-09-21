package ru.courses.collections;

import java.util.*;

public class PairSwap {
    public static void main(String[] args) {
        int N = 8; // Чётное число
        List<Integer> list = createList(N);
        System.out.println("Исходный список: " + list);

        swapPairs(list);
        System.out.println("После попарной замены: " + list);
    }

    // Создание списка от 1 до N
    public static List<Integer> createList(int N) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        return list;
    }

    // Попарная замена элементов
    public static void swapPairs(List<Integer> list) {
        for (int i = 0; i < list.size(); i += 2) {
            Collections.swap(list, i, i + 1);
        }
    }
}
