package ru.nsu.laptev;

public abstract class Expression {

    public abstract void print();

    public abstract Expression derivative(String exp);

    public abstract int eval(String exp);
}
