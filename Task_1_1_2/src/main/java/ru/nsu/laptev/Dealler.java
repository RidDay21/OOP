package ru.nsu.laptev;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Random;

/**
 * Класс для создания нашего диллера
 */
public class Dealler extends Player
{
    public void ShuffleDeck(ArrayList<ArrayList<String>> deck)
    {
        Collections.shuffle(deck);
    }

    public void DealCards(ArrayList<ArrayList<String>> deck, ArrayList<ArrayList<String>> hand, int amount_of_cards)
    {
        int cardIndex = deck.size() - 1;
        hand.add(deck.get(cardIndex));
        deck.remove(cardIndex);
    }
}
