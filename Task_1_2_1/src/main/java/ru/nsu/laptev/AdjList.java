package ru.nsu.laptev;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjList<V, E  extends Number>  implements Graph<V, E> {
    private static final int SIZE = Integer.MAX_VALUE;

    public ArrayList<ArrayList<V>> matrix = new ArrayList<>();
    private ArrayList<V> vertexes = new ArrayList<>();
    private ArrayList<Edge<V, E>> edges = new ArrayList<>();

    private int vertex_number;
    private int edge_number;

    public int get_vertex_count() {
        return vertex_number;
    }

    public ArrayList<V> get_list_vertex() {
        return vertexes;
    }

    public int get_vertex_index(V name) {
        return vertexes.indexOf(name);
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

    public char[] read_from_file() throws IOException {
        FileInputStream inputStream = null;
        Scanner scanner = null;
        try {
            File file = new File("путь_к_вашему_файлу/fileTest.txt"); // Укажите полный путь к вашему файлу
            inputStream = new FileInputStream(file);
            scanner = new Scanner(inputStream);

            int numVertices = scanner.nextInt();
            for (int i = 0; i < numVertices; i++) {
//                addVertex(scanner.next());
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


    public void addVertex(V name) {

    }
    public void delVertex(V name) {

    }

    public void addEdge(V start, V end, E name) throws InvalidObjectException {

    }
    public void delEdge(V start, V end) throws InvalidObjectException {

    }

    public void get_neighbours(V name) throws InvalidObjectException {

    }
    public void print_graph() {

    }
}
