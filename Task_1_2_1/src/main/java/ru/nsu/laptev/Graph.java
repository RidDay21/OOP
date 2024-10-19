package ru.nsu.laptev;

import javax.lang.model.element.UnknownElementException;
import java.io.InvalidObjectException;

public interface Graph<V, E> {

    public void addVertex(V name);
    public void delVertex(V name) throws InvalidObjectException;

    public void addEdge(V start, V end, E name) throws InvalidObjectException;
    public void delEdge(V start, V end) throws InvalidObjectException;

    public void get_neighbours(V name) throws InvalidObjectException;
    public void print_graph();



}