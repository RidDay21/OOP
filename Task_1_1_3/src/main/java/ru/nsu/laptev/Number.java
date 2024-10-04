package ru.nsu.laptev;

public class Number extends Expression {

    private int numb;


    public Number(int numb) {
        this.numb = numb;
    }

    @Override
    public void print() {
        System.out.println(numb);
    }

    @Override
    public Expression derivative(String exp) {
        return new Number(0);
    }

    @Override
    public int eval(String exp) {
        return numb;
    }
}
