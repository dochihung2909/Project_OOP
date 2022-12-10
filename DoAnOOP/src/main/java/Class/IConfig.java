package Class;

import Management.EmployeeManagement;
import Management.OfficeManagement;
import Management.ProjectManagement;
import Management.RelationshipManagement;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public interface IConfig {
    File officeData = new File("src/main/resources/OfficeData.txt");
    File employeeData = new File("src/main/resources/EmployeeData.txt");
    File projectData = new File("src/main/resources/ProjectData.txt");
    File relativeData = new File("src/main/resources/RelativeData.txt");
    File managerData = new File("src/main/resources/ManagerData.txt");
    EmployeeManagement employeeManagement = new EmployeeManagement();
    OfficeManagement officeManagement = new OfficeManagement();
    ProjectManagement projectManagement = new ProjectManagement();
    RelationshipManagement relativeManagement = new RelationshipManagement();
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    Scanner myInp = new Scanner(System.in);
    Calendar GreCalandar = new GregorianCalendar();

    int MAX_OFFICE_MANAGE = 2;
    int MAX_PROJECT = 3;
    int MAX_EMPLOYEE = 10;
    int MIN_EMPLOYEE = 5;
    int BASIC_SALARY = 1000000;
}