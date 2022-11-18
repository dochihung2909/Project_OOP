package Class;

import java.text.ParseException;
import java.util.List;

public class Programer extends Employee {
    private double otSalary;

    public Programer(String name, String gender, String dob, String email, List<Office> office, double salary, double coefficient, double otSalary) throws ParseException {
        super(name, gender, dob, email, office, salary, coefficient);
        this.otSalary = otSalary;
    }

    public double getOtSalary() {
        return otSalary;
    }

    public void setOtSalary(double otSalary) {
        this.otSalary = otSalary;
    }
    @Override
    public double calcSalary()  {
        return super.calcSalary() + otSalary;
    }
}
