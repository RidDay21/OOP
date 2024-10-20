package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Number.
 */
class NumberTest {
    @Test
    void numbTest() {
        Number numb = new Number(5.0);
        assertEquals(5, numb.eval(""));
        assertEquals((new Number(0)).eval(""), numb.derivative("").eval(""));
        numb.print();
    }
}