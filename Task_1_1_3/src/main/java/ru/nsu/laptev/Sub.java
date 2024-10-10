package ru.nsu.laptev;

/**
 * Class for implementation subtraction.
 */
public class Sub extends Expression {
    private Expression left;
    private Expression right;

    /**
     * Constructor of class.
     *
     * @param left for passing demunitive.
     * @param right for passing deductible.
     */
    public Sub(Expression left, Expression right) {
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
        System.out.print("-");
        right.print();
        System.out.print(")");
    }

    /**
     * Method for counting the derivative of expression.
     *
     * @param exp for pass the variable to count the variable
     * @return result of derivative of substraction.
     */
    @Override
    public Expression derivative(String exp) {
        return new Sub(right.derivative(exp), left.derivative(exp));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp for pass the value of each variable.
     * @return the value of subtraction.
     */
    @Override
    public double eval(String exp) {
        return (left.eval(exp) - right.eval(exp));
    }
}

