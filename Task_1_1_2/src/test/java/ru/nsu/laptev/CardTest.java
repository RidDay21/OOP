package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class CardTest {
@Test
    void sampleTest() {
        Card card = new Card();
        Map <String,Integer> dictionary = card.dict();
        assertEquals(dictionary.get("Двойка"), 2);
    assertEquals(dictionary.get("Туз"), 11);
    }
}