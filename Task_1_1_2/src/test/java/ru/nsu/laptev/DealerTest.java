package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;


class DealerTest {
    Dealer dlr = new Dealer();
    Player pl = new Player();
    Deck deck = new Deck();
    Card card = new Card();
    Map<String, Integer> values = card.dict();

    @Test
    void sampleTest() {
        assertEquals(dlr.victories, 0);
        assertEquals(dlr.bust, 0);
        deck.deck = deck.generate_deck();
        assertEquals(deck.deck.size(), 52);
        assertEquals(dlr.hand.size(), 0);
        dlr.deal(deck, dlr.hand);
        assertEquals(dlr.hand.size(), 1);
        dlr.deal(deck, dlr.hand);
        assertEquals(dlr.hand.size(), 2);
        dlr.deal(deck, pl.hand);
        dlr.deal(deck, pl.hand);
        assertEquals(deck.deck.size(), 52 - 4);
        int size = deck.deck.size();
        dlr.shuffle(deck);
        assertEquals(deck.deck.size(), size);
        assertEquals(dlr.is_ace("Туз"), 1);
        assertEquals(dlr.is_ace("Двойка"), 0);
        dlr.score = 21;
        assertEquals(dlr.score, 21);
        dlr.new_one();
        assertEquals(dlr.score, 0);

        dlr.deal(deck, dlr.hand);
        dlr.deal(deck, dlr.hand);

        dlr.firstTurn(values);

        dlr.turn(deck, values, pl);

        Game.result(pl, dlr, 3);
        assertEquals(dlr.victories, 0);
        Game.result(pl, dlr, 1);
        assertEquals(dlr.victories, 0);
        Game.result(pl, dlr, 0);
        assertEquals(dlr.victories, 1);

    }
}