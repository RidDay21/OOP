package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();
    @Test
    void sampleTest() {
        String input;
        InputStream inContent;
        input = "0\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Game.game(1);

        Game.hello();

        Player pl = new Player();
        Dealer dlr = new Dealer();
        Deck deck = new Deck();
        deck.deck = deck.generate_deck();
        Card card = new Card();
        Map<String, Integer> values = card.dict();

        Game.result(pl, dlr, 0);
        assertEquals(pl.victories, 0);
        assertEquals(dlr.victories, 1);
        Game.result(pl, dlr, 1);
        assertEquals(pl.victories, 0);
        assertEquals(dlr.victories, 1);
        Game.result(pl, dlr, 3);
        assertEquals(pl.victories, 1);
        assertEquals(dlr.victories, 1);

        input = "0\n";
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        dlr.new_one();
        pl.new_one();

        game.round(1, dlr, pl, deck, values);
    }

}