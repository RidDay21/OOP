package ru.nsu.laptev;

/**
 * Class for implementation of Number.
 */
public class Number extends Expression {
    private int numb;

    /**
     * Constructor of class.
     *
     * @param numb pass value to private_numb.
     */
    public Number(int numb) {
        this.numb = numb;
    }

    /**
     * Method for printing expression.
     */
    @Override
    public void print() {
        System.out.print(numb);
    }

    /**
     * Method for counting the derivative of expression.
     *
     * @param exp for pass the variable to count the variable
     * @return 0.
     */
    @Override
    public Expression derivative(String exp) {
        return new Number(0);
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp for pass the value of each variable.
     * @return value of numb.
     */
    @Override
    public int eval(String exp) {
        return numb;
    }
}

