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
     * @param exp
     * @return
     */
    public abstract Expression derivative(String exp);

    /**
     * Abstract method for substituting variable values and calculating the value.
     * @param exp
     * @return
     */
    public abstract int eval(String exp);
}
