package ru.nsu.laptev;

//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

class DealerTest {
    Player pl = new Player();
    Dealer dl = new Dealer();
    Deck deck = new Deck();
    Card card = new Card();
    Map<String, Integer> values = card.dict();

    @Test
    void sampleTest() {
        assertEquals(dl.victories, 0);
        assertEquals(dl.bust, 0);
        deck.deck = deck.generate_deck();
        assertEquals(deck.deck.size(), 52);
        assertEquals(dl.hand.size(), 0);
        dl.deal(deck, dl.hand);
        assertEquals(dl.hand.size(), 1);
        assertEquals(deck.deck.size(), 51);
        int size = deck.deck.size();
        dl.shuffle(deck);
        assertEquals(deck.deck.size(), size);
        assertEquals(dl.is_ace("Туз"), 1);
        assertEquals(dl.is_ace("Двойка"), 0);
        dl.score = 21;
        assertEquals(dl.score, 21);
        dl.new_one();
        assertEquals(dl.score, 0);

        deck.deck = deck.generate_deck();
        String input;
        InputStream inContent;
        int tmp;

        input = "1\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        tmp = dl.make_turn(deck, values);
        assertEquals(tmp, 1);
        assertEquals(dl.hand.size(), 1);

        input = "1\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        tmp = dl.make_turn(deck, values);
        assertEquals(tmp, 1);
        assertEquals(dl.hand.size(), 2);

        input = "0\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        assertEquals(dl.make_turn(deck, values), 0);
        assertEquals(dl.hand.size(), 2);

        dl.cards(2, values);

    }
}