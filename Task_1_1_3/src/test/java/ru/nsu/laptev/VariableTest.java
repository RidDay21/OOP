package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {
    @Test
    void sampleTest()
    {
        Variable var =  new Variable("x");
        assertEquals(10, var.eval(" x = 10"));
        assertEquals(0, var.eval(" y = 10"));
        assertEquals(100, var.eval(" x = 10; x = 100"));
        assertEquals(1, var.derivative("x").eval(""));
        assertEquals(2, var.derivative("2x").eval(""));
        var.print();
    }
}