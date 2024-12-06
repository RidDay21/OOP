package ru.nsu.laptev;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Class for testing.
 */
class StudentGradeBookTest {
    @Test
    void initialze() {
        Student student = new Student("John Doe", true);
        StudentGradeBook recordBook = new StudentGradeBook(student);

        student.addGrade(new Grade("Math", GradeValue.ОТЛИЧНО, true, 1));
        student.addGrade(new Grade("Physics", GradeValue.УДОВЛЕТВОРИТЕЛЬНО, true, 1));
        student.addGrade(new Grade("Chemistry", GradeValue.ХОРОШО, false, 1));

        List<Grade> session1Grades = List.of(new Grade("Math",GradeValue.ОТЛИЧНО, true, 1), new Grade("Physics", GradeValue.ОТЛИЧНО, true, 1));
        recordBook.addExamSession(new ExamSession(1, session1Grades));
        List<Grade> session2Grades = List.of(new Grade("Math",GradeValue.ХОРОШО, true, 2), new Grade("Physics", GradeValue.ОТЛИЧНО, true, 2));
        recordBook.addExamSession(new ExamSession(2, session2Grades));

        System.out.println("GPA: " + recordBook.calculateGpa());
        System.out.println("Can transfer to budget: " + recordBook.isTransferToPaidFormAllowed());
        System.out.println("Can get honors diploma: " + recordBook.canGetHonorsDiploma());
        System.out.println("Can get increased scholarship in semester 2: " + recordBook.canGetIncreasedScholarship(2));
    }
}