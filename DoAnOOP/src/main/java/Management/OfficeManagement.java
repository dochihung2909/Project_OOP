package Management;
import Class.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OfficeManagement implements IConfig {
    private List<Office> arrOffice = new ArrayList<>();
    private List<ParticipateOffice> arrParticipate = new ArrayList<>();
    private List<ManageOffice> arrManger = new ArrayList<>();

    public OfficeManagement() {

    }

    public OfficeManagement(List<Office> arrOffice, List< ParticipateOffice> arrParticipate, List< ManageOffice> arrManger) {
        this.arrOffice = arrOffice;
        this.arrParticipate = arrParticipate;
        this.arrManger = arrManger;
    }

    public List<Office> getArrOffice() {
        return arrOffice;
    }

    public void setArrOffice(List< Office> arrOffice) {
        this.arrOffice = arrOffice;
    }

    public List< ParticipateOffice> getArrParticipate() {
        return arrParticipate;
    }

    public void setArrParticipate(List< ParticipateOffice> arrParticipate) {
        this.arrParticipate = arrParticipate;
    }

    public List< ManageOffice> getArrManger() {
        return arrManger;
    }

    public void setArrManger(List< ManageOffice> arrManger) {
        this.arrManger = arrManger;
    }

    public void addOffice(Office... office) {
        arrOffice.addAll(Arrays.asList(office));
    }

    public void addParticipate(ParticipateOffice... participate) {
        arrParticipate.addAll(Arrays.asList(participate));
    }

    public void addManager(ManageOffice... manager) {
        arrManger.addAll(Arrays.asList(manager));
    }

    public void removeOffice(Office... office) {
        arrOffice.removeAll(Arrays.asList(office));
    }

    public void removeParticipate(ParticipateOffice... participate) {
        arrOffice.removeAll(Arrays.asList(participate));
    }

    public void removeManager(ManageOffice... manager) {
        arrOffice.removeAll(Arrays.asList(manager));
    }

    public void removeAllParticipate(Employee e) {
        List<ParticipateOffice> pList = this.arrParticipate.stream().filter(parO -> parO.getEmployee().equals(e))
                .collect(Collectors.toList());
        pList.forEach(this::removeParticipate);
    }

    public void removeAllOffice(Office office) {
        List<ParticipateOffice> pList = this.arrParticipate.stream().filter(parO -> parO.getOffice().equals(office))
                .collect(Collectors.toList());
        pList.forEach(this::removeParticipate);
    }

    public void showInfor() {
        for (Office o : arrOffice) {
            System.out.printf("======= %s ======\n",o.getName());
            o.getArrEmployee().forEach(e -> {
                if (e instanceof Manager) {
                    System.out.printf("Manager: %s\n",e.getName());
                }
            });
            o.showEmployeeInfor();
        }
    }

    public List<Office> searchOffice() {
        System.out.print("Enter Office Name: ");
        String temp = myInp.nextLine();
        return arrOffice.stream().filter(a1 -> a1.getName().contains(temp)).collect(Collectors.toList());
    }

    public Office searchOffice(String name) {
        return arrOffice.stream().filter(a1 -> a1.getName().contains(name)).findFirst()
                .orElseThrow(() -> new NullPointerException("Invalid Office"));
    }

    public List<ParticipateOffice> searchParticipate() {
        System.out.print("Enter Employee Name: ");
        String temp = myInp.nextLine();
        return arrParticipate.stream().filter(a1 -> a1.getEmployee().getName().contains(temp)).collect(Collectors.toList());
    }


    public List<ParticipateOffice> searchParticipate(Employee e) {
        return arrParticipate.stream().filter(a1 -> a1.getEmployee().equals(e)).collect(Collectors.toList());
    }

    public List<ParticipateOffice> searchParticipate(String name) {
        return arrParticipate.stream().filter(a1 -> a1.getEmployee().getName().contains(name)).collect(Collectors.toList());
    }

    public List<ManageOffice> searchManager() {
        System.out.print("Enter Manager Name: ");
        String temp = myInp.nextLine();
        return arrManger.stream().filter(a1 -> a1.getManager().getName().contains(temp)).collect(Collectors.toList());
    }

    public List<ManageOffice> ManageOffice(String name) {
        return arrManger.stream().filter(a1 -> a1.getManager().getName().contains(name)).collect(Collectors.toList());
    }

    public void setManger(Manager manager) {
        System.out.print("Enter Office Name: ");
        String temp = myInp.nextLine();
        for (ManageOffice x : arrManger) {
            if (x.getOffice().getName().contains(temp)) {
                x.setManager(manager);
                return;
            }
        }
        System.out.println("Office Name is invalid!!!");
        System.out.println("Please Enter again!!");
        this.setManger(manager);
    }


}
