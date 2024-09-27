package ru.nsu.laptev;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Random;

/**
 *
 */
public class Main {
    public static void main(String[] args)
    {
        int[] array1 = {5, 2, 8, 3, 6, 1, 7, 4, 10, 9}; // 10 элементов
        HeapSort.heapsort(array1, array1.length);
    }
}