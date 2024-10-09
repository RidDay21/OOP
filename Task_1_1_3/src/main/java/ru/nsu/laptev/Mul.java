package ru.nsu.laptev;

/**
 * Class for implementation multiplication.
 */
public class Mul extends Expression {
    private Expression left_mult;
    private Expression right_mult;

    /**
     * Constructor of class.
     *
     * @param left_mult
     * @param right_mult
     */
    public Mul(Expression left_mult, Expression right_mult) {
        this.left_mult = left_mult;
        this.right_mult = right_mult;
    }

    /**
     * Method for printing expression.
     */
    @Override
    public void print() {
        System.out.print("(");
        left_mult.print();
        System.out.print("*");
        right_mult.print();
        System.out.print(")");
    }

    /**
     * Method for counting the derivative of expression.
     *
     * @param exp
     * @return
     */
    @Override
    public Expression derivative(String exp) {
        return new Add(new Mul(left_mult, right_mult.derivative(exp)), new Mul(left_mult.derivative(exp), right_mult));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp
     * @return
     */
    @Override
    public int eval(String exp) {
        return (left_mult.eval(exp) * right_mult.eval(exp));
    }

}
