package ru.nsu.laptev;

public class OrderListIsEmptyException extends RuntimeException {
    public OrderListIsEmptyException(String message) {
        super(message);
    }
}
