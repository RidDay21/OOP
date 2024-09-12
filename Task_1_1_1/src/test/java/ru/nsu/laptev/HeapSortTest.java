package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeapSortTest {
    @Test
    void sampleTest() {
        int [] array4check = {1, 4, 5, 675, 23, 4};
        HeapSort.heapsort(array4check,6);
        int [] correctArray = {1, 4, 4, 5, 23, 675};
        assertArrayEquals(correctArray, array4check);
        Main.main(null);
        assertTrue(true);
    }
}