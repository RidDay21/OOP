package ru.nsu.laptev;

/**
 * Class for implementation subtraction.
 */
public class Sub extends Expression {
    private Expression demunitive;
    private Expression deductible;

    /**
     * Constructor of class.
     *
     * @param demunitive for passing demunitive.
     * @param deductible for passing deductible.
     */
    public Sub(Expression demunitive, Expression deductible) {
        this.demunitive = demunitive;
        this.deductible = deductible;
    }

    /**
     * Method for printing expression.
     */
    @Override
    public void print() {
        System.out.print("(");
        deductible.print();
        System.out.print("-");
        demunitive.print();
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
        return new Sub(deductible.derivative(exp), demunitive.derivative(exp));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp for pass the value of each variable.
     * @return the value of subtraction.
     */
    @Override
    public double eval(String exp) {
        return (demunitive.eval(exp) / deductible.eval(exp));
    }
}

