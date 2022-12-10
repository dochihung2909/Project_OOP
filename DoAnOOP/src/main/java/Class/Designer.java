package Class;

import javax.naming.InvalidNameException;
import java.text.ParseException;
import java.util.List;

public class Designer extends Employee {
    private double bonus;

    {
        id = String.format("D-%05d",NUM_EMPLOYEE);
    }

    public Designer() {
    }

    public Designer(String name, String gender, String dob, String email, double bonus) throws ParseException, InvalidNameException {
        super(name, gender, dob, email);
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
    public double getAllowance() {
        return bonus;
    }
    @Override
    public void updateInfor() throws ParseException {
        super.updateInfor();
        System.out.println("Enter Bonus: ");
        this.bonus = myInp.nextDouble();
    }
}
