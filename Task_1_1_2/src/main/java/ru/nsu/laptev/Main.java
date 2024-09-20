package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Deck main_deck = new Deck();
        Dealler dealer = new Dealler();
        Player player = new Player();
        Map<String,Integer> values = main_deck.CreateDict();

        Boolean isInGame = true;
        int cnt = 1;

        GameInfo();

        while (cnt <= 6)
        {
            dealer.score = 0;
            player.score = 0;
            player.hand.clear();
            dealer.hand.clear();

            main_deck.deck = main_deck.GenerateDeck();

            //main_deck.WriteDeck();
            PlayRound(cnt, dealer, player, main_deck, values);
            cnt++;
        }
    }

    /**
     *
     */
    public static void GameInfo()
    {
        System.out.println("Добро пожаловать в БлекДжек!");
    }

    /**
     *
     * @param numb_of_round
     * @param dealer
     * @param player
     * @param main_deck
     * @param values
     */
    public static void PlayRound(int numb_of_round, Dealler dealer,Player player, Deck main_deck, Map<String,Integer> values)
    {
        dealer.ShuffleDeck(main_deck);
        System.out.println("\nРаунд " + numb_of_round);
        for (int i = 0;i < 4;i++)
        {
            if (i%2 == 0) {
                dealer.DealCards(main_deck,player.hand);
                player.score += values.get(player.hand.get(i/2).get(0));
            }
            else
            {
                dealer.DealCards(main_deck, dealer.hand);
                dealer.score += values.get(dealer.hand.get(i/2).get(0));
            }
        }
        System.out.println("Дилер раздал карты");
        int is_taking = 1;
        boolean crit_flag = true;//флаг, показывающий нужно ли играть дилеру
        while (is_taking == 1)
        {
            player.WriteCards(player.hand.size(), values);
            dealer.WriteCards(dealer.hand.size(), values, true);

            if (player.score > 21)
            {
                dealer.victories++;
                System.out.print("Вы пососали. Счёт " + player.victories + ":" + dealer.victories + " в ");
                if (player.victories > dealer.victories)
                    System.out.println("вашу пользу.");
                else
                    System.out.println("не вашу пользу.");
                is_taking = 0;
                crit_flag = false;
            }

            if (player.score == 21)
            {
                player.victories++;
                System.out.print("Вы выиграли. Счёт " + player.victories + ":" + dealer.victories + " в ");
                if (player.victories > dealer.victories)
                    System.out.println("вашу пользу.");
                else
                    System.out.println("не вашу пользу.");
                crit_flag = false;
                is_taking = 0;
            }
            else if (crit_flag)
                is_taking = player.MakeTurn(main_deck, values);
        }
        if (crit_flag)
            dealer.DealersTurn(main_deck, values, player);
        if (dealer.score == player.score)
        {
            System.out.print("Вы сыграли вничью. Cчет " + player.victories + ":" + dealer.victories + " в ");
            if (player.victories > dealer.victories)
                System.out.println("вашу пользу.");
            else
                System.out.println("не вашу пользу.");
        }
        else if (dealer.score > 21 && crit_flag)
        {
            player.victories++;
            System.out.print("Вы выиграли. Счёт " + player.victories + ":" + dealer.victories + " в ");
            if (player.victories > dealer.victories)
                System.out.println("вашу пользу.");
            else
                System.out.println("не вашу пользу.");
            crit_flag = false;
        }
        else if (dealer.score > player.score)
        {
            dealer.victories++;
            System.out.print("Вы пососали. Счёт " + player.victories + ":" + dealer.victories + " в ");
            if (player.victories > dealer.victories)
                System.out.println("вашу пользу.");
            else
                System.out.println("не вашу пользу.");
            is_taking = 0;
            crit_flag = false;
        }
        else if (player.score > dealer.score && crit_flag)
        {
            player.victories++;
            System.out.print("Вы выиграли. Счёт " + player.victories + ":" + dealer.victories + " в ");
            if (player.victories > dealer.victories)
                System.out.println("вашу пользу.");
            else
                System.out.println("не вашу пользу.");
            crit_flag = false;
        }
    }
}

