package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MulTest {
    @Test
    void sampleTest()
    {
        Mul mul =  new Mul(new Number(5), new Number(6));
        mul.print();
        assertEquals(30,mul.eval(""));
        mul.derivative("");
        mul.print();
        Mul mul1 = new Mul(new Variable("x"), new Number(6));
        mul1.print();
    }
}