package ru.nsu.laptev;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Card card = new Card();
        ArrayList<ArrayList<String>> deck = new ArrayList<>();
        
        deck = card.GenerateDeck();
        for (int i = 0;i < 52;i++)
        {
            System.out.println("Масть: " + deck[i][0] + " Data: " + deck[i][1]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание двумерного ArrayList<String>
        ArrayList<ArrayList<String>> twoDArray = new ArrayList<>();

        // Добавление элементов в двумерный ArrayList
        ArrayList<String> row1 = new ArrayList<>();
        row1.add("Строка 1, элемент 1");
        row1.add("Строка 1, элемент 2");
        twoDArray.add(row1);

        ArrayList<String> row2 = new ArrayList<>();
        row2.add("Строка 2, элемент 1");
        row2.add("Строка 2, элемент 2");
        twoDArray.add(row2);

        // Доступ к элементам двумерного ArrayList
        System.out.println(twoDArray.get(0).get(1)); // Выведет "Строка 1, элемент 2"
        System.out.println(twoDArray.get(1).get(0)); // Выведет "Строка 2, элемент 1"
    }
}
