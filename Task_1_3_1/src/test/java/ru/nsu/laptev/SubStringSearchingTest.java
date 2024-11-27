package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Class for testing, bro.
 */
class SubStringSearchingTest {
    @Test
    void buildPrefixTable() {
        String str = "aabcaaabc";
        ArrayList<Integer> f = new ArrayList<>();
//        f.add(0);
//        f.add(1);
//        f.add(0);
//        f.add(0);
//        f.add(1);
//        f.add(2);
//        f.add(2);
//        f.add(3);
//        f.add(4);
//        char[] pattern = str.toCharArray();
//        assertEquals(f, SubStringSearching.buildPrefixTable(str.getBytes()));
//        f.clear();

        String bigStr = "aabcaaabcaaabcaaadffdfcaaabcaabcaabcaaabcaaabc";
        System.out.println("----");
        String filePath = "src/main/java/ru/nsu/laptev/test_file";
        ArrayList<Long> list = new ArrayList<>();
        try {
            list = SubStringSearching.find(filePath, str);

            ArrayList<Long> f1 = new ArrayList<>();
            f1.add(0L);
            f1.add(5L);
            f1.add(32L);
            f1.add(37L);
            assertEquals(list.toString(), f1.toString());

            System.out.println(list + " " + f1);
        } catch (IOException e) { //FileNotFoundException will be catched here
            String strsdf = "";
            System.out.println("Laptev");
        }

    }

}
