package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void sampleTest()
    {
        String input;
        InputStream inContent;
        input = "0\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Game.game(1);

        Game.hello();
    }

}