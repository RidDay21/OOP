package ru.nsu.laptev;

import java.io.*;

public class HeapSort {

    public static void addAncestor(int index, int data, int[] bintree) {
        int i = index;
        int indPred = (i - 1) / 2;

        bintree[i] = data;//вносим новый элемент в наше дерево

        while (i > 0 && bintree[i] < bintree[indPred]) {//тут мы просто просеиваем вверх наше дерево
            int tmp = bintree[i];
            bintree[i] = bintree[indPred];
            bintree[indPred] = tmp;
            i = indPred;
            indPred = (i - 1) / 2;
        }
    }

    // Метод для преобразования в кучу
    public static void heapify(int index, int[] list, int size) {
        while (index < size / 2) {
            int indLeftAncestor = 2 * index + 1;
            int indRightAncestor = 2 * index + 2;

            int indBossAncestor = (indRightAncestor < size && list[indLeftAncestor] > list[indRightAncestor]) ? indRightAncestor : indLeftAncestor;

            if (list[indBossAncestor] < list[index]) {
                int tmp = list[indBossAncestor];
                list[indBossAncestor] = list[index];
                list[index] = tmp;
                index = indBossAncestor;
            } else break;
        }
    }

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
