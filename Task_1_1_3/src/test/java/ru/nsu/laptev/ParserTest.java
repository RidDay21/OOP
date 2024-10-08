package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    @Test
    void sampleTest() {
        int e = Parser.Parsing("x", "x = 10; x = 123; y = 0");
        assertEquals(123, e);
        e = Parser.Parsing("y", "");
        assertEquals(0, e);
        Parser parser = new Parser();
    }
}