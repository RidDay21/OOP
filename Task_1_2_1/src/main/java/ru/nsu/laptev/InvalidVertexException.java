package ru.nsu.laptev;

/**
 * Special Expression for invalid vertex.
 */
public class InvalidVertexException extends Exception {
    public InvalidVertexException(String message) {
        super("Graph doesn;t have such vertex" + message); //вызывается конструктор суперкласса
    }
}
