package ru.nsu.laptev;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeallerTest {
@Test
    void sampleTest() {
    Deck mainDeck = new Deck();
    Dealer dl = new Dealer();
    assertEquals(dl.victories,0);
    assertEquals(dl.bust,0);
    mainDeck.deck = mainDeck.generate_deck();
    assertEquals(mainDeck.deck.size(),52);
    assertEquals(dl.hand.size(), 0);
    dl.deal(mainDeck, dl.hand);
    assertEquals(dl.hand.size(), 1);
    assertEquals(mainDeck.deck.size(),51);
    int size = mainDeck.deck.size();
    dl.shuffle(mainDeck);
    assertEquals(mainDeck.deck.size(), size);




    }
}