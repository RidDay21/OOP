package ru.nsu.laptev;

import java.security.InvalidParameterException;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.FileNotFoundException;
import javax.lang.model.element.UnknownElementException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int flag;
        Scanner in = new Scanner(System.in);
        flag = in.nextInt();
        Graph<String, Number> new1 = new IncMatrix<>();
        switch (flag) {
            case 1:
                new1 = new IncMatrix<>();
                break;
            case 2:
                new1 = new AdjMatrix<>();
                break;
            case 3:
                new1 = new AdjList<>();
                break;
            default:
                throw new InvalidParameterException("eblan");
        }
        try {
            new1.addVertex("12");
        } catch (InvalidVertexException e) {
            System.out.println();
        }

        try {
            new1.addVertex("aboba");
        } catch (InvalidVertexException e) {
            System.out.println();
        }
        try {
            new1.addVertex("35");
        } catch (InvalidVertexException e) {
            System.out.println();
        }
        try {
            new1.addVertex("Marcus");
        } catch (InvalidVertexException e) {
            System.out.println();
        }
        try {
            new1.addVertex("Sick");
        } catch (InvalidVertexException e) {
            System.out.println();
        }

        new1.print_graph();

        try {
            new1.addEdge("12", "35", 100);
        } catch (InvalidVertexException e) {
            System.out.println("Dumb?");
        } catch (InvalidEdgeException e) {
            System.out.println("Dumb?" + e);
        }

        new1.print_graph();

        try {
            new1.addEdge("35", "12", 3456);
        } catch (InvalidVertexException e) {
            System.out.println("Dumb?");
        } catch (InvalidEdgeException e) {
            System.out.println("Dumb?" + e);
        }

        try {
            new1.addEdge("Sick", "Sick", 0.1);
        } catch (InvalidVertexException e) {
            System.out.println("Dumb?");
        } catch (InvalidEdgeException e) {
            System.out.println("Dumb?" + e);
        }

        try {
            new1.addEdge("Marcus", "35", 34);
        } catch (InvalidVertexException e) {
            System.out.println("Dumb?");
        } catch (InvalidEdgeException e) {
            System.out.println("Dumb?" + e);
        }

        new1.print_graph();

        try {
            new1.delEdge("12", "35");
        } catch (InvalidVertexException e) {
            System.out.println("Dumb?" + e);
        } catch (InvalidEdgeException e) {
            System.out.println("Dumb?" + e);
        }

        System.out.println("dick");
        new1.print_graph();
        ArrayList<Edge<String, Number>> ab = new1.get_edges();
        for (Edge e : ab) {
            System.out.println(e.get_end_vertex() + ", " + e.get_start_vertex() + ", "
                    + e.get_name());
        }

        System.out.println();
        try {
            new1.delEdge("Sick", "Sick");
        } catch (InvalidVertexException e) {
            System.out.println("Dumb?" + e);
        } catch (InvalidEdgeException e) {
            System.out.println("Dumb?" + e);
        }

        try {
            new1.delVertex("aboba");
        } catch (InvalidVertexException epr) {
            System.out.println(epr);
        } catch (InvalidEdgeException e) {
            System.out.println(e);
        }

        new1.print_graph();

        TopoSort ts = new TopoSort(new1);
        ArrayList<String> topOrder = new ArrayList<>();

        try {
            topOrder = ts.topologicalSort();
            System.out.println(topOrder);
        } catch (InvalidVertexException e) {
            System.out.println("be");
        } catch (CycleFoundException e) {
            System.out.println("ok");
        }
    }
}


