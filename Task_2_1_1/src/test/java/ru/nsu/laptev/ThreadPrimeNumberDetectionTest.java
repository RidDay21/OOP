package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class contains test methods for the ThreadPrimeNumberDetectionTest class.
 */
class ThreadPrimeNumberDetectionTest {
    ArrayList<Integer> list = new ArrayList<>();
    int size;
    int primeNumber;
    int amountOfThreads = 20;

    @BeforeEach
    void initialize() {
        list = new ArrayList<>();
        size = 15;
        primeNumber = 73939133;
    }

    @Test
    void firstTimeTest() {
        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }

        long startTime = System.currentTimeMillis();
        assertFalse(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(Composite in the last "
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
        assertFalse(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(Composite in the last "
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
        assertFalse(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(Composite in the last "
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
        assertFalse(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(Composite in the last "
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
        assertFalse(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ThreadPrimeNumberDetection.hasCompositeNumber(amountOfThreads, list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(Composite in the last "
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
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for Threads implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime)  + " ms.\n\n");
        list.clear();
    }

}