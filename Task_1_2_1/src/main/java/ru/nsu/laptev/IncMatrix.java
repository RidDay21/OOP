package ru.nsu.laptev;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class IncMatrix<VertexT, EdgeT extends Number> implements Graph<VertexT, EdgeT> {
    public ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    private ArrayList<VertexT> vertices = new ArrayList<>();
    private ArrayList<Edge<VertexT, EdgeT>> edges = new ArrayList<>();

    private int vertex_number;
    private int edge_number;

    public int get_vertex_count() {
        return vertex_number;
    }

    public ArrayList<VertexT> get_vertices() {
        return vertices;
    }

    public ArrayList<Edge<VertexT, EdgeT>> get_edges() {
        return edges;
    }

    public int get_vertex_index(VertexT name) {
        return vertices.indexOf(name);
    }

    public int get_edge_index(Edge edge) {
        int index = 0;
        for (Edge e : edges) {
            if ((e.get_start_vertex() == edge.get_start_vertex())
                    && (e.get_end_vertex() == edge.get_end_vertex())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void read_from_file(Transformer<VertexT> vertexTransformer,
                               Transformer<EdgeT> edgeTransformer,
                               String path) throws FileNotFoundException {
    }

    public void addVertex(VertexT name) throws InvalidVertexException {
        if (vertices.contains(name)) {
            throw new InvalidVertexException("Graph has already haven such vertex.");
        }
        vertex_number++;
        vertices.add(name);
        //Creating new row for new vertex;
        ArrayList<Integer> row = new ArrayList<>();
        matrix.add(row);
        for (int i = 0; i < vertex_number; i++) { //Adding null to each row
            while (matrix.get(i).size() < edge_number) {
                matrix.get(i).add(0);
            }
        }
    }

    public void delVertex(VertexT name) throws InvalidVertexException, InvalidEdgeException {
        int index = get_vertex_index(name);
        if (index == -1) {
            throw new InvalidVertexException(("Vertex isn't found"));
        }

        for (int i = 0; i < edge_number; i++) {
            VertexT start = edges.get(i).get_start_vertex();
            VertexT end = edges.get(i).get_end_vertex();
            if ((start == name) || (end == name)) {
                try {
                    delEdge(start, end);
                } catch (InvalidVertexException e) {
                    System.out.println();
                } catch (InvalidEdgeException e) {
                    System.out.println();
                }
            }

        }
        matrix.remove(index); //removing row from matrix
        vertices.remove(name);
        vertex_number--;
    }


    public void addEdge(VertexT start, VertexT end, EdgeT name) throws InvalidVertexException, InvalidEdgeException {
        for (int i = 0; i < vertex_number; i++) { //Adding null to each row
            matrix.get(i).add(0);
        }
        int startVertex = get_vertex_index(start);
        if (startVertex == -1) {
            throw new InvalidVertexException("Start Vertex isn't found.");
        }
        int endVertex = get_vertex_index(end);
        if (startVertex == -1) {
            throw new InvalidVertexException("End Vertex isn't found.");
        }
        Edge<VertexT, EdgeT> edge = new Edge(start, end, name);
        if (edges.contains(edge)) {
            throw new InvalidEdgeException("Graph has already haven such edge.");
        }
        edges.add(edge);
        edge_number++;
        int edgeIndex = get_edge_index(edge); //новое ребро будет в конце массива;
        if (startVertex != -1 && endVertex != -1) {
            if (start == end) {
                matrix.get(startVertex).set(edgeIndex, 2);
            } else {
                matrix.get(startVertex).set(edgeIndex, 1);
                matrix.get(endVertex).set(edgeIndex, -1);
            }
        }

    }

    public void delEdge(VertexT start, VertexT end) throws InvalidEdgeException, InvalidVertexException {
        edge_number--;
        int startVertex = get_vertex_index(start);
        int endVertex = get_vertex_index(end);
        if (startVertex == -1 || endVertex == -1) {
            throw new InvalidVertexException("Vertex isn't found.");
        }

        int edgeIndex = get_edge_index(new Edge(start, end, null));
        if (edgeIndex == -1) {
            throw new InvalidEdgeException("Edge isn't found.");
        }

        for (int i = 0; i < vertex_number; i++) {
            matrix.get(i).remove(edgeIndex);
        }

        for (Edge e : edges) {
            if (e.is_equal(start, end)) {
                edges.remove(e);
                break;
            } else {
                throw new InvalidEdgeException("Edge hasn't been found.");
            }
        }
    }

    public ArrayList<VertexT> get_neighbours(VertexT name) throws InvalidVertexException {
        ArrayList<VertexT> neighbours_list = new ArrayList<>();
        int vertexIndex = get_vertex_index(name);
        if (vertexIndex == -1) {
            throw new InvalidVertexException("Vertex isn't founded.");
        }

        for (int ind = 0; ind < edge_number; ind++) {
            int pointer = matrix.get(vertexIndex).get(ind);
            if (pointer == 2) {
                neighbours_list.add(name);
            }
            if (pointer == 1) {
                for (int i = 0; i < vertex_number; i++) {
                    if (matrix.get(i).get(ind) == -1) {
                        neighbours_list.add(vertices.get(i));
                    }
                }
            }
        }
        return neighbours_list;
    }

    public void print_graph() {
        for (int i = 0; i < vertex_number; i++) {
            System.out.println("Vertex " + vertices.get(i) + ": " + matrix.get(i));
        }
        System.out.println("\n");
    }


}
