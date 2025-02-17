package ru.nsu.laptev;

import java.util.ArrayList;

/**
 * ParallelsPrimeNumberDetection contains method for searching a composite number.
 * Using a parallelStream.
 */
public class ParallelsPrimeNumberDetection {

    /**
     * Checks if the given ArrayList contains any composite numbers.
     *
     * @param list passing a list with numbers to check.
     * @return true if the list contains a composite number, false otherwise.
     */
    public static boolean hasCompositeNumber(ArrayList<Integer> list) {
        return list.
                parallelStream().
                anyMatch(PrimeNumber::isComp);
    }
}
