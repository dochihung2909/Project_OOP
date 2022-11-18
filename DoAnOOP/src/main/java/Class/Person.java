package Class;

import java.text.ParseException;
import java.time.Year;
import java.util.Date;
public class Person  implements IConfig{
    private String name;
    private String gender;
    private Date dob;

    public Person(String name, String gender, String dob) throws ParseException {
        this.name = name;
        this.gender = gender;
        this.dob = f.parse(dob);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Year.now().getValue() - dob.getYear();
    }

    public void showInfo() {
        System.out.printf("Name: %s\nGender: %s\nDOB: %s\n",this.name,this.gender,f.format(this.dob));
    }
}
