package ru.nsu.laptev;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;

public interface Graph<VertexType, EdgeType extends Number> {

    public void addVertex(VertexType name) throws InvalidVertexException;
    public void delVertex(VertexType name) throws InvalidVertexException, InvalidObjectException;

    public void addEdge(VertexType start, VertexType end, EdgeType name) throws InvalidVertexException;
    public void delEdge(VertexType start, VertexType end) throws InvalidObjectException, InvalidVertexException;

    public ArrayList<VertexType> get_neighbours(VertexType name) throws InvalidVertexException;
    public void print_graph();

    public char[] read_from_file() throws IOException;

}
