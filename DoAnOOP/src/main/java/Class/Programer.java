package Class;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Programer extends Employee {
    private double otSalary;

    {
        countId++;
        id = String.format("P-%010d",countId);
    }

    public Programer(String name, String gender, String dob, String email, List<Office> office,double otSalary) throws ParseException {
        super(name, gender, dob, email, office);
        this.otSalary = otSalary;
    }

    public Programer(String name, String gender, Date dob, String email, List<Office> office, double otSalary) throws ParseException {
        super(name, gender, dob, email, office);
        this.otSalary = otSalary;
    }

    public Programer(String name, String gender, Date dob, String email, double otSalary) {
        super(name, gender, dob, email);
        this.otSalary = otSalary;
    }

    public Programer(String name, String gender, String dob, String email, double otSalary) throws ParseException {
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

    @Override
    public double getSalary() {
        return super.getSalary() + otSalary;
    }

    @Override
    public void updateInfor() throws ParseException {
        super.updateInfor();
        System.out.println("Enter OT Salary: ");
        this.otSalary = myInp.nextDouble();
    }
}
