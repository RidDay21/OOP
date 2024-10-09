package ru.nsu.laptev;

/**
 * Class for implementation addition.
 */
public class Add extends Expression {
    private Expression left_sum;
    private Expression right_sum;

    /**
     * Constructor of class.
     *
     * @param left_sum for passing left_sum.
     * @param right_sum for passing right_sum.
     */
    public Add(Expression left_sum, Expression right_sum) {
        this.left_sum = left_sum;
        this.right_sum = right_sum;
    }

    /**
     * Method for printing expression.
     */
    @Override
    public void print() {
        System.out.print("(");
        left_sum.print();
        System.out.print("+");
        right_sum.print();
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
        return new Add(left_sum.derivative(exp), right_sum.derivative(exp));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp for passing values of each variable.
     * @return result of summary with values of variables.
     */
    @Override
    public int eval(String exp) {
        return (left_sum.eval(exp) + right_sum.eval(exp));
    }
}

