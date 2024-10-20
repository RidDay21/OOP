package ru.nsu.laptev;

import javax.lang.model.element.UnknownElementException;
import java.io.InvalidObjectException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int flag = 0;
        if (flag == 0) {
            AdjMatrix<Integer, Number> new1 = new AdjMatrix<>();
            new1.addVertex(12);
            new1.addVertex(14);
            new1.addVertex(35);

            try {
                new1.addEdge(14,35,10.4);
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }

            try {
                new1.addEdge(35,14,13.2);
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }

//            try {
//                new1.delEdge(14,35);
//            } catch(InvalidObjectException e) {
//                System.out.println("Dumb?");
//            }


            new1.print_graph();
            try {
                new1.get_neighbours(14);
            } catch (InvalidObjectException e) {
                System.out.println("Boba?");
            }
        }

        if (flag == 1) {
            IncMatrix<String, Number> new1 = new IncMatrix<>();
            new1.addVertex("12");
            new1.addVertex("aboba");
            new1.addVertex("35");

            new1.print_graph();

            try {
                new1.addEdge("12","35",100);
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }

            new1.print_graph();

            try {
                new1.addEdge("35","12",3456);
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }

            new1.print_graph();

            try {
                new1.delEdge("12","35");
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?" + e);
            }

            System.out.println("dick");
            new1.print_graph();

            try {
                new1.delVertex("aboba");
            } catch (InvalidObjectException epr) {
                System.out.println(epr);
            }

            new1.print_graph();

            try {
                new1.get_neighbours("35");
            } catch (InvalidObjectException e) {
                System.out.println(e);
            }
        }

    }
}