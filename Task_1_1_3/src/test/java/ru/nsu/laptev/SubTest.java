package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubTest {
    @Test
    void sampleTest()
    {
        Sub sub =  new Sub(new Number(5), new Number(6));
        sub.print();
        assertEquals(0,sub.eval("x = 0"));
        sub.derivative("");
        sub.print();
        sub = new Sub(new Variable("x"), new Number(6));
        sub.print();
        assertEquals(15,sub.eval("x = 90"));
    }

}