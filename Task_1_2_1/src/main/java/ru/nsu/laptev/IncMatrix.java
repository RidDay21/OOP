package ru.nsu.laptev;

import java.io.InvalidObjectException;
import java.util.ArrayList;

public class IncMatrix<V, E> implements Graph<V, E>{
    public ArrayList<ArrayList<Integer>> matrix = new ArrayList<> ();
    private ArrayList<V> vertexes = new ArrayList<>();
    private ArrayList<Edge<V, E>> edges = new ArrayList<>();

    private int vertex_number;
    private int edge_number;

    public int get_vertex_count() { return vertex_number;}
    public ArrayList<V> get_list_vertex() { return vertexes; }
    public int get_vertex_index(V name) { return vertexes.indexOf(name); }
    public int get_edge_index(Edge edge) {
        int index = 0;
        for (Edge e: edges) {
            if ((e.get_start_vertex() == edge.get_start_vertex())
                    && (e.get_end_vertex() == edge.get_end_vertex())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void addVertex(V name) {
        vertex_number++;
        vertexes.add(name);
        //Creating new row for new vertex;
        ArrayList<Integer> row = new ArrayList<>();
        matrix.add(row);
        for (int i = 0; i < vertex_number; i++) { //Adding null to each row
            while (matrix.get(i).size() < edge_number) {
                matrix.get(i).add(0);
            }
        }
    }

    public void delVertex(V name) throws InvalidObjectException {
        int index = get_vertex_index(name);
        if (index == -1) {
            throw new InvalidObjectException(("Vertex isn't found"));
        }

        for (int i = 0; i < edge_number; i++) {
            V start = edges.get(i).get_start_vertex();
            V end = edges.get(i).get_end_vertex();
            if ((start == name) || (end == name)) {
                delEdge(start, end);
            }

        }
        matrix.remove(index);//removing row from matrix
        vertexes.remove(name);
        vertex_number--;
    }


    public void addEdge(V start, V end, E name) throws InvalidObjectException{
        for (int i = 0; i < vertex_number; i++) { //Adding null to each row
                matrix.get(i).add(0);
            }
        int startVertex = get_vertex_index(start);
        int endVertex = get_vertex_index(end);
        Edge<V,E> edge = new Edge(start,end,name);
        edges.add(edge);
        edge_number++;
        int edgeIndex = get_edge_index(edge);//новое ребро будет в конце массива;
        if (startVertex != -1 && endVertex != -1) {
            if (start == end) {
                matrix.get(startVertex).set(edgeIndex, 2);
            } else {
                matrix.get(startVertex).set(edgeIndex, 1);
                matrix.get(endVertex).set(edgeIndex, -1);
            }
        } else {
            throw new InvalidObjectException("One of Vertexes isn't found.");
        }
    }

    public void delEdge(V start, V end) throws InvalidObjectException {
        edge_number--;
        int startVertex = get_vertex_index(start);
        int endVertex = get_vertex_index(end);
        if (startVertex == -1 || endVertex == -1) {
            throw new InvalidObjectException("Vertex isn't found.");
        }

        int edgeIndex = get_edge_index(new Edge(start, end, null));
        if (edgeIndex == -1) {
            throw new InvalidObjectException("Edge isn't found.");
        }

        for (int i = 0; i < vertex_number; i++) {
            matrix.get(i).remove(edgeIndex);
        }
    }

    public void get_neighbours(V name) throws InvalidObjectException {
        int vertexIndex = get_vertex_index(name);
        if (vertexIndex == -1) {
            throw new InvalidObjectException("Vertex isn't founded.");
        }
        System.out.print("Neighbours of vertex " + name + ": ");
        int ind = 0;
        for (Integer link : matrix.get(get_vertex_index(name))) {
            if (link == 2) {
                System.out.print(name);
            }
            if (link == 1) {
                System.out.print(edges.get(ind).get_end_vertex());
            }
            ind++;
        }
    }
    public void print_graph() {
        for (int i = 0; i < vertex_number; i++) {
            System.out.println("Vertex " + vertexes.get(i) + ": " + matrix.get(i));
            }
        System.out.println("\n");
        }
    }
