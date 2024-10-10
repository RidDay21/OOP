package ru.nsu.laptev;

/**
 * Class for implementation addition.
 */
public class Add extends Expression {
    private Expression left;
    private Expression right;

    /**
     * Constructor of class.
     *
     * @param left for passing left_sum.
     * @param right for passing right_sum.
     */
    public Add(Expression left, Expression right) {
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
        System.out.print("+");
        right.print();
        System.out.print(")");
    }

    /**
     * Method for counting the derivative of expression.
     *
     * @param exp for passing variable for derivative.
     * @return derivative opf expression.
     */
    @Override
    public Expression derivative(String exp) {
        return new Add(left.derivative(exp), right.derivative(exp));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp for passing values of each variable.
     * @return result of summary with values of variables.
     */
    @Override
    public int eval(String exp) {
        return (left.eval(exp) + right.eval(exp));
    }
}

