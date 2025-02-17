package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class contains test methods for the ParallelsPrimeNumberDetection class.
 */
class ParallelsPrimeNumberDetectionTest {

    @Test
    void sampleTest() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(120120021, 1, 213213, 3));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(13, 17, 3, 5, 7, 37, 13, 17, 3,
                5, 7, 37, 13, 17, 3, 5, 7, 37));
        ArrayList<Integer> emptyList = new ArrayList<>();

        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list1));
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list2));
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(emptyList));

        list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list1));

        list2 = new ArrayList<>((Arrays.asList(7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7)));
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list2));

        list1 = new ArrayList<>(Arrays.asList(21, 21, 21, 21, 21, 21, 21, 21));
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list1));
    }
    ArrayList <Integer> list = new ArrayList<>();
    int size;
    int primeNumber;

    @BeforeEach
    void initialize() {
        list = new ArrayList<>();
        size = 21;
        primeNumber = 73939133;
    }

    @Test
    void firstTimeTest() {
        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }

        long startTime = System.currentTimeMillis();
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime)  + " ms.\n\n");
        list.clear();
    }

    @Test
    void secondTimeTest() {
        size *= size;

        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime)  + " ms.\n\n");
        list.clear();
    }

    @Test
    void thirdTimeTest() {
        size *= (size * size);

        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime)  + " ms.\n\n");
        list.clear();
    }

    @Test
    void fourthTimeTest() {
        size *= (size * size * size);
        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime)  + " ms.\n\n");
        list.clear();
    }

    @Test
    void fifthTimeTest() {
        size *= (size * size * size * size);

        for (int i = 0; i < size; i++) {
            list.add(primeNumber);
        }
        long startTime = System.currentTimeMillis();
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(no Composite & "
                + size + " numbers: " + (endTime - startTime) + " ms.");

        list.add(21);
        startTime = System.currentTimeMillis();
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time for parallelStream implementation(Composite in the last "
                + " & big amount: " + (endTime - startTime)  + " ms.\n\n");
        list.clear();
    }

    @Test
    void singleNumberTest() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(120120021));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(13));

        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list1));
        assertFalse(ParallelsPrimeNumberDetection.hasCompositeNumber(list2));

        list2 = new ArrayList<>(Arrays.asList(1));
        assertTrue(ParallelsPrimeNumberDetection.hasCompositeNumber(list2));
    }
}
