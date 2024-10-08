package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DivTest {
    @Test
    void sampleTest() {
        Div div = new Div(new Number(4), new Number(2));
        div.print();
        assertEquals(2, div.eval(""));
        Expression e = div.derivative("x");
        e.print();
    }

}