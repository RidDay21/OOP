package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DeckTest {
    @Test
    void sampleTest() {
        Deck deck = new Deck();
        assertEquals(deck.names[3], "Пятерка");
        ArrayList<ArrayList<String>> maindeck = deck.generate_deck();
        assertEquals(maindeck.size(), 52);
        assertEquals(deck.amount, 52);
        String[] proof = {"Туз", "Черви"};
        ArrayList<String> proof1 = deck.take_card();
        assertEquals(proof[0], proof1.get(0));
    }
}