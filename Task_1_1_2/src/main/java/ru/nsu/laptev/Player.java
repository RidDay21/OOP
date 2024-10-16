package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс для описывания действий нашего игрока.
 */
public class Player {
    public int victories = 0;
    public int score;
    public int bust = 0; //перебор
    public ArrayList<ArrayList<String>> hand = new ArrayList<>();

    /**
     * Method for checking card for Тузик.
     */
    public int is_ace(String name) {
        return name.equals("Туз") ? 1 : 0;
    }

    /**
     * Clear Method.
     */
    public void new_one() {
        bust = 0;
        score = 0;
        hand.clear();
    }

    /**
     * Метод для реализации выбора хода нашего игрока.
     * Аргументы: deck - колода, values - значения карт.
     */
    public int make_turn(Deck deck, Map<String, Integer> values) {
        System.out.println("Ваш ход\n-------\n"
                + "Введите \"1\", чтобы взять карту, и \"0\", чтобы остановиться...");
        Scanner scanner = new Scanner(System.in);
        int numb = scanner.nextInt();
        switch (numb) {
            case (1):
                int value = check(deck, values);
                System.out.println("Вы открыли карту " + hand.get(hand.size() - 1).get(0)
                        + " " + hand.get(hand.size() - 1).get(1) + " (" + value + ")");
                return 1;
            case (0):
                System.out.println();
                return 0;
            default:
                break;
        }
        return 0;
    }

    /**
     * Method for taking cards and checking is it win or boarder situation or not.
     */
    public int check(Deck deck, Map<String, Integer> values) {
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
        return value;
    }

    /**
     * Метод для вывода карт.
     * Аргументы: cards - кол-во карт, values - значения карт.
     */
    public void cards(int cards, Map<String, Integer> values, boolean isDl) {
        if (isDl) {
            System.out.print("Карты дилера: [");
        } else {
            System.out.print("Ваши карты: [");
        }
        score = 0;
        for (int i = 0; i < cards; i++) {
            int value = values.get(hand.get(i).get(0));
            if (is_ace(hand.get(i).get(0)) == 1 && bust > 0) {
                value = 1;
            }
            score += value;
            System.out.print(hand.get(i).get(0) + " " + hand.get(i).get(1)
                    + " (" + value + ")");
            if (i + 1 != cards) {
                System.out.print(", ");
            }
        }
        if (isDl && cards == 1) {
            System.out.println(", (закрытая карта)]\n");
        } else if (isDl && cards > 1) {
            System.out.println("] -> " + score + "\n");
        } else {
            System.out.println("] -> " + score);
        }
    }
}
