package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Variable.
 */
class VariableTest {
    @Test
    void sampleTest() {
        Variable var = new Variable("x");
        assertEquals(10, var.eval(" x = 10"));
        assertEquals(0, var.eval(" y = 10"));
        assertEquals(100, var.eval(" x = 10; x = 100"));
        assertEquals(1, var.derivative("x").eval(""));
        var.print();
        assertEquals(0, var.derivative("y").eval(""));
        var.print();
        Expression e = new Add(new Variable("x"), new Variable("y"));
        e.print();
        assertEquals(25, e.eval("x = 15, y = 10"));

        assertEquals("x", var.return_var());
    }
}