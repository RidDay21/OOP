package ru.nsu.laptev;

//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DealerTest {
    @Test
    void sampleTest() {
        Deck mainDeck = new Deck();
        Dealer dl = new Dealer();
        assertEquals(dl.victories, 0);
        assertEquals(dl.bust, 0);
        mainDeck.deck = mainDeck.generate_deck();
        assertEquals(mainDeck.deck.size(), 52);
        assertEquals(dl.hand.size(), 0);
        dl.deal(mainDeck, dl.hand);
        assertEquals(dl.hand.size(), 1);
        assertEquals(mainDeck.deck.size(), 51);
        int size = mainDeck.deck.size();
        dl.shuffle(mainDeck);
        assertEquals(mainDeck.deck.size(), size);
        assertEquals(dl.is_ace("Туз"), 1);
        assertEquals(dl.is_ace("Двойка"), 0);

    }
}