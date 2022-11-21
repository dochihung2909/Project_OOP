package extension;
import exception.*;
import Class.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Validate implements IConfig {

    private Validate() {
    }


    public static void checkDate(Date birthDay) throws DateException {
        GregorianCalendar dob = new GregorianCalendar();
        dob.setTime(birthDay);
        if (dob.after(GreCalandar.getTime())) {
            throw new DateException("\n INVALID DATE OF BIRTH!! \n");
        }
    }

    public static void checkEmail(String email) throws EmailException {
        if (!email.matches("^[\\w]+[\\w\\-_\\.]+@(\\w+\\.)+\\w+$")) {
            throw new EmailException("\n INVALID EMAIL!! \n");
        }
    }

    public static void checkMaxRoom(List<Office> offices) throws ManageException {
        if (offices.size() >= MAX_OFFICE) {
            throw new ManageException("\n EXCEEDING THE MANAGEMENT OF ROOMS!! \n");
        }
    }

    public static void checkNullObject(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    public static void checkName(String name) throws NameException {
        if (!name.matches("^\\pL+[\\pL\\pZ\\pP]{0,}$")) {
            throw new NameException("\n INVALID NAME!! \n");
        }
    }

}
