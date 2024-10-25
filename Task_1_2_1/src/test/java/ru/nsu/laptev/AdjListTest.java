package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class AdjListTest {
    AdjList<String, Integer> graph = new AdjList<>();
    String[] vertexes = {"a", "b", "c", "d", "e", "f"};
    ArrayList<String> vertices = new ArrayList<>();

    String[][] edges = {{"a", "b", "23"}, {"a", "c", "231"}, {"e", "b", "34"}, {"f", "b", "3"}, {"b", "a", "1221"}, {"d", "e", "2"}};


    @BeforeEach
    void initialize() {

        for (int i = 0; i < vertexes.length; i++) {
            vertices.add(vertexes[i]);
        }
        for (int i = 0; i < vertexes.length; i++) {
            try {
                graph.addVertex(vertices.get(i));
            } catch (InvalidVertexException e) {
                System.out.println("okok");
            }
        }
        try {
            graph.addVertex("a");
        } catch (InvalidVertexException e) {
            System.out.println("Graph has already have such vertex.");
        }
        for (int e = 0; e < edges.length; e++) {
            try {
                graph.addEdge(edges[e][0], edges[e][1], Integer.parseInt(edges[e][2]));
            } catch (InvalidEdgeException epr) {

            } catch (InvalidVertexException epr) {

            }
        }
        try {
            graph.addEdge(edges[0][0], edges[0][1], Integer.parseInt(edges[0][2]));
        } catch (InvalidEdgeException epr) {

        } catch (InvalidVertexException epr) {
            graph.print_graph();
        }
        try {
            graph.addEdge(edges[0][0], "as", Integer.parseInt(edges[0][2]));
        } catch (InvalidEdgeException epr) {

        } catch (InvalidVertexException epr) {

        }
    }

    @Test
    void graph_test() {
        ArrayList<Edge<String, Integer>> edges = new ArrayList<>();
        edges = graph.get_edges();
        int a = graph.get_edge_index(edges.get(0));
        assertEquals(a, 0);
        assertEquals(graph.get_vertices(), vertices);
        assertEquals(graph.get_vertex_index("a"), 0);
        try {
            graph.delEdge("a", "b");
        } catch (InvalidEdgeException e) {

        } catch (InvalidVertexException e) {

        }

        try {
            graph.delVertex("a");
            vertices.remove("a");
        } catch (InvalidVertexException e) {

        } catch (InvalidEdgeException e) {

        }

        try {
            graph.delVertex("c");
            vertices.remove("c");
        } catch (InvalidVertexException e) {

        } catch (InvalidEdgeException e) {

        }

        try {
            graph.delVertex("h");
            vertices.remove("h");
        } catch (InvalidVertexException e) {

        } catch (InvalidEdgeException e) {

        }
        assertEquals(graph.get_vertices().size(), vertices.size());

        ArrayList<String> neighbours = new ArrayList<>();
        try {
            neighbours = graph.get_neighbours("d");
        } catch (InvalidVertexException e) {

        }

        try {
            neighbours = graph.get_neighbours("hu");
        } catch (InvalidVertexException e) {
            System.out.println("okok");
        }

        ArrayList<String> ns = new ArrayList<>();
        ns.add("e");
        assertEquals(neighbours, ns);
    }

    @Test
    void readGraphTest() {

    }
}