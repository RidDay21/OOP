package ru.nsu.laptev;

import java.util.ArrayList;

/**
 * Класс для описания объекта Колода.
 */
public class Deck {
    Card card = new Card();
    protected int amount = 52;
    ArrayList<ArrayList<String>> deck = new ArrayList<>();

    /**
     * Метод для создания игральной колоды.
     */
    public ArrayList<ArrayList<String>> generate_deck() {
        for (int i = 0; i < amount; i++) {
            ArrayList<String> tmpDeck = new ArrayList<>();
            tmpDeck.add(card.names[i % 13]);
            tmpDeck.add(card.suits[i / 13]);
            deck.add(tmpDeck);
        }
        return deck;
    }

    /**
     * Метод для взятия карты из колоды.
     */
    public ArrayList<String> take_card() {
        ArrayList<String> card = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return card;
    }

}
