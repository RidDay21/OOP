package ru.nsu.laptev;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Card card = new Card();
        ArrayList<ArrayList <String>> deck = new ArrayList<>();
        deck = card.GenerateDeck();
        for (int i = 0;i < 52;i++)
        {
            System.out.println("Масть: " + deck.get(i).get(0) + " Data: " + deck.get(i).get(1));
        }
    }
}

