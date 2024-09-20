package ru.nsu.laptev;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {
    @Test
    void sampleTest()
    {
        Deck deck = new Deck();
        ArrayList<ArrayList<String>> maindeck = deck.generatedeck();
        assertEquals(maindeck.size(),52);
    }
}