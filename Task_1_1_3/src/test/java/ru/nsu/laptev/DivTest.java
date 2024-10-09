package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Div.
 */
class DivTest {
    @Test
    void sampleTest() {
        Div div = new Div(new Number(4), new Number(2));
        div.print();
        assertEquals(2, div.eval(""));
        Expression e = div.derivative("x");
        div = new Div(new Number(5), new Number(0));
        try {
            div.eval(" ");
        }
        catch (ArithmeticException exception) {
            System.out.println("Sheeeesh,bro, you tried to divide by zero...Not cool");
        }

        e.print();
    }

}