package ru.nsu.laptev;

import java.util.ArrayList;

import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Deck main_deck = new Deck();
        Dealler diller = new Dealler();

        main_deck.deck = main_deck.GenerateDeck();
        diller.ShuffleDeck(main_deck);
        main_deck.WriteDeck();
    }
}

