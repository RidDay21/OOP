package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberTest {
    @Test
    void sampleTest()
    {
        Number numb =  new Number(5);
        assertEquals(5,numb.eval(""));
        assertEquals((new Number(0)).eval(""), numb.derivative("").eval(""));
        numb.print();
    }


}