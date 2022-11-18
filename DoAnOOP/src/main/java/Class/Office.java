package Class;

import java.util.ArrayList;
import java.util.List;

public class Office implements IConfig{
    private String name = "Unknown";
    private List<Employee> arrEmployee = new ArrayList<>();

    public Office(String name, List<Employee> arrEmployee) {
        this.name = name;
        this.arrEmployee = arrEmployee;
    }

    public Office() {
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

    public void add(Employee employee) {
        arrEmployee.add(employee);
    }

    public void remove(Employee employee) {
        arrEmployee.remove(employee);
    }

    public void showInfor() {
        System.out.printf("============ %s ============\nManage",this.name);
        arrEmployee.stream().filter(a1 -> (a1 instanceof Manager)).findFirst().get().showInfo();
    }

    public void showEmployeeInfor() {
        arrEmployee.forEach(Employee::showInfo);
    }

    public void update() {
        System.out.print("Name Office: ");
        this.name = myInp.nextLine();
    }
}
