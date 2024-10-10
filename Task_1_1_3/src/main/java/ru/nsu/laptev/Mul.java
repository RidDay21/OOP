package ru.nsu.laptev;

/**
 * Class for implementation multiplication.
 */
public class Mul extends Expression {
    private Expression left;
    private Expression right;

    /**
     * Constructor of class.
     *
     * @param left  passing left_milt.
     * @param right passing right_mult.
     */
    public Mul(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Method for printing expression.
     */
    @Override
    public void print() {
        System.out.print("(");
        left.print();
        System.out.print("*");
        right.print();
        System.out.print(")");
    }

    /**
     * Method for counting the derivative of expression.
     *
     * @param exp for passing variable for derivative.
     * @return value of derivative of multiplication.
     */
    @Override
    public Expression derivative(String exp) {
        return new Add(new Mul(left, right.derivative(exp)),
                new Mul(left.derivative(exp), right));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp for pass the value of each variable.
     * @return result of multiplication with values 0f variables.
     */
    @Override
    public int eval(String exp) {
        return (left.eval(exp) * right.eval(exp));
    }

}
