package ru.nsu.laptev;

/**
 * Abstract Class for implementation pure abstract functions.
 */
public abstract class Expression {
    /**
     * Abstract method for derivation of expression.
     */
    public abstract void print();

    /**
     * Abstract method for counting the derivative of expression.
     *
     * @param exp pass variable for our derivative.
     * @return result of derivative.
     */
    public abstract Expression derivative(String exp);

    /**
     * Abstract method for substituting variable values and calculating the value.
     *
     * @param exp for pass the value of each variable.
     * @return result of our expression with values of variables.
     */
    public abstract int eval(String exp);
}
