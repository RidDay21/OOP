package ru.nsu.laptev;

//import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Map;

import org.junit.jupiter.api.Test;


class PlayerTest {
    Player pl = new Player();
    Deck deck = new Deck();
    Card card = new Card();
    Map<String, Integer> values = card.dict();

    @Test
    void sampleTest() {
        assertEquals(pl.victories, 0);
        pl.victories++;
        assertEquals(pl.victories, 1);
        assertEquals(pl.bust, 0);
        assertEquals(pl.hand.size(), 0);
        pl.score = 4;
        assertEquals(pl.score, 4);
        pl.new_one();
        assertEquals(pl.score, 0);
        assertEquals(pl.is_ace("Туз"), 1);
        assertEquals(pl.is_ace("Двойка"), 0);

        deck.deck = deck.generate_deck();
        String input;
        InputStream inContent;
        int tmp;

        input = "1\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        tmp = pl.make_turn(deck, values);
        assertEquals(tmp, 1);
        assertEquals(pl.hand.size(), 1);

        input = "1\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        tmp = pl.make_turn(deck, values);
        assertEquals(tmp, 1);
        assertEquals(pl.hand.size(), 2);

        input = "0\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        assertEquals(pl.make_turn(deck, values), 0);
        assertEquals(pl.hand.size(), 2);

        pl.cards(2, values, false);
    }
}