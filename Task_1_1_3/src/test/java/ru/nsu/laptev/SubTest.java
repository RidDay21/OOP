package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Sub.
 */
class SubTest {
    @Test
    void sampleTest() {
        Sub sub = new Sub(new Number(5), new Number(6));
        sub.print();
        assertEquals(-1, sub.eval("x = 0"));
        sub.derivative("");
        sub.print();
        sub = new Sub(new Variable("x"), new Number(6));
        sub.print();
        assertEquals(84, sub.eval("x = 90"));
    }

}