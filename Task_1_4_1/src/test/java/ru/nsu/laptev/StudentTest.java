package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing.
 */
class StudentTest {
    @Test
    void studentTest() {
        Student student = new Student("Nikolay Laptev", true);

        assertEquals("Nikolay Laptev", student.getName());
        assertEquals(true, student.isPaid());
        student.setPaid(false);
        assertEquals(false, student.isPaid());
    }
    
}