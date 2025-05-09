package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for implementation behavior of a student.
 */
public class Student {
    private final String name;
    private boolean isPaid; // True if student is on paid basis, false otherwise
    private final List<Grade> grades;

    public Student(String name, boolean isPaid) {
        this.name = name;
        this.isPaid = isPaid;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }
}
