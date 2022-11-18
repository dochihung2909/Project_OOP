package Class;

import java.text.ParseException;

public class Relative extends Person implements IConfig{
    private String relationship;

    public Relative(String name, String gender, String dob, String relationship) throws ParseException {
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
        System.out.print("Nhập tên: ");
        super.setName(myInp.nextLine());
        System.out.print("Nhập giới tính: ");
        super.setGender(myInp.nextLine());
        System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
        super.setDob(f.parse(myInp.nextLine()));
        System.out.print("Nhập quan hệ: ");
        this.relationship = myInp.nextLine();
    }

    public void showInfor() {
        super.showInfo();
        System.out.println("Quan hệ: " + this.relationship);
    }
}
