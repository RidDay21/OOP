package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPrimeNumberDetection {

    public static boolean hasCompositeNumber(int amountOfThreads, ArrayList<Integer> array) throws InterruptedException {
        Thread[] threads = new Thread[amountOfThreads];
        int length = array.size();
        int threadScanArea = (length + amountOfThreads - 1) / amountOfThreads;
        AtomicBoolean hasCompNumbflag = new AtomicBoolean(false);
        for (int i = 0; i < amountOfThreads; i++) {
            final int start = i * threadScanArea;
            final int end = Math.min(start + threadScanArea, length);
            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    if (!PrimeNumber.isPrime(array.get(j))) {
                        hasCompNumbflag.set(true);
                        break;
                    }
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        return hasCompNumbflag.get();
    }
}