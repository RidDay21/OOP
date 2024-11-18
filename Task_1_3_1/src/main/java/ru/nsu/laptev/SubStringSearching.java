package ru.nsu.laptev;


import java.util.ArrayList;


public class SubStringSearching {

    /**
     * Method for creating prefix-function table for giving pattern.
     *
     * @param pattern
     * @param patSize
     * @return
     */
        static ArrayList<Integer> buildPrefixTable(char[] pattern, int patSize) {
            // Таблица хранит информацию о максимально
            // длинных префиксах для каждой позиции в подстроке.
            ArrayList<Integer> prefix_table = new ArrayList<>();
            for (int i = 0; i < patSize; i++) {
                prefix_table.add(0);
            }

            int curIndex = 0;
            for (int i = 1; i < patSize; i++) {
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

    static ArrayList<Integer> kmp_algorithm(String string, char[] pattern) {
        int stringLength = string.length();
        int patLength = pattern.length;
        ArrayList<Integer> prefix_table = buildPrefixTable(pattern, patLength);

        ArrayList<Integer> found_indices = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < stringLength) {
            if (string.charAt(i) == pattern[j]) {
                i++;
                j++;

                if (j == patLength) {
                    found_indices.add (i - patLength);
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
