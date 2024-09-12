package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    void SampleTest()
    {
        int [] array4check = {1,4,5,675,23,4};
        HeapSort.heapsort(array4check,6);
        int [] correctArray = {1,4,5,5,23,675};
        assertArrayEquals(correctArray ,array4check);
    }

}