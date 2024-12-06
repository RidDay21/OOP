package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Class for testing.
 */
class ExamSessionTest {
    @Test
    void EStest() {
        List<Grade> grades = List.of(new Grade("Math",GradeValue.ОТЛИЧНО, true, 1), new Grade("Physics", GradeValue.ОТЛИЧНО, true, 1));
        ExamSession es = new ExamSession(1, grades);

        System.out.println(es.getGrades().toString()); //

        assertEquals(es.getSemester(), 1);
    }

}