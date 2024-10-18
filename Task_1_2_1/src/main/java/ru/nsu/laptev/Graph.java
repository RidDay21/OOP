package ru.nsu.laptev;

public interface Graph<T> {

    public void addVertex(T name);
    public void delVertex(T name);

    public void addEdge(T start, T end);
    public void delEdge(T start, T end);

    public void get_neighbours(T name);



}
