package ru.nsu.laptev;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjList<VertexType, EdgeType extends Number> implements Graph<VertexType, EdgeType> {
    private static final int SIZE = Integer.MAX_VALUE;

    public ArrayList<ArrayList<VertexType>> matrix = new ArrayList<>();
    private ArrayList<VertexType> vertices = new ArrayList<>();
    private ArrayList<Edge<VertexType, EdgeType>> edges = new ArrayList<>();

    private int vertexNumber;
    private int edgeNumber;


    public int get_vertex_index(VertexType name) {
        return vertices.indexOf(name);
    }

    @Override
    public ArrayList<VertexType> get_vertices() {
        return vertices;
    }

    public ArrayList<Edge<VertexType, EdgeType>> get_edges() {
        return edges;
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

    public void read_from_file(Transformer<VertexType> vertexTransformer,
                               Transformer<EdgeType> edgeTransformer,
                               String path) throws FileNotFoundException {
        File file = new File(path);
        ArrayList<String> text = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            text.add(scanner.nextLine());
        }

        int amountOfVertices = Integer.parseInt(text.get(0));
        ArrayList<String> vertices_names = new ArrayList<>(Arrays.asList(text.get(1).split(", ")));
        for (int i = 0; i < amountOfVertices; i++) {
            vertices.add(vertexTransformer.transform(vertices_names.get(i)));
            try {
                addVertex(vertices.get(i));
            } catch (InvalidVertexException e) {
                System.out.println();
            }
        }
        vertexNumber = amountOfVertices;

        int amountOfEdges = Integer.parseInt(text.get(2));
        System.out.println(vertices);
        for (int i = 3; i < 3 + amountOfEdges; i++) {
            String[] edge = text.get(i).split(" ");
            VertexType start = vertexTransformer.transform(edge[0]);
            VertexType end = vertexTransformer.transform(edge[1]);
            EdgeType weight;
            if (edge.length > 2) {
                weight = edgeTransformer.transform(edge[2]);
            } else {
                weight = edgeTransformer.transform("1");
            }
            try {
                addEdge(start, end, weight);
            } catch (InvalidVertexException e) {
                System.out.println();
            } catch (InvalidEdgeException epr) {
                System.out.println();
            }
        }
    }


    public void addVertex(VertexType name) throws InvalidVertexException {
        if (vertices.contains(name)) {
            throw new InvalidVertexException("Graph has already haven such vertex.");
        }
        vertexNumber++;
        vertices.add(name);
        ArrayList<VertexType> row = new ArrayList<>();
        matrix.add(row);
    }

    public void delVertex(VertexType name) throws InvalidVertexException, InvalidEdgeException {
        int index = get_vertex_index(name);
        if (index == -1) {
            throw new InvalidVertexException("Vertex isn't found");
        }
        for (int i = 0; i < vertexNumber; i++) {
            matrix.get(i).remove(name);
        }
        matrix.remove(index); //removing row from matrix
        vertices.remove(name);
        vertexNumber--;
    }


    public void addEdge(VertexType start, VertexType end, EdgeType name) throws InvalidVertexException,
            InvalidEdgeException {
        Edge e = new Edge(start, end, name);
        if (edges.contains(e)) {
            throw new InvalidEdgeException("Edge is already in graph.");
        }
        edges.add(e);
        int startVertex = get_vertex_index(start);
        if (startVertex == -1) {
            throw new InvalidVertexException("ok");
        }
        int endVertex = get_vertex_index(end);
        if (endVertex == -1) {
            throw new InvalidVertexException("ok");
        }
        if (startVertex != -1 && endVertex != -1) {
            matrix.get(startVertex).add(end);
        } else {
            throw new InvalidVertexException(" Vertex isn't found.");
        }
    }

    /**
     * Method for deletting edge.
     */
    public void delEdge(VertexType start, VertexType end) throws InvalidEdgeException,
            InvalidVertexException {
        int startVertex = get_vertex_index(start);
        if (startVertex == -1) {
            throw new InvalidVertexException("ok");
        }
        int endVertex = get_vertex_index(end);
        if (endVertex == -1) {
            throw new InvalidVertexException("ok");
        }
        if (startVertex != -1 && endVertex != -1) {
            matrix.get(startVertex).remove(end);
        }
        for (Edge e : edges) {
            if (e.is_equal(start, end)) {
                edges.remove(e);
                return;
            }
        }
        throw new InvalidEdgeException("Edge isn't in graph.");
    }

    /**
     * Method for getting neighbours of vertex.
     */
    public ArrayList<VertexType> get_neighbours(VertexType name) throws InvalidVertexException {
        ArrayList<VertexType> neighboursList = new ArrayList<>();
        int index = vertices.indexOf(name);
        if (index == -1) {
            throw new InvalidVertexException("Vertex isn't found");
        }
        for (int i = 0; i < matrix.get(index).size(); i++) {
            neighboursList.add(matrix.get(index).get(i));
        }
        return neighboursList;
    }

    /**
     * Method for printing my graph.
     */
    public void print_graph() {
        for (int i = 0; i < vertexNumber; i++) {
            System.out.println("Vertex " + vertices.get(i) + " - " + matrix.get(i));
        }
    }
}
