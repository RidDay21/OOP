package ru.nsu.laptev;

/**
 * Class for implementation of Number.
 */
public class Number extends Expression {

    private int numb;

    /**
     * Constructor of class.
     * @param numb
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
     * @param exp
     * @return
     */
    @Override
    public Expression derivative(String exp) {
        return new Number(0);
    }

    /**
     * Method for substituting variable values and calculating the value.
     * @param exp
     * @return
     */
    @Override
    public int eval(String exp) {
        return numb;
    }
}

