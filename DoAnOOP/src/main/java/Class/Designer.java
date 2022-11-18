package Class;

import java.text.ParseException;
import java.util.List;

public class Designer extends Employee {
    private double bonus;

    public Designer(String name, String gender, String dob, String email, List<Office> office, double salary, double coefficient, double bonus) throws ParseException {
        super(name, gender, dob, email, office, salary, coefficient);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calcSalary() {
        return super.calcSalary() + bonus;
    }
}
