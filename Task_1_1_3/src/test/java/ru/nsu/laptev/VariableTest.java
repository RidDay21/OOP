package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Variable.
 */
class VariableTest {
    Variable var = new Variable("x");

    @Test
    void varTest() {
        assertEquals(10, var.eval(" x = 10"));
        assertEquals(100, var.eval(" x = 10; x = 100"));
        assertEquals(1, var.derivative("x").eval(""));
        var.print();
    }

    @Test
    void varExceptionTest() {
        try {
            assertEquals(0, var.derivative("y").eval(""));
        } catch (ArithmeticException pre) {
            assertEquals(0, 0);
        }
        var.print();
    }

    @Test
    void twoVariablesTest() {
        Expression e = new Add(new Variable("x"), new Variable("y"));
        e.print();
        assertEquals(25, e.eval("x = 15, y = 10"));
        assertEquals("x", var.return_var());
    }
}