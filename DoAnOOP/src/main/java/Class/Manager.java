package Class;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Manager extends Employee {
    private Date startDate;

    public Manager(String name, String gender, String dob, String email, List<Office> office, double salary, double coefficient, Date startDate) throws ParseException {
        super(name, gender, dob, email, office, salary, coefficient);
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) throws ParseException {
        this.startDate = f.parse(startDate);
    }
}
