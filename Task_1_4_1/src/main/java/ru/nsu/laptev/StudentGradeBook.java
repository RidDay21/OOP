package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentGradeBook { // Изменено имя класса
    private final Student student;
    private final List<ExamSession> examSessions;

    public StudentGradeBook(Student student) {
        this.student = student;
        this.examSessions = new ArrayList<>();
    }

    public void addExamSession(ExamSession session) {
        examSessions.add(session);
    }

    public double calculateGpa() {
        List<Grade> grades = student.getGrades();
        if (grades.isEmpty()) return 0;
        return grades.stream()
                .mapToInt(grade -> grade.getGrade().getNumericValue())
                  .average()
                .orElse(0);
    }

    public boolean isTransferToPaidFormAllowed() {
        if (examSessions.size() < 2) return false;

        List<Grade> lastTwoSessions = examSessions.stream()
                .sorted((a, b) -> Integer.compare(b.getSemester(), a.getSemester()))
                .limit(2)
                .flatMap(s -> s.getGrades().stream())
                .collect(Collectors.toList());

        return lastTwoSessions.stream()
                .filter(Grade::isExam)
                .noneMatch(grade -> grade.getGrade() == GradeValue.НЕУДОВЛЕТВОРИТЕЛЬНО);
    }

    private List<Grade> getFinalGrades() {
        return student.getGrades().stream()
                .collect(Collectors.groupingBy(Grade::getSubject))
                .values().stream()
                .map(grades -> grades.stream().max((a, b) -> Integer.compare(a.getSemester(), b.getSemester())).orElse(null))
                .filter(g -> g != null)
                .collect(Collectors.toList());
    }

    public boolean canGetHonorsDiploma() {
        List<Grade> finalGrades = getFinalGrades();
        if (finalGrades.isEmpty()) return false;

        long excellentCount = finalGrades.stream().filter(g -> g.getGrade() == GradeValue.ОТЛИЧНО).count();
        long satisfactoryCount = finalGrades.stream().filter(g -> g.getGrade() == GradeValue.НЕУДОВЛЕТВОРИТЕЛЬНО).count();
        boolean hasExcellentQualificationWork = finalGrades.stream()
                .anyMatch(grade -> grade.getSubject().equals("Qualification Work") && grade.getGrade() == GradeValue.ОТЛИЧНО);

        return (double) excellentCount / finalGrades.size() >= 0.75 && satisfactoryCount == 0 && hasExcellentQualificationWork;
    }

    public boolean canGetIncreasedScholarship(int semester) {
        return student.getGrades().stream()
                .filter(grade -> grade.getSemester() == semester)
                .allMatch(grade -> grade.getGrade() == GradeValue.ХОРОШО);
    }
}

