package extension;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import Class.*;
import exception.ManageException;
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
                String name = query[1];
                String startDate = query[2];
                String endDate = query[3];
                double totalCost = Double.parseDouble(query[4]);
                Employee leader = employeeManagement.searchById(query[5]);
                project = new Project(name,startDate,endDate,totalCost,leader);
                projectManagement.add(new ParticipateProject(project, leader));
                for (int i = 6;i<query.length;i++) {
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
                    Office office = officeManagement.searchOffice(query[i]);
                    ManageOffice mo = new ManageOffice(office,(Manager)manager);
                    if (!office.isInOffice(manager)) {
                        office.add(manager);
                    }
                    officeManagement.addParticipate(new ParticipateOffice(manager,office));
                    officeManagement.addManager(mo);
                }
            }

        } catch (FileNotFoundException | MaxException | ManageException | ParseException | InvalidNameException e) {
            System.err.println("Read File Failure!!");
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try {
            /**
             * Write file to OfficeData
             */
            PrintWriter writeOfficeData = new PrintWriter(officeData);
            officeManagement.getArrOffice().forEach(office -> {
                StringBuilder officeStr = new StringBuilder();
                officeStr.append(office.getName());
                office.getArrEmployee().forEach(employee -> officeStr.append(", " + employee.getId()));
                writeOfficeData.println(officeStr);
            });
            /**
             * Ghi danh sách nhân viên ra file EmployeeList
             */
            PrintWriter writeEmployeeData = new PrintWriter(employeeData);
            employeeManagement.getArrE().forEach(employee -> {
                StringBuilder employeeStr = new StringBuilder();
                String gender = employee.getGender();
                employeeStr.append(String.format("%s, %s, %s, %s, %s", employee.getId().charAt(0), employee.getName(), gender,
                        f.format(employee.getDob()), employee.getEmail()));
                switch (employee.getId().substring(0, 1)) {
                    case "P" -> employeeStr.append(", " + ((Programer) employee).getOtSalary());
                    case "D" -> employeeStr.append(", " + ((Designer) employee).getBonus());
                    case "T" -> employeeStr.append(", " + ((Tester) employee).getErrors());
                }
                writeEmployeeData.println(employeeStr);
            });
            /**
             * Ghi danh sách nhân thân ra file RelativeList
             */
            PrintWriter writeRelativeData = new PrintWriter(relativeData);
            relativeManagement.getArrRelative().forEach(insurancePolicy -> {
                Relative relative = insurancePolicy.getRelative();
                String gender = relative.getGender();
                writeRelativeData.printf("%s, %s, %s, %s, %s, %s\n", relative.getName(), gender,
                        f.format(relative.getDob()), relative.getRelationship(),
                        insurancePolicy.getEmployee().getId(),insurancePolicy.getIpId());
            });
            /**
             * Ghi danh sách dự án ra file ProjectList
             */
            PrintWriter writeProjectData = new PrintWriter(projectData);
            projectManagement.getArrProject().forEach(project -> {
                StringBuilder projectStr = new StringBuilder();
                projectStr.append(String.format("%s, %s, %s, %s, %f", project.getId(), project.getName(),
                        f.format(project.getStartDay()), f.format(project.getEndDay()),
                        project.getTotalCost()));
                projectManagement.searchEmployee(project).forEach(employee -> projectStr.append(", " + employee.getEmployee().getId()));
                writeProjectData.println(projectStr);
            });

            PrintWriter writeManagerData = new PrintWriter(managerData);
            officeManagement.getArrManger().forEach(manager -> {
                StringBuilder managerStr = new StringBuilder();
                managerStr.append(String.format("%s", manager.getManager().getId()));
                officeManagement.ManageOffice(manager.getManager()).forEach(m->{
                    managerStr.append(", " + m.getOffice().getName());
                });
                writeManagerData.println(managerStr);
            });
            writeManagerData.close();
            writeProjectData.close();
            writeRelativeData.close();
            writeEmployeeData.close();
            writeOfficeData.close();
        } catch (FileNotFoundException e) {
            System.err.println("\n** SUCCESSFULLY WRITE FILE **");
            e.printStackTrace();
        }
    }
}
