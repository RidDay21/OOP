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

        System.out.println("\n------------------------------");

//        int res = Parser.Parsing("x","y = 10; y = 13");
//        System.out.println(res);

        e = new Add(new Variable("y"), new Mul(new Number(2),new Variable("x")));
        e.print();
        System.out.println("\n------------------------------");
        int result = e.eval("x = 10; g = 13; x = 25");
        System.out.println(result);

    }
}