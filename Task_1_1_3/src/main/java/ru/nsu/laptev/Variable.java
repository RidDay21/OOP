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
        System.out.print(var);
    }

    @Override
    public Expression derivative(String exp) {
        return (exp.equals(var) ? new Number(1) : new Number(0));
    }

    @Override
    public int eval(String exp) {//x = 10; y = 13;
        return Parser.Parsing(var, exp);
    }
}
