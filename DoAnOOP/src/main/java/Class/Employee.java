package Class;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee extends Person {
    private static int countId = 0;
    private String id;
    {
        countId++;
        id = String.format("E%010d",countId);
    }
    private String email;
    private List<Office> offices = new ArrayList<>();
    private double salary;
    private double coefficient;


    public Employee(String name, String gender, String dob, String email, List<Office> office, double salary, double coefficient) throws ParseException {
        super(name, gender, dob);
        this.email = email;
        this.offices = office;
        this.salary = salary;
        this.coefficient = coefficient;
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

    public List<Office> getOffice() {
        return offices;
    }

    public void setOffice(List<Office> office) {
        this.offices = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double calcSalary() {
        return salary * coefficient;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + this.id);
        super.showInfo();
        System.out.printf("Email: %s\nSalary: %f\n",this.email,this.calcSalary());
        System.out.print("Offices: ");
        if (offices != null) {
            offices.forEach(a -> {
                System.out.print(a.getName() + ", ");
            });
        } else {
            System.out.println("Unknown");
        }

    }

    public void updateInfor() throws ParseException {
        System.out.print("Nhập tên: ");
        super.setName(myInp.nextLine());
        System.out.print("Giới tính: ");
        super.setGender(myInp.nextLine());
        System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
        super.setDob(f.parse(myInp.nextLine()));
        System.out.print("Email: ");
        this.email = myInp.nextLine();
    }
}
