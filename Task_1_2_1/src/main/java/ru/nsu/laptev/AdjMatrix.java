package ru.nsu.laptev;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix<VertexType, EdgeType extends Number> implements Graph<VertexType, EdgeType> {
    public ArrayList<ArrayList<EdgeType>> matrix = new ArrayList<>();
    private ArrayList<VertexType> vertices = new ArrayList<>();
    private ArrayList<Edge<VertexType, EdgeType>> edges = new ArrayList<>();

    private int vertex_number;
    private int edges_number;

    public int get_vertex_index(VertexType name) {
        return vertices.indexOf(name);
    }

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

    public char[] read_from_file() throws IOException {
        FileInputStream inputStream = null;
        Scanner scanner = null;
        try {
            File file = new File("путь_к_вашему_файлу/fileTest.txt"); // Укажите полный путь к вашему файлу
            inputStream = new FileInputStream(file);
            scanner = new Scanner(inputStream);

            int numVertices = scanner.nextInt();
            for (int i = 0; i < numVertices; i++) {
                String vertexName = scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        char[] def = new char[4];
        return def;
    }
    /**
     * It's turned out that I need to add a null value to every existing row in the matrix
     * @param name - name of new vertex
     */
    public void addVertex(VertexType name) {
        vertex_number++;
        vertices.add(name);
        ArrayList<EdgeType> row = new ArrayList<>();
        for (int i = 0; i < vertex_number; i++) {
            row.add(null);
        }
        matrix.add(row);
        for (int i = 0; i < vertex_number; i++) {
            while (matrix.get(i).size() < vertex_number) {
                matrix.get(i).add(null);
            }
        }
    }

    public void delVertex(VertexType name) throws InvalidVertexException, InvalidObjectException{
        int index = get_vertex_index(name);
        if (index == -1) {
            throw new InvalidVertexException("ok");
        }
        for (int i = 0; i < vertex_number; i++) {
            matrix.get(i).remove(index);
        }
        matrix.remove(index);//removing row from matrix
        vertices.remove(name);
        vertex_number--;
    }

    public void addEdge(VertexType start, VertexType end, EdgeType name) throws InvalidVertexException {
        int startVertex = get_vertex_index(start);
        int endVertex = get_vertex_index(end);
        if (startVertex != -1 && endVertex != -1) {
            matrix.get(startVertex).set(endVertex,name);
        } else {
            throw new InvalidVertexException("ok");
        }
    }

    public void delEdge(VertexType start, VertexType end) throws InvalidObjectException, InvalidVertexException {
        int startVertex = get_vertex_index(start);
        int endVertex = get_vertex_index(end);
        if (startVertex != -1 && endVertex != -1) {
            matrix.get(startVertex).set(endVertex, null);
        } else {
            throw new InvalidVertexException("InvalidVertexException");
        }
    }

    public ArrayList<VertexType> get_neighbours(VertexType name) throws InvalidVertexException {
        ArrayList<VertexType> neighbours_list = new ArrayList<>();
        int index = vertices.indexOf(name);
        if (index == -1) {
            throw new InvalidVertexException("Vertex isn't found");
        }
        for (int i = 0; i < vertex_number; i++) {
            EdgeType edge = matrix.get(index).get(i);
            if (edge != null) {
                neighbours_list.add(vertices.get(i));
            }
        }
        return neighbours_list;
    }

    public void print_graph() {
        for (int i = 0; i < vertex_number; i++) {
            System.out.println("Vertex " + vertices.get(i) + " - " + matrix.get(i));
        }
    }
}


//and i need toposort