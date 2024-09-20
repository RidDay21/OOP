package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MainTest {
@Test
    void sampleTest() {
        Deck deck = new Deck();
        ArrayList<ArrayList <String>> maindeck = deck.generatedeck();
        assertEquals(maindeck.size(),52);
}
}