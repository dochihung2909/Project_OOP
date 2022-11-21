package Class;

public enum Role {
    NORMAL(1),
    TESTER(1.2),
    DESIGNER(1.5),
    PROGRAMMER(2.5);

    private final double coefficient;

    Role(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
