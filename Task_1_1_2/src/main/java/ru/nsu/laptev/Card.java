package ru.nsu.laptev;

/**
 *
 */
public class Card
{
    protected String [] suits = {"Черви","Буби","Трефы","Пики"};
    protected String [] names = {"Двойка","Тройка","Четверка","Пятерка","Шестерка","Семерка","Восьмерка","Девятка","Десятка","Валет","Дама","Король","Туз"};

    public String[][] GenerateDeck()
    {
        String [][] deck = new String[52][2];
        int indexSuit = 0;
        int indexOfName = 0;
        for (int i = 0;i < 52;i++)
        {
                deck[i][0] = suits[i / 13];
                deck[i][1] = names [i % 13];
        }
        return deck;
    }
 }
