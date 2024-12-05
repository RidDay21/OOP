package ru.nsu.laptev;

public enum GradeValue {
    НЕУДОВЛЕТВОРИТЕЛЬНО(2),
    УДОВЛЕТВОРИТЕЛЬНО(3),
    ХОРОШО(4),
    ОТЛИЧНО(5);

    private final int numericValue;

    GradeValue(int numericValue) {
        this.numericValue = numericValue;
    }

    public int getNumericValue() {
        return numericValue;
    }
}
