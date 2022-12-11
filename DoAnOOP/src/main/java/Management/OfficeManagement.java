package Management;
import Class.*;
import exception.ManageException;

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

    public void addParticipate(ParticipateOffice participate) {
        if (!this.arrParticipate.stream().anyMatch(p -> p.equals(participate))) {
            arrParticipate.add((participate));
        }

    }

    public void addManager(ManageOffice manager) throws ManageException {
        if (!this.arrManger.stream().anyMatch(m -> m.equals(manager))) {
            if (numOfUnderManagement(manager.getManager()) > MAX_OFFICE_MANAGE) {
                throw new ManageException("A Manager can only manage up to 2 office!!");
            } else if (isManaged(manager.getOffice())) {
                throw new ManageException("This office had manager!!");
            } else {
                arrManger.add((manager));
            }
        } else {
            System.out.println("Manager existed!!");
        }


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
            System.out.printf("\n======= %s ======\n",o.getName());
            Manager x = arrManger.stream().filter(m -> m.getOffice().equals(o)).findFirst().get().getManager();
            System.out.printf("\nManager: %s - %s\n\n", x.getName(),x.getId());
            o.showEmployeeInfor();
        }
    }

    public void showInforManager(Manager m) {
        m.showInfo();
        arrManger.forEach(arrM -> {
            if (arrM.getManager().equals(m)) {
                System.out.printf("============ Office Name:  %s ============\n\n",arrM.getOffice().getName());
            }
        });
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

    public void updatePromote(Employee e) {
        this.arrOffice.forEach(o -> {
            o.getArrEmployee().forEach(employee -> {
                if (employee.getName().equals(e.getName())) {
                    employee.setId(e.getId());
                }
            } );
        });
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

    public ManageOffice searchManager(Office office) {
        return this.arrManger.stream().filter(a -> a.getOffice().equals(office)).findFirst()
                .orElseThrow(() -> new NullPointerException("Invalid office"));
    }
    public List<ManageOffice> ManageOffice(Manager m) {
        return arrManger.stream().filter(a1 -> a1.getManager().equals(m)).collect(Collectors.toList());
    }

    public void setManger(Manager manager, Office office) {
        ManageOffice tempM = this.arrManger.stream().filter(m -> m.getOffice().equals(office)).findFirst()
                .orElseThrow(() -> new NullPointerException("Invalid Data"));
        tempM.setManager(manager);
    }

    public int numOfUnderManagement(Manager manager) {
        return (int) arrManger.stream().filter(m -> m.getManager().equals(manager)).count();
    }

    public boolean isManaged(Office office) {
        return this.arrManger.stream().anyMatch(m -> m.getOffice().equals(office));
    }

}
