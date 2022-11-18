package Class;

public class InsurancePolicy {
    private Employee employee;
    private static int countId =0;
    private String ipId;
    {
        countId++;
        ipId = String.format("IP%010d",countId);
    }
    private Relative relative;

    public InsurancePolicy(Employee employee, String ipId, Relative relative) {
        this.employee = employee;
        this.ipId = ipId;
        this.relative = relative;
    }

    public String getIpId() {
        return ipId;
    }

    public Relative getRelative() {
        return relative;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void showInfor() {
        this.employee.showInfo();
        this.relative.showInfor();
    }
}
