package Class;

import javax.naming.InvalidNameException;
import java.text.ParseException;
import java.util.Date;

public class Relative extends Person implements IConfig{
    private String relationship;

    public Relative() {
    }

    public Relative(String name, String gender, String dob, String relationship) throws ParseException, InvalidNameException {
        super(name, gender, dob);
        this.relationship = relationship;
    }

    public Relative(String name, String gender, Date dob, String relationship) {
        super(name, gender, dob);
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void updateInfor() throws ParseException {
        System.out.print("Enter Name: ");
        super.setName(myInp.nextLine());
        System.out.print("Enter Gender: ");
        super.setGender(myInp.nextLine());
        System.out.print("Enter day of birth (dd/mm/yyyy): ");
        super.setDob(f.parse(myInp.nextLine()));
        System.out.print("Enter relationship: ");
        this.relationship = myInp.nextLine();
    }

    public void showInfor() {
        super.showInfo();
        System.out.println("Relationship: " + this.relationship);
    }
}
