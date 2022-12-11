package Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Office implements IConfig{

    private static int NUM_OFFICE;
    {
        NUM_OFFICE++;
    }
    private String name = "Unknown";
    private List<Employee> arrEmployee = new ArrayList<>();

    public Office(String name, List<Employee> arrEmployee) {
        this.name = name;
        this.arrEmployee = arrEmployee;
    }

    public Office(String name) {
        this.name = name;
    }

    public Office() {

    }

    public static int getNumOffice() {
        return NUM_OFFICE;
    }

    public static void setNumOffice(int numOffice) {
        NUM_OFFICE = numOffice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getArrEmployee() {
        return arrEmployee;
    }

    public void setArrEmployee(List<Employee> arrEmployee) {
        this.arrEmployee = arrEmployee;
    }

    public void add(Employee... employee) {
        arrEmployee.addAll(Arrays.asList(employee));
    }

    public void remove(Employee... employee) {
        arrEmployee.removeAll(Arrays.asList(employee));
    }

    public void showOfficeInfor() {
        System.out.printf("============ Office Name:  %s ============\n",this.name);
        this.showEmployeeInfor();
    }

    public Employee search(Employee e) {
        return this.arrEmployee.stream().filter(a -> a.equals(e)).findFirst()
                .orElseThrow(() -> new NullPointerException("Invalid Data"));
    }

    public void showEmployeeInfor() {
        arrEmployee.forEach(Employee::showInfo);
    }

    public boolean isHasOffice() {
        return this.arrEmployee.stream().anyMatch(e -> e instanceof Manager);
    }

    public boolean isInOffice(Employee employee) {
        return this.arrEmployee.stream().anyMatch(e -> e.equals(employee));
    }

    public void updateInfor() {
        System.out.print("Name Office: ");
        this.name = myInp.nextLine();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Office that = (Office) o;
        return name.equals(that.name);
    }
}
