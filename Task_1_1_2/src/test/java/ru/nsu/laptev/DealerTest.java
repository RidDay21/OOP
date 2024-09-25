package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;


class DealerTest {
    Dealer dl = new Dealer();
    Player pl = new Player();
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
        dl.deal(deck, dl.hand);
        assertEquals(dl.hand.size(), 2);
        dl.deal(deck, pl.hand);
        dl.deal(deck, pl.hand);
        assertEquals(deck.deck.size(), 52 - 4);
        int size = deck.deck.size();
        dl.shuffle(deck);
        assertEquals(deck.deck.size(), size);
        assertEquals(dl.is_ace("Туз"), 1);
        assertEquals(dl.is_ace("Двойка"), 0);
        dl.score = 21;
        assertEquals(dl.score, 21);
        dl.new_one();
        assertEquals(dl.score, 0);

        dl.deal(deck, dl.hand);
        dl.deal(deck, dl.hand);

        dl.firstTurn(values);

        dl.turn(deck, values, pl);


    }
}