package extension;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import Class.*;
import exception.MaxException;

import javax.naming.InvalidNameException;

public final class ReadFile implements IConfig {
    private ReadFile() {

    }

    public static void readFile() {
        try {
//            Read Employee Data
            Scanner readEmployeeData = new Scanner(employeeData);
            while (readEmployeeData.hasNextLine()) {
                String[] query = readEmployeeData.nextLine().split(", ");
                Employee employee = null;
                String role = query[0];
                String name = query[1];
                String gender =query[2];
                String dob = query[3];
                String email = query[4];
                switch (role) {
                   case "P" -> employee = new Programer(name,gender,dob,email,Double.parseDouble(query[5]));
                   case "D" -> employee = new Designer(name,gender,dob,email, Double.parseDouble(query[5]));
                   case "T" -> employee = new Tester(name,gender,dob,email,Integer.parseInt(query[5]));
                   case "M" -> employee = new Manager(name,gender,dob,email);
                }
                if (employee != null) {
                    employeeManagement.add(employee);
                }
            }

//            Read Office Data
            Scanner readOfficeData = new Scanner(officeData);
            while (readOfficeData.hasNextLine()) {
                String[] query = readOfficeData.nextLine().split(", ");
                Office office = new Office(query[0]);
                for (int i = 1;i < query.length;i++) {
                    Employee employee = employeeManagement.searchById(query[i]);
                    office.add(employee);
                    officeManagement.addParticipate(new ParticipateOffice(employee, office));
                }
                officeManagement.addOffice(office);
            }

//            Read Project Data
            Scanner readProjectData = new Scanner(projectData);
            while (readProjectData.hasNextLine()) {
                String[] query = readProjectData.nextLine().split(", ");
                Project project = null;
                String name = query[0];
                String startDate = query[1];
                String endDate = query[2];
                double totalCost = Double.parseDouble(query[3]);
                Employee leader = employeeManagement.searchById(query[4]);
                project = new Project(name,startDate,endDate,totalCost,leader);
                projectManagement.add(new ParticipateProject(project, leader));
                for (int i = 5;i<query.length;i++) {
                    Employee employee = employeeManagement.searchById(query[i]);
                    projectManagement.add(new ParticipateProject(project, employee));
                }
                projectManagement.add(project);
            }
//            Read Relationship data
            Scanner readRelativenData = new Scanner(relativeData);
            while (readRelativenData.hasNextLine()) {
                String[] query = readRelativenData.nextLine().split(", ");
                String name = query[0];
                String gender = query[1];
                String dob = query[2];
                String relation = query[3];
                Employee employee = employeeManagement.searchById(query[4]);
                Relative relative = new Relative(name,gender,dob,relation);
                InsurancePolicy Ip = new InsurancePolicy(employee, relative);
                relativeManagement.add(Ip);
            }

            Scanner readManagerData = new Scanner(managerData);
            while (readManagerData.hasNextLine()) {
                String[] query = readManagerData.nextLine().split(", ");
                Employee manager = employeeManagement.searchById(query[0]);
                for (int i = 1;i<query.length;i++) {
                    Office office = new Office(query[i]);
                    ManageOffice mo = new ManageOffice(office,(Manager)manager);
                    officeManagement.addManager(mo);
                }
            }

        } catch (FileNotFoundException | ParseException | InvalidNameException e) {
            System.err.println("Read File Failure!!");
            e.printStackTrace();
        } catch (MaxException e) {
            throw new RuntimeException(e);
        }
    }
}
