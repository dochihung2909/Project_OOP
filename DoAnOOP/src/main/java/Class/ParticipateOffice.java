package Class;

public class ParticipateOffice {
    private Employee employee;
    private Office office;

    public ParticipateOffice(Employee employee, Office office) {
        this.employee = employee;
        this.office = office;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public void showInfor() {
        employee.showInfo();
        office.showOfficeInfor();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParticipateOffice that = (ParticipateOffice) o;
        return this.office.getName().equals(that.getOffice().getName()) && this.employee.getId().equals(that.getEmployee().getId());
    }
}
