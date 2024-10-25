package ru.nsu.laptev;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing method.
 */
public class TopoSortTest {

    @Test
    public void testTopologicalSort() {
        String[] vertices = {"A", "B", "C", "D"};
        IncMatrix<String, Integer> graph = new IncMatrix<>();
        for (String s : vertices) {
            try {
                graph.addVertex(s);
            } catch (InvalidVertexException e) {
                System.out.println("ok");
            }
        }
        try {
            graph.addEdge("A", "B", 1);
        } catch (InvalidVertexException epr) {
            System.out.println();
        } catch (InvalidEdgeException epr) {
            System.out.println();
        }
        try {
            graph.addEdge("C", "D", 1);
        } catch (InvalidVertexException epr) {
            System.out.println();
        } catch (InvalidEdgeException epr) {
            System.out.println();
        }

        try {
            graph.addEdge("B", "C", 1);
        } catch (InvalidVertexException epr) {
            System.out.println();
        } catch (InvalidEdgeException epr) {
            System.out.println();
        }
        TopoSort<String, Integer> topoSort = new TopoSort<>(graph);
        try {
            ArrayList<String> result = topoSort.topologicalSort();
            assertTrue(result.get(0).equals("A"));
            assertTrue(result.get(1).equals("B"));
            assertTrue(result.get(2).equals("C"));
            assertTrue(result.get(3).equals("D"));
        } catch (CycleFoundException | InvalidVertexException e) {
            fail("Unexpected Exception");
        }
    }

    @Test
    public void testCycleInGraph() throws CycleFoundException, InvalidVertexException {
        Graph<String, Integer> graph = new IncMatrix<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        try {
            graph.addEdge("A", "B", 1);
        } catch (InvalidVertexException epr) {
            System.out.println();
        } catch (InvalidEdgeException epr) {
            System.out.println();
        }
        try {
            graph.addEdge("B", "C", 1);
        } catch (InvalidVertexException epr) {
            System.out.println();
        } catch (InvalidEdgeException epr) {
            System.out.println();
        }
        try {
            graph.addEdge("C", "A", 1);
        } catch (InvalidVertexException epr) {
            System.out.println();
        } catch (InvalidEdgeException epr) {
            System.out.println();
        }
        TopoSort<String, Integer> topoSort = new TopoSort<>(graph);
        try {
            topoSort.topologicalSort();
        } catch (CycleFoundException e) {
            System.out.println();
        } catch (InvalidVertexException e) {
            System.out.println();
        }
    }
}
