package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Класс для создания нашего диллера.
 */
public class Dealer extends Player {
    /**
     * Метод для переименования колоды (Аргумент exmp отвечает за переданную колоду).
     */
    public void shuffle(Deck exmp) {
        Collections.shuffle(exmp.deck);
    }

    /**
     * Метод для раздачи карт (Аргумент exmp1 - колода, hand - рука игрока,
     * в которую выдаются карты).
     */
    public void deal(Deck exmp1, ArrayList<ArrayList<String>> hand) {
        int cardIndex = exmp1.deck.size() - 1;
        hand.add(exmp1.deck.get(cardIndex));
        exmp1.deck.remove(cardIndex);
    }

    /**
     * Method for implementation of dealer's first turn.
     */
    public void firstTurn(Map<String, Integer> values) {
        System.out.print("Ход дилера\n-------\nДилер открывает закрытую карту "
                + hand.get(1).get(0)  + " " + hand.get(1).get(1));
        int value = values.get(hand.get(1).get(0));
        System.out.println(" (" + value + ")");
    }

    /**
     * Метод для реализации ходов Дилера (Аргументы: deck - колода, values - значения карт.
     * player - наш игрок.
     */
    public void turn(Deck deck, Map<String, Integer> values, Player player) {
        player.cards(player.hand.size(), values, false);
        cards(hand.size(), values, true);
        while (score < 17 && (player.score > score)) {
            ArrayList<String> card = deck.take_card();
            hand.add(card);
            int value = values.get(card.get(0));
            score += value;
            if (score > 21) {
                for (int i = 0; i < hand.size(); i++) {
                    if (is_ace(hand.get(i).get(0)) == 1) {
                        bust = 1;
                        break;
                    }
                }
            }
            System.out.println("Дилер открывает карту " + card.get(0)
                    + " " + card.get(1) + " (" + value + ")");
            player.cards(player.hand.size(), values, false);
            cards(hand.size(), values, true);
            if (player.score < score) {
                break;
            }
        }
    }
}
