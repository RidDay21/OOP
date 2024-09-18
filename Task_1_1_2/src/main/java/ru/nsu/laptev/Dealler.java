package ru.nsu.laptev;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Random;

/**
 * Класс для создания нашего диллера
 */
public class Dealler extends Player
{
    public void ShuffleDeck(Deck exmp1)
    {
        Collections.shuffle(exmp1.deck);
    }

    public void DealCards(Deck exmp1, ArrayList<ArrayList<String>> hand, int amount_of_cards)
    {
        int cardIndex = exmp1.deck.size() - 1;
        hand.add(exmp1.deck.get(cardIndex));
        exmp1.deck.remove(cardIndex);
    }
}
