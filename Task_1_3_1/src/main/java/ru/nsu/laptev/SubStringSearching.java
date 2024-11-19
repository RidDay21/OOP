package ru.nsu.laptev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Class for searching substring in file.txt.
 */
public class SubStringSearching {
    public static final int BUFFER_SIZE = 4096;

    /**
     * Method for creating prefix-function table for giving pattern.
     *
     * @param pattern pattern.
     * @param patSize pattern size.
     * @return prefix table.
     */
    static ArrayList<Integer> buildPrefixTable(char[] pattern, int patSize) {
        ArrayList<Integer> prefixTable = new ArrayList<>(patSize);
        for (int i = 0; i < patSize; i++) {
            prefixTable.add(0);
        }

        int curIndex = 0;
        for (int i = 1; i < patSize; i++) {
            while (curIndex > 0 && pattern[i] != pattern[curIndex]) {
                curIndex = prefixTable.get(curIndex - 1);
            }
            if (pattern[i] == pattern[curIndex]) {
                curIndex++;
            }
            prefixTable.set(i, curIndex);
        }
        return prefixTable;
    }

    /**
     * Method for reading from file and
     * doing kmp algorithm for searching substring.
     *
     * @param filePath path to file.
     * @param pattern  pattern.
     * @return array of first indexes of elements.
     * in every includes of substring.
     * @throws IOException if any IO error occurs.
     */
    static ArrayList<Long> kmpAlgorithm(String filePath, char[] pattern) throws
            IOException, FileNotFoundException {
        int patLength = pattern.length;
        ArrayList<Integer> prefixTable = buildPrefixTable(pattern, patLength);
        ArrayList<Long> foundIndices = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            Long textIndex = 0L;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String textBlock = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                int indexInString = 0;
                int indexInPattern = 0;
                while (indexInString < textBlock.length()) {
                    if (textBlock.charAt(indexInString) == pattern[indexInPattern]) {
                        indexInString++;
                        indexInPattern++;
                        if (indexInPattern == patLength) {
                            foundIndices.add(textIndex + indexInString - patLength);
                            indexInPattern = prefixTable.get(indexInPattern - 1);
                        }
                    } else {
                        if (indexInPattern > 0) {
                            indexInPattern = prefixTable.get(indexInPattern - 1);
                        } else {
                            indexInString++;
                        }
                    }
                }
                textIndex += textBlock.length();
            }
        }
        return foundIndices;
    }

}
