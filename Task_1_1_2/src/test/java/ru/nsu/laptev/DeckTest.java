package ru.nsu.laptev;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {
    @Test
    void sampleTest()
    {
        Deck deck = new Deck();
        ArrayList<ArrayList<String>> maindeck = deck.generate_deck();
        assertEquals(maindeck.size(),52);
        assertEquals(deck._amount,52);
        String[] proof = {"Двойка", "Черви"};
        ArrayList<String> proof1 = deck.take_card();
        assertEquals(proof[0], proof[0]);
    }
}