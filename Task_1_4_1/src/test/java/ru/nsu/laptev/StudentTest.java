package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void studentTest() {
        Student student = new Student("Nikolay Laptev", "23213", true);

        assertEquals("Nikolay Laptev", student.getName());
        assertEquals("23213", student.getID());
        assertEquals(true, student.isPaid());
        student.setPaid(false);
        assertEquals(false, student.isPaid());
    }


}