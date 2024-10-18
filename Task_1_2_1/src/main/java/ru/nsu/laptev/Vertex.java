package ru.nsu.laptev;

public class Vertex <T> {
    private T name;
    private int index;

    Vertex (T name) {
        this.name = name;
    }

    public T get_name() {
        return name;
    }

    public int get_ind() {
        return index;
    }
}
