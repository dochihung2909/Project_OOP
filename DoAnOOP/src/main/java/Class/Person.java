package Class;

import java.text.ParseException;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person  implements IConfig{
    private String name;
    private String gender;
    private Date dob;

    public Person(String name, String gender, String dob) throws ParseException {
        this.name = name;
        this.gender = gender;
        this.dob = f.parse(dob);
    }

    public Person(String name, String gender, Date dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
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
        GregorianCalendar birthDay = new GregorianCalendar();
        birthDay.setTime(this.dob);
        int age = GreCalandar.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        if (GreCalandar.get(Calendar.MONTH) > birthDay.get(Calendar.MONTH)) {
            age--;
        } else if (GreCalandar.get(Calendar.MONTH) == birthDay.get(Calendar.MONTH)) {
            if (GreCalandar.get(Calendar.DAY_OF_MONTH) > birthDay.get(Calendar.DAY_OF_MONTH)) {
                age--;
            }
        }
        return age;
    }

    public void showInfo() {
        System.out.printf("Name: %s\nGender: %s\nDOB: %s\n",this.name,this.gender,f.format(this.dob));
    }

    public void updateInfor() throws ParseException {
        System.out.print("Nhập tên: ");
        this.name = (myInp.nextLine());
        System.out.print("Giới tính: ");
        this.gender = (myInp.nextLine());
        System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
        this.dob = (f.parse(myInp.nextLine()));
    }
}
