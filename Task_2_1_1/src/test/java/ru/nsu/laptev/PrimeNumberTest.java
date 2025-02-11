package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {
    @Test
    void sampleTest() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(120120021, 1, 213213, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(13, 17, 3, 5, 7, 37, 13, 17, 3, 5, 7, 37, 13, 17, 3, 5, 7, 37));
        assertTrue(PrimeNumber.isPrime(3));
        assertFalse(PrimeNumber.isPrime(100000010));

        assertTrue(PrimeNumber.hasСompositeNumber(list1));
        assertFalse(PrimeNumber.hasСompositeNumber(list2));
    }
}