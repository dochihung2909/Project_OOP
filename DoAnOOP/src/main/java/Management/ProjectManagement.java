package Management;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import Class.*;
import exception.MaxException;

public class ProjectManagement implements IConfig {
    private List<Project> arrProject = new ArrayList<Project>();
    private List<ParticipateProject> parEmployee = new ArrayList<ParticipateProject>();

    public ProjectManagement(List<Project> arrProject, List<ParticipateProject> parEmployee) {
        this.arrProject = arrProject;
        this.parEmployee = parEmployee;
    }

    public ProjectManagement() {
    }

    public List<Project> getArrProject() {
        return arrProject;
    }

    public void setArrProject(List<Project> arrProject) {
        this.arrProject = arrProject;
    }

    public List<ParticipateProject> getParEmployee() {
        return parEmployee;
    }

    public void setParEmployee(List<ParticipateProject> parEmployee) {
        this.parEmployee = parEmployee;
    }

    /**
     * Add project
     * @param p
     */
    public void add(Project p) {
        arrProject.add(p);
    }

    /**
     * Add employee
     * @param e
     * @throws MaxException
     */
    public void add(ParticipateProject e) throws MaxException {
        if (this.getNumProjectJoined(e.getEmployee()) >= MAX_PROJECT) {
            throw new MaxException("An Employee only can participate max 3 project!!");
        }
        if (this.getNumProjectJoined(e.getProject()) >= MAX_EMPLOYEE) {
            throw new MaxException("Project has a maximum of 10 members!!");
        }
        parEmployee.add(e);
    }

    /**
     * Remove project
     * @param p
     */
    public void remove(Project... p) {
        arrProject.removeAll(Arrays.asList(p));
    }

    /**
     * Remove employee
     * @param e
     */
    public void remove(ParticipateProject... e) {
        parEmployee.removeAll(Arrays.asList(e));
    }

    public void removeAll(Project p) {
        List <ParticipateProject> temp = parEmployee.stream().filter(parE -> parE.getProject().equals(p))
                .collect(Collectors.toList());
        temp.forEach(this::remove);
    }

    public void removeAll(Employee employee) {
        List <ParticipateProject> temp = parEmployee.stream().filter(parE -> parE.getEmployee().equals(employee))
                .collect(Collectors.toList());
        temp.forEach(this::remove);
    }

    /**
     * Show infor every project
     */
    public void showInfor() {
        this.arrProject.forEach(this::showInfor);
    }

    /**
     * Show infor a project
     * @param p
     */
    public void showInfor(Project p) {
        p.showInfor();
        parEmployee.forEach(e -> {
            if (e.getProject().getName().equals(p.getName()) && !e.getEmployee().getName().equals(p.getLeader().getName())) {
                e.getEmployee().showInfo();
            }
        });
    }

    /**
     * Show infor an employee
     * @param e
     */
    public void showInfor(Employee e) {
        e.showInfo();
        System.out.println("====== Project Joined ======");
        parEmployee.forEach(e1 -> {
            if (e1.getEmployee().equals(e)) {
                e1.getProject().showInfor();
            }
        });
    }

    public void update(Project p) throws ParseException {
        p.updateInfor();
    }

    public void update(Project p,Employee e) {
        p.setLeader(e);
    }

    public void update(Employee e) {
        System.out.print("Nhâp ID của dự án");
        String temp = myInp.nextLine();
        arrProject.stream().filter(a1 -> a1.getId().contains(temp)).findFirst().get().setLeader(e);
    }

    public boolean isInProject(Employee e, Project p) {
        return parEmployee.stream().anyMatch(parE -> parE.getProject().equals(p) && parE.getEmployee().equals(e));
    }

    public Project searchById(String id) {
        return arrProject.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(()-> new NullPointerException("Invalid ID"));
    }

    public List<Project> search(Project p) {
        return arrProject.stream().filter(a1 -> a1.equals(p)).collect(Collectors.toList());
    }

    public List<Project> search(Date date) {
        return arrProject.stream().filter(p -> p.getStartDay().equals(date)).collect(Collectors.toList());
    }

    public List<Project> search(double costForm,double costTo) {
        return arrProject.stream().filter(p -> p.getTotalCost() >= costForm && p.getTotalCost() <= costTo)
                .collect(Collectors.toList());
    }

    public List<Project> search(String name) {
        return arrProject.stream().filter(a1 -> a1.getName().contains(name)).collect(Collectors.toList());
    }

    public int getNumProjectJoined(Employee e) {
        return (int) this.parEmployee.stream().filter(par -> par.getEmployee().equals(e)).count();
    }

    public int getNumProjectJoined(Project p) {
        return (int ) this.parEmployee.stream().filter(par -> par.getProject().equals(p)).count();
    }

    public void sort() {
        Collections.sort(arrProject);
    }
}
