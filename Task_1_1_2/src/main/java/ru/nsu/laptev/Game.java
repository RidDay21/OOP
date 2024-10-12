package ru.nsu.laptev;

import java.util.Map;

/**
 * Class for implementation of game.
 */
public class Game {

    /**
     * Method for launching a game.
     * Argument flag - IF -1 --  play infinite (for a long time), if n - play n rounds.
     */
    public static void game(int flag) {
        Deck mainDeck = new Deck();
        Card card = new Card();
        Dealer dl = new Dealer();
        Player pl = new Player();
        Game game = new Game();
        Map<String, Integer> values = card.dict();

        int cnt = 1;
        int numbOfRounds;

        if (flag == -1) {
            numbOfRounds = Integer.MAX_VALUE;
        } else {
            numbOfRounds = flag;
        }

        hello();

        while (numbOfRounds > 0) {
            pl.new_one();
            dl.new_one();

            mainDeck.deck = mainDeck.generate_deck();
            game.round(cnt, dl, pl, mainDeck, values);
            cnt++;
            numbOfRounds--;
        }
    }


    /**
     * Method for just HELLO.
     */
    public static void hello() {
        System.out.println("Добро пожаловать в БлекДжек!");
    }

    /**
     * Метод для подведения итогов нашего раунла.
     * Аргументы: player - игрок, dealer - диллер,
     * result - кто выиграл(3 - игрок выиграл, 1 - ничья, 0 - диллер),
     * flag - указатель на то, нужно ли играть дилеру).
     */
    public static void result(Player player, Dealer dealer, int result) {
        switch (result) {
            case 3:
                player.victories++;
                System.out.print("Вы выиграли. Счёт " + player.victories
                        + ":" + dealer.victories + " в ");
                if (player.victories > dealer.victories) {
                    System.out.println("вашу пользу.");
                } else {
                    System.out.println("не вашу пользу.");
                }
                break;
            case 0:
                dealer.victories++;
                System.out.print("Вы проиграли. Счёт " + player.victories
                        + ":" + dealer.victories + " в ");
                if (player.victories > dealer.victories) {
                    System.out.println("вашу пользу.");
                } else {
                    System.out.println("не вашу пользу.");
                }
                break;
            case 1:
                System.out.print("Вы сыграли вничью. Cчет " + player.victories
                        + ":" + dealer.victories + " в ");
                if (player.victories > dealer.victories) {
                    System.out.println("вашу пользу.");
                } else {
                    System.out.println("не вашу пользу.");
                }
                break;
            default:
                break;
        }
    }

    /**
     * Метод для реализации нашего раунда.
     * Аргументы: round - номер раунда, dlr - дилер, pl - иргок,
     * values - значения карт.
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
        boolean critflag = true; //flag for our dealer// .
        pl.cards(pl.hand.size(), values, false);
        dlr.cards(1, values, true);
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
                {
                    if (istaking == 1) {
                        pl.cards(pl.hand.size(), values, false);
                        dlr.cards(1, values, true);
                    }
                }
            }
        }
        if (critflag) {
            dlr.firstTurn(values);
            if (dlr.score > pl.score) {
                result(pl, dlr, 0);
            } else {
                dlr.turn(deck, values, pl);
                if (dlr.score == pl.score) {
                    result(pl, dlr, 1);
                } else if (dlr.score > 21) {
                    result(pl, dlr, 3);
                } else if (dlr.score > pl.score) {
                    result(pl, dlr, 0);
                } else {
                    result(pl, dlr, 3);
                }
            }
        }
    }
}
