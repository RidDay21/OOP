package ru.nsu.laptev;

//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PlayerTest {
    Player pl = new Player();

    @Test
    void sampleTest() {
        assertEquals(pl.victories, 0);
        assertEquals(pl.bust, 0);
        assertEquals(pl.hand.size(), 0);
        pl.score = 4;
        assertEquals(pl.score, 4);
        pl.new_one();
        assertEquals(pl.score,0);
        assertEquals(pl.is_ace("Туз"), 1);
        assertEquals(pl.is_ace("Двойка"), 0);
    }
}