package ru.nsu.laptev;

import java.rmi.MarshalException;
import java.util.ArrayList;

/**
 * The PrimeNumber class contains methods for working with prime numbers.
 */
public class PrimeNumber {

    /**
     * Checks if the given number is composite.
     *
     * @param number the number to check.
     * @return true if the number is composite, false otherwise.
     */
    public static boolean isComp(int number) {
        if (number <= 1) {
            return true;
        }

        // Remove square root
        double sqr = Math.sqrt(number);
        int sqr_int = (int) Math.round(sqr);
        for (int i = 2; i <= sqr_int; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given ArrayList contains any composite numbers.
     *
     * @param array passing the array of numbers to check.
     * @return true if array contains a composite number, false otherwise.
     */
    public static boolean hasCompositeNumber(ArrayList<Integer> array) {
        for (int num : array) {
            if (isComp(num)) {
                return true;
            }
        }
        return false;
    }

}
