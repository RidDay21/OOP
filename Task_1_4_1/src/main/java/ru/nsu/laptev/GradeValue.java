package ru.nsu.laptev;

/**
 * Enum class for implementation different possible marks for exam.
 */
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
