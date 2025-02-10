package ru.nsu.laptev;

import java.util.ArrayList;

public class ParallelsPrimeNumberDetection {

    public static boolean hasPrimeNumb(ArrayList<Integer> list) {
        return list.parallelStream().anyMatch(PrimeNumber::isPrime);
    }
}
