package ru.nsu.laptev;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 */
public class SubStringSearching {

    public static ArrayList<Long> find(String filename, String target) throws IOException {
        byte[] pattern = target.getBytes(StandardCharsets.UTF_8);
        int[] prefixTable = buildPrefixTable(pattern);
        ArrayList<Long> foundIndices = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(filename)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            long ____textIndex_____ = 0;
            long cntSyms = 0;
            int j = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    int octetNumber = getOctetNumber(buffer[i]);
                    cntSyms += octetNumber;
                    while (j > 0 && buffer[i] != pattern[j]) {
                        j = prefixTable[j - 1];
                    }
                    if (buffer[i] == pattern[j]) {
                        j++;
                        if (j == pattern.length) {
                            foundIndices.add(cntSyms - pattern.length);
                            j = prefixTable[j - 1];
                        }
                    }
                }
            }
        }
        return foundIndices;
    }

    private static final int BUFFER_SIZE = 4096;

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

    private static int getOctetNumber(byte curByte) {
        if ((curByte & 0b10000000) == 0) {
            return 1;
        } else if ((curByte & 0b11100000) == 0b11000000) {
            return 2;
        } else if ((curByte & 0xF0) == 0b11100000) {
            return 3;
        } else if ((curByte & 0b11111000) == 0b11110000) {
            return 4;
        } else {
            return 0;
        }
    }
}
