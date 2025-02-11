package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreadPrimeNumberDetectionTest {

    @Test
    void sampleTest() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(120120021, 1, 213213, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(13, 17, 3, 5, 7, 37, 13, 17, 3, 5, 7, 37, 13, 17, 3, 5, 7, 37));

        try {
            assertTrue(ThreadPrimeNumberDetection.hasCompositeNumber(4, list1));
            assertFalse(ThreadPrimeNumberDetection.hasCompositeNumber(4, list2));
        } catch (InterruptedException e) {

        }

    }

}