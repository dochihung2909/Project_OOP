package Class;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Tester extends Employee{
    private final int ERROR_MONEY = 200000;
    private int errors;
    {
        id = String.format("T-%05d",NUM_EMPLOYEE);
    }

    public Tester() {
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

    public double getAllowance() {
        return errors * ERROR_MONEY;
    }

    @Override
    public void updateInfor() throws ParseException {
        super.updateInfor();
        System.out.println("Enter Number Errors: ");
        this.errors = myInp.nextInt();
    }
}
