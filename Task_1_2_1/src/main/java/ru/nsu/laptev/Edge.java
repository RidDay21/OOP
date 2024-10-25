package ru.nsu.laptev;

/**
 * Class for edge implementation.
 * @param <VertexT> for vertex type.
 * @param <EdgeT> for edge type.
 */
public class Edge<VertexT, EdgeT> {
    private VertexT startVertex;
    private VertexT endVertex;
    private EdgeT name;


    Edge(VertexT startVertex, VertexT endVertex, EdgeT name) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.name = name;
    }

    public VertexT get_start_vertex() {
        return this.startVertex;
    }

    public VertexT get_end_vertex() {
        return this.endVertex;
    }

    public EdgeT get_name() {
        return name;
    }

    public boolean is_equal(VertexT start, VertexT end) throws InvalidEdgeException {
        boolean flag = false;
        if (start == startVertex && end == endVertex) {
            flag = true;
        }
        return flag;
    }
}