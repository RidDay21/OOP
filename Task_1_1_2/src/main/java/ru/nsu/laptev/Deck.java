package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Deck extends Card
{
    protected int _amount = 52;
    ArrayList<ArrayList<String>> deck = new ArrayList<>();
    public ArrayList<ArrayList<String>> GenerateDeck()
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

    public void WriteDeck() {
        for (int i = 0; i < 52; i++) {
            System.out.println("Масть: " + deck.get(i).get(0) + " Data: " + deck.get(i).get(1));
        }
    }

    public ArrayList<String> TakeCard()
    {
        ArrayList<String> card = deck.get(deck.size() - 1);
        deck.remove(deck.size()-1);
        return card;
    }

}
