package ru.nsu.laptev;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Deck main_deck = new Deck();
        Map<String,Integer> values = main_deck.CreateDict();

        Boolean isInGame = true;
        int cnt = 0;

        GameInfo();

        while(cnt < 1)
        {
            Dealler dealer = new Dealler();
            Player player = new Player();

            main_deck.deck = main_deck.GenerateDeck();

            main_deck.WriteDeck();


            cnt++;
        }

    }

    public static void GameInfo()
    {
        System.out.println("Добро пожаловать в БлекДжек!");
    }

    public static void PlayRound(int numb_of_round, Dealler dealer,Player player, Deck main_deck, Map<String,Integer> values)
    {
        dealer.ShuffleDeck(main_deck);
        System.out.println("Раунд " + numb_of_round);
        for (int i = 0;i < 4;i++)
        {
            if (i%2 == 0) {
                dealer.DealCards(main_deck,player.hand);
            }
            else
                dealer.DealCards(main_deck, dealer.hand);
        }
        System.out.println("Дилер раздал карты\nВаши карты: [");
        for (int i = 0;i < 2;i++)
        {
            System.out.print(player.hand.get(0).get(0) +" "+ player.hand.get(0).get(1));
            
        }

    }
}

