package ru.nsu.laptev;

import java.util.Map;
import java.util.HashMap;

/**
 * Класс для создания наших
 */
public class Card {
    protected String[] suits = {"Черви", "Буби", "Трефы", "Пики"};
    protected String[] names = {"Двойка", "Тройка", "Четверка", "Пятерка", "Шестерка", "Семерка", "Восьмерка", "Девятка", "Десятка", "Валет", "Дама", "Король", "Туз"};
    protected int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    /**
     * @return
     */
    public Map<String, Integer> CreateDict() {
        Map<String, Integer> valueDictionary = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            valueDictionary.put(names[i], values[i]);
        }
        return valueDictionary;
    }

    public String suit;
    public String name;

    public Card(String _suit, String _name) {
        suit = _suit;
        name = _name;
    }

    public Card() {
    }

    ;
}
