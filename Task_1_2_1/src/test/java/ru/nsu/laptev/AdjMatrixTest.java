package ru.nsu.laptev;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdjMatrixTest {

    @Test
    void addVertex() {
        AdjMatrix<String, Integer> graph = new AdjMatrix<>();
        try {
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            assertEquals(3, graph.get_vertices().size());
        } catch (InvalidVertexException e) {

        }
    }

    @Test
    void delVertex() {
        AdjMatrix<String, Integer> graph = new AdjMatrix<>();
        try {
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            graph.delVertex("B");
            assertEquals(2, graph.get_vertices().size());
        } catch (InvalidVertexException | InvalidEdgeException e) {

        }
    }

    @Test
    void addEdge() {
        AdjMatrix<String, Integer> graph = new AdjMatrix<>();
        try {
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addEdge("A", "B", 1);
            assertEquals(1, graph.get_edges().size());
        } catch (InvalidVertexException | InvalidEdgeException e) {

        }
    }

    @Test
    void delEdge() {
        AdjMatrix<String, Integer> graph = new AdjMatrix<>();
        try {
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addEdge("A", "B", 1);
            graph.delEdge("A", "B");
            assertEquals(0, graph.get_edges().size());
        } catch (InvalidVertexException | InvalidEdgeException e) {

        }
    }

    @Test
    void get_vertex_index() {
        AdjMatrix<String, Integer> graph = new AdjMatrix<>();
        try {
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            assertEquals(1, graph.get_vertex_index("B"));
        } catch (InvalidVertexException e) {

        }
    }

    @Test
    void get_edge_index() {
        AdjMatrix<String, Integer> graph = new AdjMatrix<>();
        try {
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            graph.addEdge("A", "B", 1);
            graph.addEdge("B", "C", 2);
            assertEquals(1, graph.get_edge_index(new Edge<>("B", "C", 2)));
        } catch (InvalidVertexException | InvalidEdgeException e) {

        }
    }

    @Test
    void read_from_file() {
        AdjMatrix<String, Integer> graph = new AdjMatrix<>();
        String filePath = "path/to/your/file.txt"; 
        try {
            graph.read_from_file(filePath);
        } catch (FileNotFoundException e) {

        }
    }
}
