package ru.nsu.laptev;

public class Variable extends Expression {
    private String var;

    public Variable(String var) {
        this.var = var;
    }

    public String return_var() {
        return var;
    }

    @Override
    public void print() {
        System.out.print("\"" + var + "\"");
    }

    @Override
    public Expression derivative(String exp) {
        return new Variable("0");
    }

    @Override
    public int eval(String exp) {
        return 4;
    }
}
