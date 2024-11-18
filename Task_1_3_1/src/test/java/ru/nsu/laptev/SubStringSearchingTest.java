package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubStringSearchingTest {
    @Test
    void buildPrefixTable() {
        String str = "aabcaaabc";
        ArrayList<Integer> f = new ArrayList<>();
        char[] pattern = str.toCharArray();
        f.add(0);
        f.add(1);
        f.add(0);
        f.add(0);
        f.add(1);
        f.add(2);
        f.add(2);
        f.add(3);
        f.add(4);
        assertEquals(f, SubStringSearching.buildPrefixTable(pattern, str.length()));

        String bigStr = "aabcaaabcaaabcaaadffdfcaaabcaabcaabcaaabcaaabc";
        System.out.println("----");
        ArrayList<Integer> list =  SubStringSearching.kmp_algorithm(bigStr, pattern);
        f = new ArrayList<>();
        f.add(0);
        f.add(5);
        f.add(32);
        f.add(37);
        assertEquals(list, f);

    }

}