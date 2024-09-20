package ru.nsu.laptev;

import java.util.ArrayList;

import java.util.Map;
import java.util.Scanner;

/**
 * Класс для описывания действий нашего игрока
 */
public class Player {
    public int victories = 0;
    public int score;
    public int bust = 0;//перебор
    public ArrayList<ArrayList<String>> hand = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    /**
     * @param deck
     * @param values
     * @return
     */
    public int MakeTurn(Deck deck, Map<String, Integer> values) {
        System.out.println("Ваш ход\n-------\n" +
                "Введите \"1\", чтобы взять карту, и \"0\", чтобы остановиться...");
        int numb = scanner.nextInt();//выбранный номер
        switch (numb) {
            case (1):
                ArrayList<String> card = deck.TakeCard();
                hand.add(card);
                int value = values.get(card.get(0));
                score += value;
                if (score > 21) {
                    for (int i = 0; i < hand.size(); i++) {
                        if (hand.get(i).get(0) == "Туз") {
                            bust = 1;
                            break;
                        }
                    }
                }
                System.out.println("Вы открыли карту " + card.get(0) + " " + card.get(1) +
                        " (" + value + ")");
                return 1;
            case (0):
                System.out.println();
                return 0;
        }
        return 0;
    }

    /**
     * @param amountOfCards
     * @param values
     */
    public void WriteCards(int amountOfCards, Map<String, Integer> values) {
        System.out.print("Ваши карты: [");
        score = 0;
        for (int i = 0; i < amountOfCards; i++) {
            int value = values.get(hand.get(i).get(0));
            if (hand.get(i).get(0) == "Туз" && bust > 0) {
                value = 1;
            }
            score += value;
            System.out.print(hand.get(i).get(0) + " " + hand.get(i).get(1) + " (" + value + ")");
            if (i + 1 != amountOfCards)
                System.out.print(", ");
        }
        System.out.println("] -> " + score);
    }
}
