package Class;

import javax.naming.InvalidNameException;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import extension.Validate;

public abstract class Employee extends Person {
    protected static int NUM_EMPLOYEE = 0;
    protected String id;
    {
        NUM_EMPLOYEE++;
    }
    private String email;
    private double salary;

    public Employee() {

    }

    public Employee(String name, String gender, Date dob, String email) {
        super(name, gender, dob);
        this.email = email;
    }

    public Employee(String name, String gender, String dob, String email) throws ParseException {
        super(name, gender, dob);
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getNumEmployee() {
        return NUM_EMPLOYEE;
    }

    public double getAllowance() {
        return 0;
    }

    public double getCoefficient() {
        return Role.NORMAL.getCoefficient();
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public double calcSalary() {
        return BASIC_SALARY * this.getCoefficient() + this.getAllowance();
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + this.id);
        super.showInfo();
        System.out.println("Email: " + this.email);
    }

    public String toString() {
        return super.toString() + String.format("Email: %s\n", this.email);
    }

    @Override
    public void updateInfor() throws ParseException {
        try {
//            System.out.print("Nhập tên: ");
//            super.setName(myInp.nextLine());
//            System.out.print("Giới tính: ");
//            super.setGender(myInp.nextLine());
//            System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
//            super.setDob(f.parse(myInp.nextLine()));
            super.updateInfor();
            System.out.print("Email: ");
            this.email = myInp.nextLine();
        } catch(InputMismatchException e) {
            System.out.println(e);
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }
}
