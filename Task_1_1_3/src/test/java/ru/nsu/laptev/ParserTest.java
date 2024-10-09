package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Parser.
 */
class ParserTest {
    @Test
    void sampleTest() {
        int e = Parser.parsing("x", "x = 10; x = 123; y = 0");
        assertEquals(123, e);
        e = Parser.parsing("y", "");
        assertEquals(0, e);
        Parser parser = new Parser();
    }
}