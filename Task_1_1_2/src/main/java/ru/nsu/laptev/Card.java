package ru.nsu.laptev;

import java.util.ArrayList;
/**
 *
 */
public class Card
{
    protected String [] suits = {"Черви","Буби","Трефы","Пики"};
    protected String [] names = {"Двойка","Тройка","Четверка","Пятерка","Шестерка","Семерка","Восьмерка","Девятка","Десятка","Валет","Дама","Король","Туз"};
    protected String [] short_names = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public ArrayList<ArrayList<String>> GenerateDeck()
    {
        ArrayList<ArrayList <String>> deck = new ArrayList<>();
        for (int i = 0;i < 52;i++)
        {
            ArrayList<String> card = new ArrayList<>();
            card.add(suits[i / 13]);
            card.add(short_names[i % 13]);
            deck.add(card);
        }

        return deck;
    }
 }
