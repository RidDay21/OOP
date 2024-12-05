package ru.nsu.laptev;

public class Grade {
    private final String subject;
    private final GradeValue grade;
    private final boolean isExam;
    private final int semester;

    public Grade(String subject, GradeValue grade, boolean isExam, int semester) {
        this.subject = subject;
        this.grade = grade;
        this.isExam = isExam;
        this.semester = semester;
    }

    public GradeValue getGrade() {
        return grade;
    }

    public boolean isExam() {
        return isExam;
    }

    public int getSemester() {
        return semester;
    }

    public String getSubject() {
        return subject;
    }
}
