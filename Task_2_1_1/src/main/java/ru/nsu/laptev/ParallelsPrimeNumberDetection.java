package ru.nsu.laptev;

import java.util.ArrayList;

/**
 * ParallelsPrimeNumberDetection contains method for searching a composite number.
 * Using a parallelStream.
 */
public class ParallelsPrimeNumberDetection {
    /**
     * Checks if the given number is composite.
     *
     * @param number the number to check.
     * @return true if the number is composite, false otherwise.
     */
    public static boolean isComp(int number) {
        if (number <= 1) {
            return false;
        }

        // Remove square root
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given ArrayList contains any composite numbers.
     *
     * @param list passing a list with numbers to check.
     * @return true if the list contains a composite number, false otherwise.
     */
    public static boolean hasCompositeNumber(ArrayList<Integer> list) {
        return list.parallelStream().anyMatch(ParallelsPrimeNumberDetection::isComp);
    }
}
