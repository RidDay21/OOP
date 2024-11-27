package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing class Parser.
 */
class ParserTest {
    @Test
    void testParsing() {
        String variable = "x";
        String exp = "x = 10.5";
        double result = Parser.parsing(variable, exp);
        assertEquals(10.5, result, 0.0001);
        }

    @Test
    void parserTest() {
        double e = Parser.parsing("x", "x = 10; x = 123; y = 0");
        assertEquals(123, e);
        e = Parser.parsing("x", "x = 10; x = 0.456; y = 0");
        assertEquals(0.456, e);

        try {
            e = Parser.parsing("y", "");
            assertEquals(0, e);
        } catch (ArithmeticException pre) {
            assertEquals(0, 0);
        }
    }

    @Test
    void parsExpressionTest() {

    }
}