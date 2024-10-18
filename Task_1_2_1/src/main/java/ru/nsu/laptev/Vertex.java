package ru.nsu.laptev;

public class Vertex <T> {
    private T name;

    Vertex (T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }
}
