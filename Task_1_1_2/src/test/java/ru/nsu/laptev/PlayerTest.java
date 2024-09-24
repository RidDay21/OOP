package ru.nsu.laptev;

//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void sampleTest() {
        Player pl = new Player();
        assertEquals(pl.victories, 0);
        assertEquals(pl.bust, 0);
        assertEquals(pl.hand.size(), 0);
    }
}