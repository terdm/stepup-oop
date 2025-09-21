package ru.courses.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Исправление инкапсуляции - возвращаем неизменяемую копию
    public List<Integer> getGrades() {
        return Collections.unmodifiableList(new ArrayList<>(grades));
        //return grades;
    }

    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException(grade + " is wrong grade");
        }
        grades.add(grade);
    }

    // Метод для получения средней оценки
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    // Метод для проверки наличия оценок
    public boolean hasGrades() {
        return !grades.isEmpty();
    }

    // Метод для получения количества оценок
    public int getGradesCount() {
        return grades.size();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.grades);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.grades, other.grades);
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", grades=" + grades + '}';
    }
}