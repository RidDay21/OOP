package ru.nsu.laptev;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        AdjMatrix<Integer> new1 = new AdjMatrix<Integer>();
        new1.addVertex(12);
        new1.addVertex(14);
        new1.addVertex(35);

        System.out.println(new1.matrix);

        new1.delVertex(12);

        System.out.println(new1.matrix);

    }
}