package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ParallelsPrimeNumberDetectionTest {
    @Test
    void sampleTest() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(120120021, 1, 213213, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(120120021, 120120021, 120120021, 120120021, 120120021,
                120120021, 120120021, 120120021, 120120021, 120120021, 2));
        assertTrue(PrimeNumber.isPrime(3));
        assertFalse(PrimeNumber.isPrime(100000010));

        assertTrue(ParallelsPrimeNumberDetection.hasPrimeNumb(list1));
        assertFalse(ParallelsPrimeNumberDetection.hasPrimeNumb(list2));
    }
}