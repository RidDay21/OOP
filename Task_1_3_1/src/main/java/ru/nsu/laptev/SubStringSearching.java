package ru.nsu.laptev;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SubStringSearching {

    /**
     * Method for creating prefix-function table for giving pattern.
     *
     * @param pattern
     * @param m
     * @return
     */
    public ArrayList<Integer> build_prefix_table(char[] pattern, int m) {
        // Таблица хранит информацию о максимально
        // длинных правильных префиксах для каждой позиции в подстроке.
        ArrayList<Integer> prefix_table = new ArrayList<>(m);
        // In prefix_table contains length of the biggest
        // right prefix for position i in substring
        int curIndex = 0;
        prefix_table.add(0); // Инициализируем первый элемент таблицы

        for (int i = 1; i < m; i++) {
            while (curIndex > 0 && pattern[i] != pattern[curIndex]) {
                curIndex = prefix_table.get(curIndex - 1);
            }
            if (pattern[i] == pattern[curIndex]) {
                curIndex++;
            }
            prefix_table.set(i, curIndex); // Устанавливаем значение в таблице
        }
        return prefix_table;
    }

    public ArrayList<Integer> kmp_algorithm(String string, char[] pattern, int count) {
        int stringLength = string.length();
        int patLength = pattern.length;
        ArrayList<Integer> prefix_table = build_prefix_table(pattern, patLength);

        ArrayList<Integer> found_indices = new ArrayList<>();
        count = 0;
        int i = 0;
        int j = 0;

        while (i < stringLength) {
            if (string.charAt(i) == pattern[j]) {
                i++;
                j++;

                if (j == patLength) {
                    found_indices.set(count - 1, i - patLength);
                    j = prefix_table.get(j - 1);
                }
            } else {
                if (j > 0) {
                    j = prefix_table.get(j - 1);
                } else {
                    i++;
                }
            }
        }

        prefix_table.clear();
        return found_indices;
    }





}
