package ru.nsu.laptev;

import java.util.ArrayList;

public class TopoSort<VertexType, EdgeType extends Number> {
    int length;
    private Graph<VertexType, EdgeType> matrix;
    private char[] visited;
    private ArrayList<VertexType> order;
    private ArrayList<VertexType> vertices;

    public TopoSort(Graph<VertexType, EdgeType> matrix) {
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
        ArrayList<VertexType> neighbours = new ArrayList<>();
        try {
            neighbours = matrix.get_neighbours(vertices.get(index));
        } catch (InvalidVertexException e) {
            System.out.println("WHY");
        }

        for (VertexType v : neighbours) {
            int temp_index = matrix.get_vertex_index(v);
            if (visited[index] == 'w') {
                dfs(temp_index);
            }
        }

        visited[index] = 'b';
        order.add(vertices.get(index));
    }

    public ArrayList<VertexType> topologicalSort() throws InvalidVertexException, CycleFoundException {
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
        return order;
    }
}
