package ru.nsu.laptev;

/**
 * Main Class.
 */
public class Main {
    /**
     * Main class for testing my program.
     */
    public static void main(String[] args) {
        Expression e = new Add(new Number(3.6), new Div(new Number(2), new Variable("x")));
        e.print();

        try {
            e.eval("z = 10");
        } catch (ArithmeticException pre) {
            System.out.println("\n---\nSome of variables wasn't initialized.\n---\n");
        }
        Expression de = e.derivative("x");
        de.print();

        e = new Div(new Number(5), new Number(0));
        try {
            System.out.println(e.eval(""));
        } catch (ArithmeticException pre) {
            System.out.println("\n---\nTry to divide by Zero.\n---\n");
        }
    }
}