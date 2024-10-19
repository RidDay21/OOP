package ru.nsu.laptev;

public class Edge <T,E> {
    private T startVertex;
    private T endVertex;
    private E name;


    Edge (T startVertex, T endVertex, E name) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.name = name;
    }

    public T get_start_vertex() {return this.startVertex;}

    public T get_end_vertex() {return this.endVertex;}

    public E get_name() { return name;}
}