package ru.nsu.laptev;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Expression e = new Add(new Number(3), new Div(new Number(2), new Variable("x")));
        e.print();//(3+(2*x))
        System.out.println("\n\n");
        Expression de = e.derivative("x");
        de.print();

        e = new Div(new Number(5), new Number(0));
        try {
            System.out.println(e.eval(""));
        } catch (ArithmeticException pre) {
            System.out.println("U stupid bastard.");
        }
    }
}