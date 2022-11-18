package Class;

public class ParticipateProject {
    private Project project;
    private Employee employee;

    public ParticipateProject(Project project, Employee employee) {
        this.project = project;
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void showProjectInfor() {
        this.project.showInfor();
    }

    public void showEmployeeInfor() {
        this.employee.showInfo();
    }
}
