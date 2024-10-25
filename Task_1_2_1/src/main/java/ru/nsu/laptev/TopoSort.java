package ru.nsu.laptev;

import java.util.ArrayList;
import java.util.Collections;

public class TopoSort<VertexT, EdgeT extends Number> {
    int length;
    private Graph<VertexT, EdgeT> matrix;
    private char[] visited;
    private ArrayList<VertexT> order;
    private ArrayList<VertexT> vertices;

    public TopoSort(Graph<VertexT, EdgeT> matrix) {
        this.matrix = matrix;
        this.length = matrix.get_vertices().size();
        this.vertices = matrix.get_vertices();
        this.order = new ArrayList<>();
        this.visited = new char[length];
        for (int i = 0; i < length; i++) {
            visited[i] = 'w';
        }
    }


    public void dfs(int index) throws CycleFoundException, InvalidVertexException {

        visited[index] = 'g';
        ArrayList<VertexT> neighbours = new ArrayList<>();
        try {
            neighbours = matrix.get_neighbours(vertices.get(index));
        } catch (InvalidVertexException e) {
            System.out.println("WHY");
        }

        for (VertexT v : neighbours) {
            int temp = matrix.get_vertex_index(v);
            if (visited[temp] == 'w') {
                dfs(temp);
            } else if (visited[temp] == 'g') {
                throw new CycleFoundException("Graph contains a cycle");
            }
        }

        visited[index] = 'b';
        order.add(vertices.get(index));
    }

    public ArrayList<VertexT> topologicalSort() throws InvalidVertexException,
            CycleFoundException {
        for (int i = 0; i < length; i++) {
            if (visited[i] == 'w') {
                try {
                    dfs(i);
                } catch (CycleFoundException e) {
                    order = null;
                    break;
                } catch (InvalidVertexException e) {
                    order = null;
                    break;
                }
            }
        }

        if (order == null) {
            throw new CycleFoundException("Graph contains a cycle");
        }
        Collections.reverse(order);
        return order;
    }
}

