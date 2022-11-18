package Management;
import Class.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeManagement {
    private List<Employee> arrE = new ArrayList<Employee>();

    public EmployeeManagement(List<Employee> arrE) {
        this.arrE = arrE;
    }

    public List<Employee> getArrE() {
        return arrE;
    }

    public void setArrE(List<Employee> arrE) {
        this.arrE = arrE;
    }

    public void add(Employee e) {
        arrE.add(e);
    }

    public void remove(Employee e) {
        arrE.remove(e);
    }

    public void remove(String id) {
        arrE.remove(arrE.stream().filter(a1-> a1.getId().equals(id)).findFirst().get());
    }

    public Employee searchById(String id) {
        return arrE.stream().filter(a1 -> a1.getId().contains(id)).findFirst().get();
    }

    public List<Employee> search(String name) {
        return arrE.stream().filter(a1 -> a1.getName().contains(name)).toList();
    }

    public List<Employee> search(Date dob) {
        return arrE.stream().filter(a1 -> a1.getDob().equals(dob)).toList();
    }

    public List<Employee> search(int age) {
        return arrE.stream().filter(a1 -> a1.getAge() == age).toList();
    }

    public List<Employee> search(int ageFrom,int ageTo) {
        return arrE.stream().filter(a1 -> (a1.getAge() >= ageFrom && a1.getAge() <= ageTo)).toList();
    }
}
