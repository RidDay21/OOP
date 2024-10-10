package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Div.
 */
class DivTest {
    Div div = new Div(new Number(4), new Number(2));

    @Test
    void divTest() {
        div.print();
        assertEquals(2.0, div.eval(""));
        Expression e = div.derivative("x");
        div = new Div(new Number(5), new Number(0));
    }

    @Test
    void divByZeroTest() {
        try {
            div.eval(" ");
        } catch (ArithmeticException exception) {
            System.out.println("Sheeeesh,bro, you tried to divide by zero...Not cool");
        }
    }

    @Test
    void divWith2VarsTest() {
        div = new Div(new Variable("x"), new Variable("y"));
        assertEquals(10, div.eval("x = 30; y = 3"));
    }

}