package Management;
import Class.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OfficeManagement implements IConfig {
    private List<Office> arrOffice = new ArrayList<Office>();

    public OfficeManagement(List<Office> arrOffice) {
        this.arrOffice = arrOffice;
    }

    public List<Office> getArrOffice() {
        return arrOffice;
    }

    public void setArrOffice(List<Office> arrOffice) {
        this.arrOffice = arrOffice;
    }

    public void add(Office office) {
        arrOffice.add(office);
    }

    public void remove(Office office) {
        arrOffice.remove(office);
    }

    public void showInfor() {
        arrOffice.forEach(a1 -> a1.showInfor());
    }

    public List<Office> search(String name) {
        System.out.print("Nhập tên phòng ban: ");
        String temp = myInp.nextLine();
        return arrOffice.stream().filter(a1 -> a1.getName().contains(temp)).toList();
    }
}
