package ru.nsu.laptev;

public class Edge <VertexType, EdgeType> {
    private VertexType startVertex;
    private VertexType endVertex;
    private EdgeType name;


    Edge (VertexType startVertex, VertexType endVertex, EdgeType name) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.name = name;
    }

    public VertexType get_start_vertex() {return this.startVertex;}

    public VertexType get_end_vertex() {return this.endVertex;}

    public EdgeType get_name() { return name;}
}