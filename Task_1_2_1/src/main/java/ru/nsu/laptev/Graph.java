package ru.nsu.laptev;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Interface for graph implementaton.
 * 
 * @param <VertexT> for vertex type.
 * @param <EdgeT> for edge type.
 */

public interface Graph<VertexT, EdgeT extends Number> {
    public int get_vertex_index(VertexT name);

    public ArrayList<VertexT> get_vertices();

    public ArrayList<Edge<VertexT, EdgeT>> get_edges();

    public void addVertex(VertexT name) throws InvalidVertexException;

    public void delVertex(VertexT name) throws InvalidVertexException, InvalidEdgeException;

    public void addEdge(VertexT start, VertexT end, EdgeT name) throws InvalidVertexException,
            InvalidEdgeException;

    public void delEdge(VertexT start, VertexT end) throws InvalidEdgeException,
            InvalidVertexException;

    public ArrayList<VertexT> get_neighbours(VertexT name) throws InvalidVertexException;

    public void print_graph();

    public void read_from_file(Transformer<VertexT> vertexTransformer,
                               Transformer<EdgeT> edgeTransformer,
                               String path) throws FileNotFoundException;

}
