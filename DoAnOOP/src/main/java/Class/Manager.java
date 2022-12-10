package Class;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee {
    {
        id = String.format("M-%05d", NUM_EMPLOYEE);
    }

    public Manager(String name, String gender, String dob, String email) throws ParseException {
        super(name, gender, dob, email);
    }

    public Manager(String name, String gender, Date dob, String email) {
        super(name, gender, dob, email);
    }

    public double getCoefficient() {
        return Role.MANAGER.getCoefficient();
    }
}
