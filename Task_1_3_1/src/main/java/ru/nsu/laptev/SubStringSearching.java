package ru.nsu.laptev;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Class for implementation searching a substring in the text.
 */
public class SubStringSearching {

    private static final int BUFFER_SIZE = 4096 * 2;

    /**
     * Main method for implementation a searching in the file.
     *
     * @param filename  filename.
     * @param subString suBtring.
     * @return array of indices with entering a substring.
     * @throws IOException if something goes wrong.
     */
    public static ArrayList<Long> find(String filename, String subString) throws IOException {
        byte[] pattern = subString.getBytes(StandardCharsets.UTF_8);
        System.out.println(pattern.length + ", " + subString.length());
        int[] prefixTable = buildPrefixTable(pattern);
        ArrayList<Long> foundIndices = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            long charIndex = 0; // Счетчик символов
            long byteIndex = 0; // Счетчик байтов
            int j = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    int charSize = getCharSize(buffer[i]);

                    while (j > 0 && buffer[i] != pattern[j]) {
                        j = prefixTable[j - 1];
                    }
                    if (buffer[i] == pattern[j]) {
                        j++;
                        if (j == pattern.length) {
                            foundIndices.add(charIndex - subString.length() + 1);
                            j = prefixTable[j - 1];
                        }
                    }
                    byteIndex++;
                    charIndex += charSize;
                }
            }
        }
        return foundIndices;
    }


    private static int[] buildPrefixTable(byte[] pattern) {
        int[] prefixTable = new int[pattern.length];
        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = prefixTable[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                j++;
            }
            prefixTable[i] = j;
        }
        return prefixTable;
    }

    private static int getCharSize(byte b) {
        if ((b & 0b10000000) == 0) return 1; // ASCII
        if ((b & 0b11100000) == 0b11000000) return 1;
        if ((b & 0b11110000) == 0b11100000) return 1;
        if ((b & 0b11111000) == 0b11110000) return 1;
        return 0;
    }
}


