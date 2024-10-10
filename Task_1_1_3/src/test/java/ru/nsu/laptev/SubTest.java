package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

/**
 * Class for testing class Sub.
 */
class SubTest {
    Sub sub = new Sub(new Number(5), new Number(6));
    @Test
    void subTest() {
        sub.print();
        assertEquals(-1, sub.eval("x = 0"));
        sub.derivative("");
        sub.print();
    }
    @Test
    void subWithVar() {
        sub = new Sub(new Variable("x"), new Number(6));
        sub.print();
        assertEquals(84, sub.eval("x = 90"));
        sub = new Sub(new Variable("x"), new Number (5.056));
        Double res = sub.eval("x=      6.256");
        DecimalFormat myFormat = new DecimalFormat("#.###");
        assertEquals("1,2", myFormat.format(res));
    }

}