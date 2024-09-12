package ru.nsu.laptev;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        int [] array = {4,1,5,675,23,4};
        HeapSort.heapsort(array, array.length);
        for (int i = 0;i < array.length;i++)
        {
            System.out.println(array[i] + " ");
        }
    }
}