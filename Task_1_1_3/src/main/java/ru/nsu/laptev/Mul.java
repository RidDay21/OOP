package ru.nsu.laptev;

public class Mul extends Expression {
    private Expression left_mult;
    private Expression right_mult;

    public Mul(Expression left_mult, Expression right_mult) {
        this.left_mult = left_mult;
        this.right_mult = right_mult;
    }

    @Override
    public void print() {
        System.out.print("(");
        left_mult.print();
        System.out.print("*");
        right_mult.print();
        System.out.print(")");
    }

    @Override
    public Expression derivative(String exp) {
        return new Add(new Mul(left_mult, right_mult.derivative(exp)), new Mul(left_mult.derivative(exp), right_mult));
    }

    @Override
    public int eval(String exp) {
        return (left_mult.eval(exp) * right_mult.eval(exp));
    }

}
