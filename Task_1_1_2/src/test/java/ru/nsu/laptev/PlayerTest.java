package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
@Test
    void sampleTest()
    {
        Player pl = new Player();
        assertEquals(pl.victories,0);
        assertEquals(pl.bust, 0);

        ArrayList<ArrayList<String>> tmp = new ArrayList<>();
        assertEquals(pl.hand.get(0).get(0), tmp.get(0).get(0));
    }
}