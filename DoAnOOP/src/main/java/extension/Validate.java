package extension;
import exception.*;
import Class.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Validate implements IConfig {

    private Validate() {
    }


    public static void checkDate(Date birthDay) throws InvalidDateException {
        GregorianCalendar dob = new GregorianCalendar();
        dob.setTime(birthDay);
        if (dob.after(GreCalandar.getTime())) {
            throw new InvalidDateException("\n INVALID DATE OF BIRTH!! \n");
        }
    }

    public static void checkEmail(String email) throws InvalidEmailException {
        if (!email.matches("^[\\w]+[\\w\\-_\\.]+@(\\w+\\.)+\\w+$")) {
            throw new InvalidEmailException("\n INVALID EMAIL!! \n");
        }
    }

    public static void checkNullObject(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    public static void checkName(String name) throws InvalidNameException {
        if (!name.matches("^\\pL+[\\pL\\pZ\\pP]{0,}$")) {
            throw new InvalidNameException("\n INVALID NAME!! \n");
        }
    }

}
