package ru.nsu.laptev;

import javax.lang.model.element.UnknownElementException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int flag;
        Scanner in = new Scanner(System.in);
        flag = in.nextInt();
        Graph<String, Number> new1  = new IncMatrix<>();
        switch(flag) {
            case 1:
                new1 = new IncMatrix<>();
                break;
            case 2:
                new1 = new AdjMatrix<>();
                break;
            case 3:
                new1 = new AdjList<>();
            default:
                break;
        }
        try {
            new1.addVertex("12");
        } catch (InvalidVertexException e) {

        }

        try {
            new1.addVertex("aboba");
        } catch (InvalidVertexException e) {

        }
        try {
            new1.addVertex("35");
        } catch (InvalidVertexException e) {

        }
        try {
            new1.addVertex("Marcus");
        } catch (InvalidVertexException e) {

        }
        try {
            new1.addVertex("Sick");
        } catch (InvalidVertexException e) {

        }

            new1.print_graph();

            try {
                new1.addEdge("12","35",100);
            } catch(InvalidVertexException e) {
                System.out.println("Dumb?");
            }

            new1.print_graph();

            try {
                new1.addEdge("35","12",3456);
            } catch(InvalidVertexException e) {
                System.out.println("Dumb?");
            }

            try {
                new1.addEdge("Sick","Sick",0.1);
            } catch (InvalidVertexException e) {
                System.out.println("Dumb?");
            }

            try {
                new1.addEdge("Marcus","35",34);
            } catch(InvalidVertexException e) {
                System.out.println("Dumb?");
            }

            new1.print_graph();

            try {
                new1.delEdge("12","35");
            } catch(InvalidVertexException e) {
                System.out.println("Dumb?" + e);
            } catch (InvalidObjectException e) {
                System.out.println("Dumb?" + e);
            }

            System.out.println("dick");
            new1.print_graph();

            try {
                new1.delVertex("aboba");
            } catch (InvalidVertexException epr) {
                System.out.println(epr);
            } catch (InvalidObjectException e) {
                System.out.println(e);
            }

            new1.print_graph();

            try {
                ArrayList<String> neighbours =  new1.get_neighbours("35");
                System.out.println(neighbours);
            } catch (InvalidVertexException e) {
                System.out.println(e);
            }
        }
    }