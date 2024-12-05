package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final String id;
    private boolean isPaid; // True if student is on paid basis, false otherwise
    private final List<Grade> grades;

    public Student(String name, String id, boolean isPaid) {
        this.name = name;
        this.id = id;
        this.isPaid = isPaid;
        this.grades = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
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
