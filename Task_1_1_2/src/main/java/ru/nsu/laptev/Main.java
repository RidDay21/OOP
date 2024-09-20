package ru.nsu.laptev;

import java.util.Map;


/**
 * Метод нащей игры
 */
public class Main {
    public static void main(String[] args) {
        Deck mainDeck = new Deck();
        Dealer dealer = new Dealer();
        Player player = new Player();
        Map<String, Integer> values = mainDeck.CreateDict();

        Boolean isInGame = true;
        int cnt = 1;

        GameInfo();

        while (true) {
            dealer.score = 0;
            player.score = 0;
            player.hand.clear();
            dealer.hand.clear();

            mainDeck.deck = mainDeck.GenerateDeck();
            System.out.println(mainDeck.deck.size());
            //main_deck.WriteDeck();
            Round(cnt, dealer, player, mainDeck, values);
            cnt++;
        }
    }

    /**
     *Метод Приветствие
     */
    public static void GameInfo() {
        System.out.println("Добро пожаловать в БлекДжек!");
    }

    /**
     * Метод для подведения итогов нашего раунла
     * Аргументы: player - игрок, dealer - диллер,
     * result - кто выиграл(3 - игрок выиграл, 1 - ничья, 0 - диллер)
     * flag - указатель на то, нужно ли играть дилеру)
     */
    public static void WriteResult(Player player, Dealer dealer, int result) {
        switch (result) {
            case 3:
                player.victories++;
                System.out.print("Вы выиграли. Счёт " + player.victories +
                        ":" + dealer.victories + " в ");
                if (player.victories > dealer.victories)
                    System.out.println("вашу пользу.");
                else
                    System.out.println("не вашу пользу.");
                break;
            case 0:
                dealer.victories++;
                System.out.print("Вы проиграли. Счёт " + player.victories +
                        ":" + dealer.victories + " в ");
                if (player.victories > dealer.victories)
                    System.out.println("вашу пользу.");
                else
                    System.out.println("не вашу пользу.");
                break;
            case 1:
                System.out.print("Вы сыграли вничью. Cчет " + player.victories +
                        ":" + dealer.victories + " в ");
                if (player.victories > dealer.victories)
                    System.out.println("вашу пользу.");
                else
                    System.out.println("не вашу пользу.");
                break;
        }
    }

    /**
     * Метод для реализации нашего раунда
     * Аргументы: round - номер раунда, dlr - дилер, pl - иргок,
     * values - значения карт
     */
    public static void Round(int round, Dealer dlr, Player pl, Deck deck,
                             Map<String, Integer> values) {
        dlr.ShuffleDeck(deck);
        System.out.println("\nРаунд " + round);
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                dlr.DealCards(deck, pl.hand);
                pl.score += values.get(pl.hand.get(i / 2).get(0));
            } else {
                dlr.DealCards(deck, dlr.hand);
                dlr.score += values.get(dlr.hand.get(i / 2).get(0));
            }
        }
        System.out.println("Дилер раздал карты");
        int istaking = 1;
        boolean critflag = true;//флаг, показывающий нужно ли играть дилеру
        pl.WriteCards(pl.hand.size(), values);
        dlr.WriteCards(dlr.hand.size(), values, true);
        while (istaking == 1)
        {
            istaking = pl.MakeTurn(deck, values);
            pl.WriteCards(pl.hand.size(), values);
            dlr.WriteCards(dlr.hand.size(), values, true);

            if (pl.score > 21) {
                Main.WriteResult(pl, dlr, 0);
                istaking = 0;
                critflag = false;
            }
            else if (pl.score == 21)
            {
                Main.WriteResult(pl, dlr, 3);
                istaking = 0;
                critflag = false;
            }
        }
            if (critflag)
            {
                dlr.DealersTurn(deck, values, pl);
                if (dlr.score == pl.score)
                    Main.WriteResult(pl, dlr, 1);
                else if (dlr.score > 21)
                    Main.WriteResult(pl, dlr, 3);
                else if (dlr.score > pl.score)
                    Main.WriteResult(pl, dlr, 0);
                else if (pl.score > dlr.score)
                    Main.WriteResult(pl, dlr, 3);
            }
        }
    }




