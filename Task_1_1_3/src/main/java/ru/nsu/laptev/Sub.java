package ru.nsu.laptev;

public class Sub extends Expression {
    private Expression demunitive;
    private Expression deductible;

    public Sub(Expression demunitive, Expression deductible) {
        this.demunitive = demunitive;
        this.deductible = deductible;
    }

    @Override
    public void print() {
        System.out.print("(");
        deductible.print();
        System.out.print("-");
        demunitive.print();
        System.out.print(")");
    }
    @Override
    public Expression derivative(String exp) {
        return new Sub(deductible.derivative(exp), demunitive.derivative(exp));
    }
    @Override
    public int eval(String exp) {
        return (demunitive.eval(exp) / deductible.eval(exp));
    }
}

