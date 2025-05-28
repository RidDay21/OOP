package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExamSessionTest {

    @Test
    void testExamSessionCreationAndGetters() {
        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade("Математика", GradeValue.ХОРОШО, true, 1));
        grades.add(new Grade("Физика", GradeValue.ОТЛИЧНО, true, 1));

        ExamSession session = new ExamSession(1, grades);
        assertEquals(1, session.getSemester());
        assertEquals(grades, session.getGrades());
        assertEquals(2, session.getGrades().size());
    }

    @Test
    void testEmptyExamSession() {
        List<Grade> grades = new ArrayList<>();
        ExamSession session = new ExamSession(1, grades);
        assertEquals(1, session.getSemester());
        assertEquals(0, session.getGrades().size());
    }

}

