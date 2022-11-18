package Class;

import java.text.ParseException;
import java.util.List;

public class Tester extends Employee{
    private final int ERROR_MONEY = 200000;
    private int errors;

    public Tester(String name, String gender, String dob, String email, List<Office> office, double salary, double coefficient, int errors) throws ParseException {
        super(name, gender, dob, email, office, salary, coefficient);
        this.errors = errors;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    @Override
    public double calcSalary() {
        return super.calcSalary() + errors * ERROR_MONEY;
    }
}
