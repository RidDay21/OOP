package ru.nsu.laptev;

//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.Map;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class PlayerTest {
    Player pl = new Player();
    Deck mDeck = new Deck();
    Card card = new Card();
    Map<String, Integer> values = card.dict();

    @Test
    void sampleTest() {
        assertEquals(pl.victories, 0);
        assertEquals(pl.bust, 0);
        assertEquals(pl.hand.size(), 0);
        pl.score = 4;
        assertEquals(pl.score, 4);
        pl.new_one();
        assertEquals(pl.score, 0);
        assertEquals(pl.is_ace("Туз"), 1);
        assertEquals(pl.is_ace("Двойка"), 0);

        mDeck.deck = mDeck.generate_deck();
        String input = "1\n";
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        int tmp = pl.make_turn(mDeck, values);
        assertEquals(tmp,1);
    }
}