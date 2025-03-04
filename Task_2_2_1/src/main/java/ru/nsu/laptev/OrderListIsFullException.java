package ru.nsu.laptev;

public class OrderListIsFullException extends RuntimeException {
    public OrderListIsFullException(String message) {
        super(message);
    }
}
