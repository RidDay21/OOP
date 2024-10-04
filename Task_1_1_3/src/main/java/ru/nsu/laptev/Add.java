package ru.nsu.laptev;

public class Add extends Expression {
    private Expression left_sum;
    private Expression right_sum;

    public Add(Expression left_sum, Expression right_sum) {
        this.left_sum = left_sum;
        this.right_sum = right_sum;
    }

    @Override
    public void print() {
        System.out.print("(");
        left_sum.print();
        System.out.print("+");
        right_sum.print();
        System.out.print(")");
    }
    @Override
    public Expression derivative(String exp) {
        return new Add(left_sum.derivative(exp), right_sum.derivative(exp));
    }
    @Override
    public int eval(String exp) {
        return (left_sum.eval(exp) + right_sum.eval(exp));
    }
}

