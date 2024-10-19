package ru.nsu.laptev;

import javax.lang.model.element.UnknownElementException;
import java.io.InvalidObjectException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int flag = 1;
        if (flag == 0) {
            AdjMatrix<Integer, String> new1 = new AdjMatrix<>();
            new1.addVertex(12);
            new1.addVertex(14);
            new1.addVertex(35);

            System.out.println(new1.matrix);

            try {
                new1.addEdge(14,35,"3453454");
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }

            try {
                new1.addEdge(35,14,"aboba");
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }

            System.out.println(new1.matrix + "\n\n\n\n");

            try {
                new1.delEdge(14,35);
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }


            new1.print_graph();
            try {
                new1.get_neighbours(14);
            } catch (InvalidObjectException e) {
                System.out.println("Boba?");
            }
        }

        if (flag == 1) {
            IncMatrix<Integer, String> new1 = new IncMatrix<>();
            new1.addVertex(12);
            new1.addVertex(14);
            new1.addVertex(35);

            new1.print_graph();

            try {
                new1.addEdge(14,35,"3453454");
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }

            new1.print_graph();

            try {
                new1.addEdge(35,14,"aboba");
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?");
            }

            new1.print_graph();

            try {
                new1.delEdge(14,35);
            } catch(InvalidObjectException e) {
                System.out.println("Dumb?" + e);
            }

            System.out.println("dick");
            new1.print_graph();

            try {
                new1.delVertex(14);
            } catch (InvalidObjectException epr) {
                System.out.println(epr);
            }

            new1.print_graph();

            try {
                new1.get_neighbours(14);
            } catch (InvalidObjectException e) {
                System.out.println(e);
            }
        }

    }
}