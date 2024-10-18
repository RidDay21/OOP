package ru.nsu.laptev;

import java.util.ArrayList;

public class AdjMatrix<T> implements Graph<T> {
    public ArrayList<ArrayList<T>> matrix = new ArrayList<ArrayList<T>>();
    private ArrayList<T> vertexes = new ArrayList<>();
    private int vertex_count;

    public int get_vertex_count() { return vertex_count;}

    public int get_vertex_number(T name) {
        return vertexes.indexOf(name);
    }

    /**
     * It's turned out that I need to add a null value to every existing row in the matrix
     * @param name - name of new vertex
     */
    public void addVertex(T name) {
        vertex_count++;
        vertexes.add(name);
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
        int index = get_vertex_number(name);
        System.out.println(index);
        for (int i =0; i < vertex_count;i++) {
            matrix.get(i).remove(index);
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
