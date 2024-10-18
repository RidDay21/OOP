package ru.nsu.laptev;

import javax.lang.model.element.UnknownElementException;
import java.io.InvalidObjectException;
import java.util.ArrayList;

public class AdjMatrix<V, E> implements Graph<V, E> {
    public ArrayList<ArrayList<E>> matrix = new ArrayList<ArrayList<E>>();
    private ArrayList<V> vertexes = new ArrayList<>();
    private int vertex_count;

    public int get_vertex_count() { return vertex_count;}

    public ArrayList<V> get_list_vertex() { return vertexes; }

    public int get_vertex_number(V name) {
        return vertexes.indexOf(name);
    }

    /**
     * It's turned out that I need to add a null value to every existing row in the matrix
     * @param name - name of new vertex
     */
    public void addVertex(V name) {
        vertex_count++;
        vertexes.add(name);
        //Creating new row for new vertex;
        ArrayList<E> row = new ArrayList<>();
        for (int i = 0; i < vertex_count; i++) {
            row.add(null);
        }
        matrix.add(row);
        for (int i = 0; i < vertex_count; i++) {
            //matrix.get(i).add(null);//Adding null to each row
            while (matrix.get(i).size() < vertex_count) {
                matrix.get(i).add(null);
            }
        }
    }

    public void delVertex(V name) {
        int index = get_vertex_number(name);
        for (int i =0; i < vertex_count;i++) {
            matrix.get(i).remove(index);
        }
        matrix.remove(index);//removing row from matrix
        vertexes.remove(name);
        vertex_count--;
    }

    public void addEdge(V start, V end, E name) throws InvalidObjectException{
        int startVertex = get_vertex_number(start);
        int endVertex = get_vertex_number(end);
        if (startVertex != -1 && endVertex != -1) {
            matrix.get(startVertex).set(endVertex,name);
        } else {
            throw new InvalidObjectException(" Vertex isn't found.");
        }
    }

    public void delEdge(V start, V end) throws InvalidObjectException {
        int startVertex = get_vertex_number(start);
        int endVertex = get_vertex_number(end);
        if (startVertex != -1 && endVertex != -1) {
            matrix.get(startVertex).set(endVertex, null);
        } else {
            throw new InvalidObjectException("Vertex isn't found.");
        }
    }

    public void get_neighbours(V name) throws InvalidObjectException {
        System.out.print("Neighbours of vertex " + name + ": ");
        int index = vertexes.indexOf(name);
        if (index == -1) {
            throw new InvalidObjectException("Vertex isn't found");
        }
        for (int i = 0; i < vertex_count; i++) {
            E edge = matrix.get(index).get(i);
            if (edge != null) {
                System.out.print(matrix.get(index).get(i) + ", ");
            }
        }
    }

    public void print_graph() {
        for (int i = 0; i < vertex_count;i++) {
            System.out.println(vertexes.get(i) + " - " + matrix.get(i));
        }
    }
}
