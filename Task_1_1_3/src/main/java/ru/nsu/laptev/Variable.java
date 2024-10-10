package ru.nsu.laptev;

/**
 * Class for implementation variable.
 */
public class Variable extends Expression {
    private String var;

    /**
     * Constructor of class.
     *
     * @param var for passing the value.
     */
    public Variable(String var) {
        this.var = var;
    }

    public String return_var() {
        return var;
    }

    /**
     * Method for printing expression.
     */
    @Override
    public void print() {
        System.out.print(var);
    }

    /**
     * Method for counting the derivative of expression.
     *
     * @param exp for pass the variable to count the variable.
     * @return derivative of variable, if var == exp - return 1.
     */
    @Override
    public Expression derivative(String exp) {
        return (exp.equals(var) ? new Number(1) : new Number(0));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp for pass the value of each variable
     * @return value of variable.
     */
    @Override
    public double eval(String exp) {
        return Parser.parsing(var, exp);
    }
}
