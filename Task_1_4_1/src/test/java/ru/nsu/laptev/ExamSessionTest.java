package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//переделай
class ExamSessionTest {
    @Test
    void EStest() {
        List<Grade> grades = List.of(new Grade("Math",GradeValue.ОТЛИЧНО, true, 1), new Grade("Physics", GradeValue.ОТЛИЧНО, true, 1));
        ExamSession es = new ExamSession(1, grades);

        System.out.println(es.getGrades().toString()); //

        assertEquals(es.getSemester(), 1);
    }

}