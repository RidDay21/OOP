package ru.nsu.laptev;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for implementation of Cards
 */
public class Card {
    protected String[] suits = {"Черви", "Буби", "Трефы", "Пики"};
    protected String[] names = {"Двойка", "Тройка", "Четверка", "Пятерка", "Шестерка", "Семерка",
            "Восьмерка", "Девятка", "Десятка", "Валет", "Дама", "Король", "Туз"};
    protected int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    /**
     * Метод для создания нашей колоды.
     */
    public Map<String, Integer> dict() {
        Map<String, Integer> valueDictionary = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            valueDictionary.put(names[i], values[i]);
        }
        return valueDictionary;
    }

    public String suit;
    public String name;

    /**
     *Method-Constructor.
     */
    public Card(String suit, String name) {
        this.suit = suit;
        this.name = name;
    }

    public Card() {
    }

    ;
}
