package ru.nsu.laptev;

/**
 * Class for implementation division.
 */
public class Div extends Expression {
    private Expression numerator;
    private Expression denominator;

    /**
     * Constructor of my class.
     *
     * @param numerator
     * @param denominator
     */
    public Div(Expression numerator, Expression denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Method for printing expression.
     */
    @Override
    public void print() {
        System.out.print("(");
        numerator.print();
        System.out.print("/");
        denominator.print();
        System.out.print(")");
    }

    /**
     * Method for counting the derivative of expression.
     *
     * @param exp
     * @return
     */
    public Expression derivative(String exp) {
        return new Div(new Sub(new Mul(numerator.derivative(exp), denominator), new Mul(numerator, denominator.derivative(exp))), new Mul(denominator, denominator));
    }

    /**
     * Method for substituting variable values and calculating the value.
     *
     * @param exp
     * @return
     */
    public int eval(String exp) throws ArithmeticException {
        if (denominator.eval(exp) == 0) {
            throw new ArithmeticException("division by ZERO. HOOOOOOOW?!?!?!?!?");
        }
        return ((numerator.eval(exp)) / (denominator.eval(exp)));
    }
}

