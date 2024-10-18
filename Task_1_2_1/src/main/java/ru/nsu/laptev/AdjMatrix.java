package ru.nsu.laptev;

import java.util.ArrayList;

public class AdjMatrix<T> implements Graph<T> {
    public ArrayList<ArrayList<T>> matrix = new ArrayList<ArrayList<T>>();
    private int vertex_count;

    public int get_vertex_count() { return vertex_count;}

    /**
     * It's turned out that I need to add a null value to every existing row in the matrix
     * @param name - name of new vertex
     */
    public void addVertex(T name) {
        vertex_count++;
        //Creating new row for new vertex;
        ArrayList<T> row = new ArrayList<>();
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

    public void delVertex(T name) {
        int index = matrix.indexOf(name);
        for (int i =0; i < vertex_count;i++) {
            matrix.get(0).remove(index);
        }
        matrix.remove(index);//removing row from matrix
        vertex_count--;
    }

    public void addEdge(T start, T end) {

    }
    public void delEdge(T start, T end) {

    }

    public void get_neighbours(T name) {

    }
}
