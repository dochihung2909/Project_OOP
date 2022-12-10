package Class;

import javax.naming.InvalidNameException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Programer extends Employee {
    private double otSalary;

    {
        id = String.format("P-%05d",NUM_EMPLOYEE);
    }

    public Programer() {
    }
    public Programer(String name, String gender, Date dob, String email, double otSalary) {
        super(name, gender, dob, email);
        this.otSalary = otSalary;
    }

    public Programer(String name, String gender, String dob, String email, double otSalary) throws ParseException, InvalidNameException {
        super(name, gender, dob, email);
        this.otSalary = otSalary;
    }

    public double getOtSalary() {
        return otSalary;
    }

    public void setOtSalary(double otSalary) {
        this.otSalary = otSalary;
    }

    public double getCoefficient() {
        return Role.PROGRAMMER.getCoefficient();
    }

    public double getAllowance() {
        return otSalary;
    }
    @Override
    public void updateInfor() throws ParseException {
        super.updateInfor();
        System.out.println("Enter OT Salary: ");
        this.otSalary = myInp.nextDouble();
    }
}
