package ru.nsu.laptev;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Map;

/**
 * Класс для создания нашего диллера
 */
public class Dealer extends Player {
    /**
     * Метод для переименования колоды (Аргумент exmp отвечает за переданную колоду)
     */
    public void shuffle(Deck exmp) {
        Collections.shuffle(exmp.deck);
    }

    /**
     * Метод для раздачи карт (Аргумент exmp1 - колода, hand - рука игрока,
     * в которую выдаются карты)
     */
    public void deal(Deck exmp1, ArrayList<ArrayList<String>> hand) {
        int cardIndex = exmp1.deck.size() - 1;
        hand.add(exmp1.deck.get(cardIndex));
        exmp1.deck.remove(cardIndex);
    }

    /**
     * Метод для вывода карт(Аргумент cards - кол-во карт на руках,
     * values - значения карт, IsFirstRound - флаг
     */
    public void cards(int cards, Map<String, Integer> values, boolean isFirstRound) {
        System.out.print("Карты дилера: [");
        if (isFirstRound) {
            int value = values.get(hand.get(0).get(0));
            System.out.println(hand.get(0).get(0) + " " + hand.get(0).get(1) +
                    " (" + value + "), <закрытая карта>]\n");
        } else {
            score = 0;
            for (int i = 0; i < cards; i++) {
                int value = values.get(hand.get(i).get(0));
                if (hand.get(i).get(0) == "Туз" && bust > 0) {
                    value = 1;
                }
                score += value;
                System.out.print(hand.get(i).get(0) + " " + hand.get(i).get(1) +
                        " (" + value + ")");
                if (i + 1 != cards)
                    System.out.print(", ");
            }
            System.out.println("] -> " + score + "\n");
        }
    }

    /**
     * Метод для реализации ходов Дилера (Аргументы: deck - колода, values - значения карт
     * player - наш игрок
     */
    public void dlsturn(Deck deck, Map<String, Integer> values, Player player) {
        int value = values.get(hand.get(1).get(0));
        System.out.println("Ход дилера\n" +
                "-------\nДилер открывает закрытую карту " + hand.get(1).get(0) + "" +
                " " + hand.get(1).get(1) + " (" + value + ")");
        player.cards(player.hand.size(), values);
        cards(hand.size(), values, false);
        while (score < 17) {
            ArrayList<String> card = deck.take_card();
            hand.add(card);
            value = values.get(card.get(0));
            score += value;
            if (score > 21) {
                for (int i = 0; i < hand.size(); i++) {
                    if (hand.get(i).get(0) == "Туз") {
                        bust = 1;
                        break;
                    }
                }
            }
            System.out.println("Дилер открывает карту " + card.get(0) +
                    " " + card.get(1) + " (" + value + ")");
            player.cards(player.hand.size(), values);
            cards(hand.size(), values, false);
        }
    }
//    @Override
}
