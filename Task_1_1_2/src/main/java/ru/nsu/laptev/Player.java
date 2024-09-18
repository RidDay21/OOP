package ru.nsu.laptev;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * Класс для описывания действий нашего игрока
 */
public class Player {
    public ArrayList<ArrayList<String>> hand;
    public Deck deck1 = new Deck();
    public Scanner scanner = new Scanner(System.in);

    public void MakeTurn(ArrayList<ArrayList<String>> deck)
    {
        System.out.println("Введите \"1\", чтобы взять карту, и \"0\", чтобы остановиться...");
        int numb = scanner.nextInt();//выбранный номер
        switch (numb)
        {
            case (1):
                ArrayList<String> card = deck1.TakeCard();

        }
    }
}
