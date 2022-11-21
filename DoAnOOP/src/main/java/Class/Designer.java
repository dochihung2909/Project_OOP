package Class;

import java.text.ParseException;
import java.util.List;

public class Designer extends Employee {
    private double bonus;

    {
        countId++;
        id = String.format("D-%010d",countId);
    }

    public Designer(String name, String gender, String dob, String email, double bonus) throws ParseException {
        super(name, gender, dob, email);
        this.bonus = bonus;
    }

    public Designer(String name, String gender, String dob, String email, List<Office> office, double bonus) throws ParseException {
        super(name, gender, dob, email, office);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getCoefficient()  {
        return  Role.DESIGNER.getCoefficient();
    }
    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public void updateInfor() throws ParseException {
        super.updateInfor();
        System.out.println("Enter Bonus: ");
        this.bonus = myInp.nextDouble();
    }
}
