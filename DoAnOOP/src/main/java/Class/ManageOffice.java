package Class;

import java.util.Date;

public class ManageOffice implements IConfig {
    private Date startDay = GreCalandar.getTime();
    private Office office;
    private Manager manager;

    public ManageOffice(Office office, Manager manager) {
        this.office = office;
        this.manager = manager;
    }

    public ManageOffice(){

    }

    public Date getStartDay() {
        return startDay;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice( Office office) {
        this.office = office;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager( Manager manager) {
        this.manager = manager;
    }
}
