package ru.nsu.laptev;

import java.util.List;

public class ExamSession {
    private final int semester;
    private final List<Grade> grades;

    public ExamSession(int semester, List<Grade> grades) {
        this.semester = semester;
        this.grades = grades;
    }

    public int getSemester() {
        return semester;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public boolean hasSatisfactoryGrade() {
        return grades.stream().anyMatch(g -> g.getGrade() == GradeValue.НЕУДОВЛЕТВОРИТЕЛЬНО);
    }
}
