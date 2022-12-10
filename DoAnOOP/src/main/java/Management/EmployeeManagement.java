package Management;
import Class.*;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagement {
    private List<Employee> arrE = new ArrayList<Employee>();

    public EmployeeManagement(List<Employee> arrE) {
        this.arrE = arrE;
    }

    public EmployeeManagement() {
    }

    public List<Employee> getArrE() {
        return arrE;
    }

    public void setArrE(List<Employee> arrE) {
        this.arrE = arrE;
    }

    public void add(Employee... e) {
        arrE.addAll(Arrays.asList(e));
    }

    public void remove(Employee... e) {
        arrE.removeAll(Arrays.asList(e));
    }

    public void remove(String id) {
        arrE.remove(arrE.stream().filter(a1-> a1.getId().equals(id)).findFirst().get());
    }

    public Employee searchById(String id) {
        return arrE.stream().filter(a1 -> a1.getId().equals(id)).findFirst()
                .orElseThrow(() -> new NullPointerException("Invalid ID"));
    }

    public List<Employee> search(String name) {
        return arrE.stream().filter(a1 -> a1.getName().contains(name)).collect(Collectors.toList());
    }

    public List<Employee> search(Date dob) {
        return arrE.stream().filter(a1 -> a1.getDob().equals(dob)).collect(Collectors.toList());
    }

    public List<Employee> search(int age) {
        return arrE.stream().filter(a1 -> a1.getAge() == age).collect(Collectors.toList());
    }

    public List<Employee> search(int ageFrom,int ageTo) {
        if (ageFrom <= ageTo) {
            return arrE.stream().filter(a1 -> (a1.getAge() >= ageFrom && a1.getAge() <= ageTo)).collect(Collectors.toList());
        } else {
            throw new InputMismatchException("INVALID AGE!!");
        }
    }

    public void calcSalary() {
        this.arrE.forEach(e -> {
            e.setSalary(e.calcSalary());
            e.showInfo();
            System.out.printf("Salary: %,.2f", e.getSalary());
        });
    }

    public void showInfor() {
        this.arrE.forEach(e -> e.showInfo());
    }
}
