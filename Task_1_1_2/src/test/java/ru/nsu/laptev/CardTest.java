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
        String[] suits = {"Черви", "Буби", "Трефы", "Пики"};
        assertArrayEquals(card.suits, suits);
        assertEquals(dictionary.get("Туз"), 11);

        Card card1 = new Card("Буби", "Король");
        assertEquals(card1.name, "Король");
        assertEquals(card1.values[4], 6);
    }
}