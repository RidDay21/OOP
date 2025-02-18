package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class contains test methods for the PrimeNumber class.
 */
class PrimeNumberTest {
    @Test
    void sampleTest() {
        assertTrue(PrimeNumber.isComp(4));
        assertFalse(PrimeNumber.isComp(7));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(120120021, 1, 213213, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(13, 17, 3, 5, 7, 37, 13, 17,
                3, 5, 7, 37, 13, 17, 3, 5, 7, 37));
        assertTrue(PrimeNumber.hasCompositeNumber(list1));
        assertFalse(PrimeNumber.hasCompositeNumber(list2));
    }

    ArrayList<Integer> list = new ArrayList<>();
    int size;
    int primeNumber;

    @BeforeEach
    void initialize() {
        list = new ArrayList<>();
        size = 10;
        primeNumber = 73939133;
    }

    @Test
    void firstTimeTest() {
        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }

        long startTime = System.currentTimeMillis();
        assertFalse(PrimeNumber.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(PrimeNumber.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime) + " ms.\n\n");
        list.clear();
    }

    @Test
    void secondTimeTest() {
        size *= size;

        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(PrimeNumber.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(PrimeNumber.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime) + " ms.\n\n");
        list.clear();
    }

    @Test
    void thirdTimeTest() {
        size *= (size * size);

        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(PrimeNumber.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(PrimeNumber.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime) + " ms.\n\n");
        list.clear();
    }

    @Test
    void fourthTimeTest() {
        size *= (size * size * size);
        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(PrimeNumber.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(PrimeNumber.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime) + " ms.\n\n");
        list.clear();
    }

    @Test
    void fifthTimeTest() {
        size *= (size * size * size * size);

        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(PrimeNumber.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(PrimeNumber.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime) + " ms.\n\n");
        list.clear();
    }

    @Test
    void sixthTimeTest() {
        size *= (size * size * size * size * size);

        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(PrimeNumber.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(PrimeNumber.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Simple implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime) + " ms.\n\n");
        list.clear();
    }
}