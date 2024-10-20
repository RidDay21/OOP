package ru.nsu.laptev;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix<V, E extends Number> implements Graph<V, E> {
    public ArrayList<ArrayList<E>> matrix = new ArrayList<>();
    private ArrayList<V> vertexes = new ArrayList<>();
    private ArrayList<Edge<V, E>> edges = new ArrayList<>();

    private int vertex_number;
    private int edges_number;

    public int get_vertex_number(V name) {
        return vertexes.indexOf(name);
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
    public void addVertex(V name) {
        vertex_number++;
        vertexes.add(name);
        ArrayList<E> row = new ArrayList<>();
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

    public void delVertex(V name) throws InvalidObjectException{
        int index = get_vertex_number(name);
        if (index == -1) {
            throw new InvalidObjectException(("Vertex isn't found"));
        }
        for (int i = 0; i < vertex_number; i++) {
            matrix.get(i).remove(index);
        }
        matrix.remove(index);//removing row from matrix
        vertexes.remove(name);
        vertex_number--;
    }

    public void addEdge(V start, V end, E name) throws InvalidObjectException {
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
        for (int i = 0; i < vertex_number; i++) {
            E edge = matrix.get(index).get(i);
            if (edge != null) {
                System.out.print(matrix.get(index).get(i) + ", ");
            }
        }
    }

    public void print_graph() {
        for (int i = 0; i < vertex_number; i++) {
            System.out.println("Vertex " + vertexes.get(i) + " - " + matrix.get(i));
        }
    }
}


//and i need toposort