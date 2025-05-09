package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing, bro.
 */
class SubStringSearchingTest {
    @Test
    void smileTest1() {
        try (FileWriter writer = new FileWriter("big_guy.txt", false)) {
            String str = "test1☢\uFE0Ftest1\uD83D\uDE08\uD83C\uDF0Ftest1";
            System.out.println(str);
            writer.write(str);
            writer.close();
            ArrayList<Long> ind = new ArrayList<>();
            ind = SubStringSearching.find("big_guy.txt", "test1");
            ArrayList<Long> checkArray = new ArrayList<>();
            checkArray.add(0L);
            checkArray.add(7L);
            checkArray.add(14L);
            System.out.println(ind.toString());

            assertEquals(checkArray.toString(), ind.toString());
        } catch (IOException e) {

        }
    }


    @Test
    void bigFileInit() {
        try (FileWriter file = new FileWriter("big_guy.txt", false)) {
            String bigString = "aaabcaaabcaaabcaaadffdfcaaabcaabcaabcaaabcaaabcaabc";
            int count = 1_000;
            for (int i = 0; i < count; i++) {
                file.write(bigString);
            }
            file.close();
            ArrayList<Long> ind = new ArrayList<>();
            ind = SubStringSearching.find("big_guy.txt", "aabcaaabc");
            ArrayList<Long> checkArray = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                int span = 51 * i;
                checkArray.add(1L + span);
                checkArray.add(6L + span);
                checkArray.add(33L + span);
                checkArray.add(38L + span);
                if (i != count - 1) {
                    checkArray.add(47L + span);
                }

            }
            assertEquals(checkArray.toString(), ind.toString());
        } catch (IOException e) {
            System.out.println("U have a mistake.");
        }
    }

    @Test
    void bigFileTest() {

    }

}
