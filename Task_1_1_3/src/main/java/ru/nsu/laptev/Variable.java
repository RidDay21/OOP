package ru.nsu.laptev;

/**
 * Class for implementation variable.
 */
public class Variable extends Expression {
    private String var;

    /**
     * Constructor of class.
     *
     * @param var
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
     * @param exp
     * @return
     */
    @Override
    public Expression derivative(String exp) {
        return (exp.equals(var) ? new Number(1) : new Number(0));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp
     * @return
     */
    @Override
    public int eval(String exp) {//x = 10; y = 13;
        return Parser.Parsing(var, exp);
    }
}
