package ru.nsu.laptev;

import java.util.ArrayList;

/**
 * Класс для описания объекта Колода
 */
public class Deck extends Card
{
    protected int _amount = 52;
    ArrayList<ArrayList<String>> deck = new ArrayList<>();

    /**
     *Метод для создания игральной колоды
     */
    public ArrayList<ArrayList<String>> generatedeck()
    {
        for (int i = 0;i < _amount;i++)
        {
            ArrayList<String> tmp_deck = new ArrayList<>();
            tmp_deck.add(names[i % 13]);
            tmp_deck.add(suits[i / 13]);
            deck.add(tmp_deck);
        }
        return deck;
    }

    /**
     *Метод для взятия карты из колоды
     */
    public ArrayList<String> takecard()
    {
        ArrayList<String> card = deck.get(deck.size() - 1);
        deck.remove(deck.size()-1);
        return card;
    }

}
