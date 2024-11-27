package ru.nsu.laptev;

/**
 * Exception to find Cycle.
 */
public class CycleFoundException extends Exception {
    public CycleFoundException(String message) {
        super(message);
    }
}
