package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Mul.
 */
class MulTest {
    @Test
    void mulTest() {
        Mul mul = new Mul(new Number(5), new Number(6));
        mul.print();
        assertEquals(30.0, mul.eval(""));
        mul.derivative(""); //it's not correct, bro.
        mul.print();
    }

    @Test
    void mulWithVarTest() {
        Mul mul1 = new Mul(new Variable("x"), new Number(6));
        mul1.print();
        assertEquals(15, mul1.eval("x = 2.5"));
    }
}