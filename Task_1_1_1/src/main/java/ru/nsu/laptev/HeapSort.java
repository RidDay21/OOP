package ru.nsu.laptev;

import java.io.*;

/**
 * Class for realization of HeapSort
 */
public class HeapSort {

    /**
     * Метод для добавления предка в бинарное дерево
     */
    public static void addAncestor(int index, int data, int[] bintree) {
        int i = index;
        int indPred = (i - 1) / 2;

        bintree[i] = data;

        while (i > 0 && bintree[i] < bintree[indPred]) {
            int tmp = bintree[i];
            bintree[i] = bintree[indPred];
            bintree[indPred] = tmp;
            i = indPred;
            indPred = (i - 1) / 2;
        }
    }

    /**
     * Метод "просеивания"
     */
    public static void heapify(int index, int[] list, int size) {
        while (index < size / 2) {
            int indLeftAncestor = 2 * index + 1;
            int indRightAncestor = 2 * index + 2;

            int indBossAncestor = (indRightAncestor < size && list[indLeftAncestor] > list[indRightAncestor]) ? indRightAncestor : indLeftAncestor;

            if (list[indBossAncestor] < list[index]) {
                // Процесс просеивания вниз для поддержания свойства кучи
                int tmp = list[indBossAncestor];
                list[indBossAncestor] = list[index];
                list[index] = tmp;
                index = indBossAncestor;
            } else {
                break;
            }
        }
    }

    /**
     * Метод для пирамидальной сортировки
     */
    public static void heapsort(int[] array, int length) {
        int[] BinTree = new int[length];
        for (int i = 0; i < length; i++) {
            int anc = array[i];
            addAncestor(i, anc, BinTree);
        }

        for (int i = 0; i < length; i++) {
            heapify(i, BinTree, length);
        }

        int[] sortedArray = new int[length];

        for (int i = 0; i < length; i++) {
            sortedArray[i] = BinTree[0];
            BinTree[0] = BinTree[length - i - 1];
            heapify(0, BinTree, length - i - 1);
        }

        for (int i = 0; i < length; i++) {
            array[i] = sortedArray[i];
        }
    }
}
