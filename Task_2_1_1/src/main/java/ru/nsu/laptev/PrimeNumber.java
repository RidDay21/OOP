package ru.nsu.laptev;

import java.io.Console;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class PrimeNumber {


    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i <= sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasСompositeNumber(ArrayList<Integer> array) {
        for (int num : array) {
            if (!isPrime(num)) {
                System.out.println(num);
                return true;
            }
        }
        return false;
    }

}


