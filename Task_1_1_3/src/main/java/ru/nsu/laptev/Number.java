package ru.nsu.laptev;

/**
 * Class for implementation of Number
 */
public class Number extends Expression {

    private int numb;


    public Number(int numb) {
        this.numb = numb;
    }

    @Override
    public void print() {
        System.out.print(numb);
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
/*@Override

public int eval(String exp) {
    return new Number(Parser.Parsing(var,exp));
}

 */
