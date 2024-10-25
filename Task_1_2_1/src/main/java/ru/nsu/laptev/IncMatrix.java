package ru.nsu.laptev;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Class for implementation graph with IncMatrix.
 *
 * @param <VertexT> for vertex type.
 * @param <EdgeT> for edge type.
 */
public class IncMatrix<VertexT, EdgeT extends Number> implements Graph<VertexT, EdgeT> {
    public ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    private ArrayList<VertexT> vertices = new ArrayList<>();
    private ArrayList<Edge<VertexT, EdgeT>> edges = new ArrayList<>();

    private int vertexNumber;
    private int edgeNumber;

    public int get_vertex_count() {
        return vertexNumber;
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

    /**
     * Method for reading graph from file.
     */
    public void read_from_file(Transformer<VertexT> vertexTransformer,
                               Transformer<EdgeT> edgeTransformer,
                               String path) throws FileNotFoundException {
    }

    /**
     * Method for adding a vertex into my graph.
     *
     * @param name of vertex.
     */
    public void addVertex(VertexT name) throws InvalidVertexException {
        if (vertices.contains(name)) {
            throw new InvalidVertexException("Graph has already haven such vertex.");
        }
        vertexNumber++;
        vertices.add(name);
        //Creating new row for new vertex;
        ArrayList<Integer> row = new ArrayList<>();
        matrix.add(row);
        for (int i = 0; i < vertexNumber; i++) { //Adding null to each row
            while (matrix.get(i).size() < edgeNumber) {
                matrix.get(i).add(0);
            }
        }
    }

    /**
     * Method for deletting a vertex from my graph.
     *
     * @param name of vertex.
     */
    public void delVertex(VertexT name) throws InvalidVertexException, InvalidEdgeException {
        int index = get_vertex_index(name);
        if (index == -1) {
            throw new InvalidVertexException(("Vertex isn't found"));
        }

        for (int i = 0; i < edgeNumber; i++) {
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
        vertexNumber--;
    }

    /**
     * Method for adding an edge to my graph.
     *
     * @param start - name of startVertex.
     * @param end - name of endVertex.
     * @param name of edge.
     */
    public void addEdge(VertexT start, VertexT end, EdgeT name) throws InvalidVertexException,
            InvalidEdgeException {
        for (int i = 0; i < vertexNumber; i++) { //Adding null to each row
            matrix.get(i).add(0);
        }
        int startVertex = get_vertex_index(start);
        if (startVertex == -1) {
            throw new InvalidVertexException("Start Vertex isn't found.");
        }
        int endVertex = get_vertex_index(end);
        if (endVertex == -1) {
            throw new InvalidVertexException("End Vertex isn't found.");
        }
        Edge<VertexT, EdgeT> edge = new Edge(start, end, name);
        if (edges.contains(edge)) {
            throw new InvalidEdgeException("Graph has already haven such edge.");
        }
        edges.add(edge);
        edgeNumber++;
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

    /**
     * Method for deletting an edge from my graph.
     *
     * @param start - name of startVertex.
     * @param end - name of endVertex.
     */
    public void delEdge(VertexT start, VertexT end) throws InvalidEdgeException,
            InvalidVertexException {
        edgeNumber--;
        int startVertex = get_vertex_index(start);
        int endVertex = get_vertex_index(end);
        if (startVertex == -1 || endVertex == -1) {
            throw new InvalidVertexException("Vertex isn't found.");
        }

        int edgeIndex = get_edge_index(new Edge(start, end, null));
        if (edgeIndex == -1) {
            throw new InvalidEdgeException("Edge isn't found.");
        }

        for (int i = 0; i < vertexNumber; i++) {
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

    /**
     * Method for getting neighbours of vertex.
     *
     * @param name of vertex.
     */
    public ArrayList<VertexT> get_neighbours(VertexT name) throws InvalidVertexException {
        ArrayList<VertexT> neighboursList = new ArrayList<>();
        int vertexIndex = get_vertex_index(name);
        if (vertexIndex == -1) {
            throw new InvalidVertexException("Vertex isn't founded.");
        }

        for (int ind = 0; ind < edgeNumber; ind++) {
            int pointer = matrix.get(vertexIndex).get(ind);
            if (pointer == 2) {
                neighboursList.add(name);
            }
            if (pointer == 1) {
                for (int i = 0; i < vertexNumber; i++) {
                    if (matrix.get(i).get(ind) == -1) {
                        neighboursList.add(vertices.get(i));
                    }
                }
            }
        }
        return neighboursList;
    }

    /**
     * Method for printing my graph.
     */
    public void print_graph() {
        for (int i = 0; i < vertexNumber; i++) {
            System.out.println("Vertex " + vertices.get(i) + ": " + matrix.get(i));
        }
        System.out.println("\n");
    }


}
