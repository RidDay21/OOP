package ru.nsu.laptev;

import java.util.Map;

public class Game {

    public static void game() {
        Deck mainDeck = new Deck();
        Dealer dealer = new Dealer();
        Player player = new Player();
        Game game = new Game();
        Map<String, Integer> values = mainDeck.dict();

        Boolean isInGame = true;
        int cnt = 1;

        hello();

        while (true) {
            dealer.score = 0;
            player.score = 0;
            player.hand.clear();
            dealer.hand.clear();

            mainDeck.deck = mainDeck.generate_deck();
            game.round(cnt, dealer, player, mainDeck, values);
            cnt++;
        }
    }

    public static void hello() {
        System.out.println("Добро пожаловать в БлекДжек!");
    }

    /**
     * Метод для подведения итогов нашего раунла
     * Аргументы: player - игрок, dealer - диллер,
     * result - кто выиграл(3 - игрок выиграл, 1 - ничья, 0 - диллер)
     * flag - указатель на то, нужно ли играть дилеру)
     */
    public static void result(Player player, Dealer dealer, int result) {
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

    public void round(int round, Dealer dlr, Player pl, Deck deck,
                      Map<String, Integer> values) {
        dlr.shuffle(deck);
        System.out.println("\nРаунд " + round);
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                dlr.deal(deck, pl.hand);
                pl.score += values.get(pl.hand.get(i / 2).get(0));
            } else {
                dlr.deal(deck, dlr.hand);
                dlr.score += values.get(dlr.hand.get(i / 2).get(0));
            }
        }
        System.out.println("Дилер раздал карты");
        int istaking = 1;
        boolean critflag = true;//флаг, показывающий нужно ли играть дилеру
        pl.cards(pl.hand.size(), values);
        dlr.cards(dlr.hand.size(), values, true);
        while (istaking == 1) {
            if (pl.score > 21) {
                result(pl, dlr, 0);
                istaking = 0;
                critflag = false;
            } else if (pl.score == 21) {
                result(pl, dlr, 3);
                istaking = 0;
                critflag = false;
            }
            if (critflag) {
                istaking = pl.make_turn(deck, values);
                pl.cards(pl.hand.size(), values);
                dlr.cards(dlr.hand.size(), values, true);
            }
        }
        if (critflag) {
            dlr.turn(deck, values, pl);
            if (dlr.score == pl.score)
                result(pl, dlr, 1);
            else if (dlr.score > 21)
                result(pl, dlr, 3);
            else if (dlr.score > pl.score)
                result(pl, dlr, 0);
            else if (pl.score > dlr.score)
                result(pl, dlr, 3);
        }
    }
}
