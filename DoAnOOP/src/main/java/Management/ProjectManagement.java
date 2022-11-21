package Management;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Class.*;

public class ProjectManagement implements IConfig {
    private List<Project> arrProject = new ArrayList<Project>();
    private List<ParticipateProject> parEmployee = new ArrayList<ParticipateProject>();

    public ProjectManagement(List<Project> arrProject, List<ParticipateProject> parEmployee) {
        this.arrProject = arrProject;
        this.parEmployee = parEmployee;
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

    public void add(Project p) {
        arrProject.add(p);
    }

    public void add(ParticipateProject e) {
        parEmployee.add(e);
    }

    public void remove(Project p) {
        arrProject.remove(p);
    }

    public void remove(ParticipateProject e) {
        parEmployee.remove(e);
    }

    /**
    * Hiẻn thị nhân viên đang tham gia dự án p
    *
    * @param
     */
    public void showInfor(Project p) {
        this.parEmployee.stream().filter(parE -> parE.getProject().equals(p)).forEach(e -> {
            e.getEmployee().showInfo();
        });
    }

    /**
    * Hiển thị dự án nhân viên đang tham gia
    * @param
     */
    public void showInfor(Employee e) {
        this.parEmployee.stream().filter(parE -> parE.getEmployee().equals(e)).forEach(parE -> parE.getProject().showInfor());
    }

    /**
     * Update dự án thông qua tên hoặc Id
     * @param p is project name or id
     */
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

    public List<Project> search(Project p) {
        return arrProject.stream().filter(a1 -> a1.equals(p)).collect(Collectors.toList());
    }

    public List<Project> search(String name) {
        return arrProject.stream().filter(a1 -> a1.getName().contains(name)).collect(Collectors.toList());
    }
}
