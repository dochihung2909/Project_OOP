package Class;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Tester extends Employee{
    private final int ERROR_MONEY = 200000;
    private int errors;
    {
        countId++;
        id = String.format("T-%010d",countId);
    }

    public Tester(String name, String gender, String dob, String email, List<Office> office, int errors) throws ParseException {
        super(name, gender, dob, email, office);
        this.errors = errors;
    }

    public Tester(String name, String gender, Date dob, String email, List<Office> office, int errors) throws ParseException {
        super(name, gender, dob, email, office);
        this.errors = errors;
    }

    public Tester(String name, String gender, Date dob, String email, int errors) {
        super(name, gender, dob, email);
        this.errors = errors;
    }

    public Tester(String name, String gender, String dob, String email, int errors) throws ParseException {
        super(name, gender, dob, email);
        this.errors = errors;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public double getCoefficient() {
        return Role.TESTER.getCoefficient();
    }

    @Override
    public double getSalary() {
        return super.getSalary() + errors * ERROR_MONEY;
    }

    @Override
    public void updateInfor() throws ParseException {
        super.updateInfor();
        System.out.println("Enter Number Errors: ");
        this.errors = myInp.nextInt();
    }
}
