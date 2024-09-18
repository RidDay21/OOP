package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Deck extends Card
{
    protected int _amount = 52;
    public ArrayList<ArrayList<String>> GenerateDeck()
    {
        ArrayList<ArrayList<String>> deck = new ArrayList<>();
        for (int i = 0;i < _amount;i++)
        {
            ArrayList<String> tmp_deck = new ArrayList<>();
            tmp_deck.add(names[i % 13]);
            tmp_deck.add(suits[i / 13]);
            deck.add(tmp_deck);
        }
        return deck;
    }
    
    public void WriteDeck(ArrayList<ArrayList<String>> deck) {
        for (int i = 0; i < 52; i++) {
            System.out.println("Масть: " + deck.get(i).get(0) + " Data: " + deck.get(i).get(1));
        }
    }

}
