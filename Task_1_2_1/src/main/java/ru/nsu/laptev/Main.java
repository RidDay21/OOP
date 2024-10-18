package ru.nsu.laptev;

import javax.lang.model.element.UnknownElementException;
import java.io.InvalidObjectException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


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
}