package ru.nsu.laptev;

public class Edge <T> {
    private Vertex<T> startVertex;
    private Vertex<T> endVertex;


    Edge (Vertex<T> startVertex, Vertex<T> endVertex) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    Edge() { }
    public Vertex<T> getStartVert() {return this.startVertex;}

    public Vertex<T> get_end_vert() {return this.endVertex;}
}
