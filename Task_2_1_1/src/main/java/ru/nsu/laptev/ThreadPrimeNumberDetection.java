package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPrimeNumberDetection {
    public static volatile boolean hasCompNumbFlag = false;

    public static boolean hasCompositeNumber(int amountOfThreads, ArrayList<Integer> array) throws InterruptedException {
        Thread[] threads = new Thread[amountOfThreads];
        int length = array.size();
        int threadScanArea = (length + amountOfThreads - 1) / amountOfThreads;
        for (int i = 0; i < amountOfThreads; i++) {
            final int start = i * threadScanArea;
            final int end = Math.min(start + threadScanArea, length);
            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    if (!PrimeNumber.isPrime(array.get(j))) {
                        hasCompNumbFlag = true;
                        System.out.println(array.get(j));
                        break;
                    }
                }
            });
            threads[i].start();
        }

        //прописать эксепшены
        for (Thread thread : threads) {
            thread.join();
        }

        boolean flag = hasCompNumbFlag;
        hasCompNumbFlag = false;
        return flag;
    }
}