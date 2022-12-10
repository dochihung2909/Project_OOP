package Class;

import java.text.ParseException;
import java.util.Date;

public class InsurancePolicy implements IConfig{
     private static int INSURANCE_ID = 0;
     private String ipId;
    {
        INSURANCE_ID++;
        ipId = String.format("IP%010d",INSURANCE_ID);
    }

    private Employee employee;
    private Relative relative;

    public InsurancePolicy( Employee employee, Relative relative) {
        this.employee = employee;
        this.relative = relative;
    }

    public InsurancePolicy() {
    }

    public  Employee getEmployee() {
        return employee;
    }

    public void setEmployee( Employee employee) {
        this.employee = employee;
    }

    public Relative getRelative() {
        return relative;
    }

    public void setRelative( Relative relative) {
        this.relative = relative;
    }

    public void showInfor() {
        System.out.printf("Insurance Policy Id: %s\n", this.ipId);
        this.employee.showInfo();
        this.relative.showInfor();
    }

}
