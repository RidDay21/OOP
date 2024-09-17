package ru.nsu.laptev;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Card card = new Card();
        String[][] deck = new String[52][2];
        deck = card.GenerateDeck();
        for (int i = 0;i < 52;i++)
        {
            System.out.println("Масть: " + deck[i][0] + " Data: " + deck[i][1]);
        }
    }
}

