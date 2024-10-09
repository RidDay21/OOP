package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Add.
 */
class AddTest {
    @Test
    void sampleTest() {
        Add add = new Add(new Number(10), new Number(5));
        add.print();
        assertEquals(15, add.eval(""));
        add.derivative("");
        add.print();
    }
}