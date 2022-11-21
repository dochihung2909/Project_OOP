package Class;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee {
    private Date startDate;

    private List<Office> manageOffice = new ArrayList<>();
    {
        countId++;
        id = String.format("M-%05d", countId);
        startDate = GreCalandar.getTime();
    }

    public Manager(String name, String gender, String dob, String email, List<Office> manageOffice) throws ParseException {
        super(name, gender, dob, email);
        this.manageOffice = manageOffice;
    }

    public Manager(String name, String gender, String dob, String email) throws ParseException {
        super(name, gender, dob, email);
    }

    public Manager(String name, String gender, Date dob, String email, List<Office> manageOffice) throws ParseException {
        super(name, gender, dob, email);
        this.manageOffice = manageOffice;
    }

    public Manager(String name, String gender, Date dob, String email) {
        super(name, gender, dob, email);
    }

    public Manager(String name, String gender, String dob, String email, List<Office> office, String startDate) throws ParseException {
        super(name, gender, dob, email, office);
        this.startDate = f.parse(startDate);
    }

    public Manager(String name, String gender, Date dob, String email, List<Office> office, Date startDate) throws ParseException {
        super(name, gender, dob, email, office);
        this.startDate = startDate;
    }

    public Manager(String name, String gender, Date dob, String email, Date startDate) {
        super(name, gender, dob, email);
        this.startDate = startDate;
    }

    public Manager(String name, String gender, String dob, String email, String startDate) throws ParseException {
        super(name, gender, dob, email);
        this.startDate = f.parse(startDate);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) throws ParseException {
        this.startDate = f.parse(startDate);
    }
}
