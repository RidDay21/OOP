package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
@Test
    void sampleTest()
    {
        Player pl = new Player();
        assertEquals(pl.victories,0);
        assertEquals(pl.bust, 0);

    }
}