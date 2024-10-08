package ru.nsu.laptev;

public class Div extends Expression {
    private Expression numerator;
    private Expression denominator;


    public Div(Expression numerator, Expression denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public void print() {
        System.out.print("(");
        numerator.print();
        System.out.print("/");
        denominator.print();
        System.out.print(")");
    }


    public Expression derivative(String exp) {
        return new Div(new Sub(new Mul(numerator.derivative(exp), denominator), new Mul(numerator, denominator.derivative(exp))), new Mul(denominator, denominator));
    }

    public int eval(String exp) {
        try {
            return (numerator.eval(exp) / denominator.eval(exp));
        } catch (ArithmeticException e) {
            System.out.println("division by zero, silly guy");
        }
        finally {
            return 0;
        }
    }
}

