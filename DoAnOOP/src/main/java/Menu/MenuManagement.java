package Menu;

import Class.*;
import exception.*;
import extension.ReadFile;
import extension.Validate;
 
import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class MenuManagement implements IConfig {
    private static MenuManagement instance;

    private MenuManagement() {
        ReadFile.readFile();
    }

    public static MenuManagement getInstance() {
        if (instance == null) {
            instance = new MenuManagement();
        }
        return instance;
    }

    public void validate(Person person) throws InvalidNameException, InvalidEmailException, InvalidDateException {
        Validate.checkName(person.getName());
        Validate.checkDate(person.getDob());
        if (person instanceof Employee employee) {
            Validate.checkEmail(employee.getEmail());
        }
    }

    public Project createProject() throws ParseException, MaxException {
        System.out.println("Enter leader ID: ");
        Employee leader = employeeManagement.searchById(myInp.nextLine());
        Project project = new Project();
        project.setLeader(leader);
        project.updateInfor();
        projectManagement.add(new ParticipateProject(project, leader));
        return project;
    }

    public void MenuProjectManagement() {
        System.out.println("\n*** PROJECT MANAGEMENT SYSTEM ***");
        System.out.println("1. Add project");
        System.out.println("2. Update project");
        System.out.println("3. Delete project");
        System.out.println("4. Add employee to project");
        System.out.println("5. Find project by name");
        System.out.println("6. Find project by start day");
        System.out.println("7. Find project by cost");
        System.out.println("8. List of project");
        System.out.println("9. List employee of project");
        System.out.println("10. Sort project by total cost");
        System.out.println("11. Finish");
        System.out.print("- Choose: ");
        String choice = myInp.nextLine();
        switch (choice) {
            case "1" -> {
                try {
                    Project project = createProject();
                    projectManagement.add(project);
                    System.out.println("Successfully add new Project");
                } catch (NullPointerException | MaxException | ParseException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuProjectManagement();
                }
            }
            case "2" -> {
                try {
                    System.out.print("Enter project id: ");
                    Project project = projectManagement.searchById(myInp.nextLine());
                    System.out.print("Enter new leader id: ");
                    String leaderId = myInp.nextLine();
                    Employee employee = null;
                    if (leaderId.isEmpty()) {
                        employee = project.getLeader();
                    } else
                        employee = employeeManagement.searchById(leaderId);
                    if (!projectManagement.isInProject(employee, project))
                        projectManagement.add(new ParticipateProject(project, employee));
                    project.updateInfor();
                    project.setLeader(employee);
                    System.out.println("Update Successfully!!");
                } catch (MaxException | NullPointerException | ParseException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuProjectManagement();
                }
            }
            case "3" -> {
                try {
                    System.out.print("Enter project id: ");
                    String tempId = myInp.nextLine();
                    Project project = projectManagement.searchById(tempId);
                    projectManagement.remove(project);
                    projectManagement.removeAll(project);
                    System.out.println("Successfully remove project!!");
                } catch (NullPointerException e) {
                    System.err.println(e);
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuProjectManagement();
                }
            }
            case "4" -> {
                try {
                    System.out.print("Enter project id: ");
                    String tempId = myInp.nextLine();
                    Project project = projectManagement.searchById(tempId);
                    System.out.print("Enter employee id: ");
                    String tempEid = myInp.nextLine();
                    Employee employee = employeeManagement.searchById(tempEid);
                    if (!projectManagement.isInProject(employee, project)) {
                        projectManagement.add(new ParticipateProject(project, employee));
                        System.out.println("Successfully add employee to project!!");
                    } else {
                        System.out.println("Unable to add employees already in the project!!");
                    }
                } catch (MaxException | NullPointerException e) {
                    System.err.println(e.getMessage());

                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuProjectManagement();
                }
            }
            case "5" -> {
                try {
                    System.out.print("Enter project name: ");
                    List<Project> project = projectManagement.search(myInp.nextLine());
                    project.forEach(p -> {
                        projectManagement.checkRunning(p);
                        p.showInfor();
                    });
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuProjectManagement();
                }
            }
            case "6" -> {
                try {
                    System.out.print("Enter date: ");
                    Date temp = f.parse(myInp.nextLine());
                    List<Project> pList = projectManagement.search(temp);
                    if (pList.size() != 0) {
                        System.out.println("List Project with start date " + f.format(temp));
                        pList.forEach(p -> {
                            projectManagement.checkRunning(p);
                            p.showInfor();
                        });
                    } else {
                        System.out.println("No Project Exist!!");
                    }
                } catch (ParseException e) {
                    System.err.println(e.getMessage());
                } finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuProjectManagement();
                }
            }
            case "7" -> {
                try {
                    System.out.print("Form Cost: ");
                    double formCost = myInp.nextDouble();
                    System.out.print("To Cost: ");
                    double toCost = myInp.nextDouble();
                    List<Project> pList = projectManagement.search(formCost, toCost);
                    if (pList.size() != 0) {
                        System.out.printf("List Project with cost (%,.2f - %,.2f)", formCost, toCost);
                        pList.forEach(p -> {
                            projectManagement.checkRunning(p);
                            p.showInfor();
                        });
                    } else {
                        System.out.println("No Project Exist!!");
                    }
                } catch (InputMismatchException e) {
                    System.err.println(e.getMessage());
                } finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    myInp.nextLine();
                    MenuProjectManagement();
                }
            }
            case "8" -> {
                System.out.println("All of projects");
                projectManagement.showInfor();
                System.out.print("Press any key to continue!!");
                myInp.nextLine();
                MenuProjectManagement();
            }
            case "9" -> {
                try {
                    System.out.print("Enter project id: ");
                    Project p = projectManagement.searchById(myInp.nextLine());
                    if (p != null) {
                        System.out.println("List of employee");
                        projectManagement.showInfor(p);
                    }
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());

                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuProjectManagement();
                }
            }
            case "10" -> {
                projectManagement.sort();
                System.out.println("Successfully sort!!");
                System.out.print("Press any key to continue!!");
                myInp.nextLine();
                MenuProjectManagement();
            }
            case "11" -> System.out.println("Finish Project Management!!");
            default -> {
                System.out.println("Invalid choice. Try Again!!");
                MenuProjectManagement();
            }
        }
    }

    public Employee createEmployee() throws ParseException, InvalidNameException, InvalidDateException, InvalidEmailException {
        System.out.print("Enter office name: ");
        Office office = officeManagement.searchOffice(myInp.nextLine());
        System.out.println("Enter type of employee\n1. Programmer\n2. Designer\n3. Tester");
        String type = myInp.nextLine();
        Employee employee = null;
        switch (type) {
            case "1" -> employee = new Programer();
            case "2" -> employee = new Designer();
            case "3" -> employee = new Tester();
            default -> {
                System.out.println("Invalid choice. Try Again!!");
                MenuProjectManagement();
            }
        }
        employee.updateInfor();
        validate(employee);
        office.add(employee);
        officeManagement.addParticipate(new ParticipateOffice(employee, office));
        return employee;
    }

    public void MenuEmployeeManagement() {
        System.out.println("\n*** EMPLOYEE MANAGEMENT SYSTEM ***");
        System.out.println("1. Add employee");
        System.out.println("2. Delete employee");
        System.out.println("3. Information joined project");
        System.out.println("4. Calculate salary for employees");
        System.out.println("5. List of employee");
        System.out.println("6. List project of employee");
        System.out.println("7. Find employee by name");
        System.out.println("8. Find employee by birth day");
        System.out.println("9. Find employee by office");
        System.out.println("10. Find employee by age");
        System.out.println("11. Find employee by form age to age");
        System.out.println("12. Finish");
        System.out.print("- Choose: ");
        String choice = myInp.nextLine();
        switch (choice) {
            case "1" -> {
                try {
                    Employee employee = createEmployee();
                    employeeManagement.add(employee);
                    System.out.println("Successfully add employee");
                } catch (InvalidNameException | NullPointerException | InvalidDateException | InvalidEmailException | ParseException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuEmployeeManagement();
                }
            }
            case "2" -> {
                System.out.print("- Enter employee id: ");
                String id = myInp.nextLine();
                try {
                    Employee employee = employeeManagement.searchById(id);
                    employeeManagement.remove(employee);
                    projectManagement.removeAll(employee);
                    officeManagement.removeAllParticipate(employee);
                    relativeManagement.search(employee).forEach(relativeManagement::remove);
                    System.out.println("Successfully remove employee");
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuEmployeeManagement();
                }
            }
            case "3" -> {
                System.out.print("- Enter project id: ");
                String projectId = myInp.nextLine();
                System.out.print("- Enter employee id: ");
                String id = myInp.nextLine();
                try {
                    Project project = projectManagement.searchById(projectId);
                    Employee employee = employeeManagement.searchById(id);
                    projectManagement.add(new ParticipateProject(project, employee));
                    System.out.println("Successfully!!");
                } catch (NullPointerException | MaxException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuEmployeeManagement();
                }
            }
            case "4" -> {
                System.out.println("Employee Salary");
                employeeManagement.calcSalary();
                System.out.print("Press any key to continue!!");
                myInp.nextLine();
                MenuEmployeeManagement();
            }
            case "5" -> {
                System.out.println("List of employee");
                employeeManagement.showInfor();
                System.out.print("Press any key to continue!!");
                myInp.nextLine();
                MenuEmployeeManagement();
            }
            case "6" -> {
                System.out.print("Enter employee id: ");
                String id = myInp.nextLine();
                try {
                    Employee employee = employeeManagement.searchById(id);
                    System.out.println("List of project participate");
                    projectManagement.showInfor(employee);
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuEmployeeManagement();
                }
            }
            case "7" -> {
                System.out.print("Enter employee name: ");
                String name = myInp.nextLine();
                System.out.printf("List of employee have name: %s\n", name.toUpperCase());
                List<Employee> eList = employeeManagement.search(name);
                if (eList.size() > 0) {
                    eList.forEach(e -> e.showInfo());
                } else {
                    System.out.println("No employee exits");
                }
                System.out.print("Press any key to continue!!");
                myInp.nextLine();
                MenuEmployeeManagement();
            }
            case "8" -> {
                System.out.print("Enter DOB (DD/MM/YYYY): ");
                try {
                    String dob = myInp.nextLine();
                    System.out.printf("List of Employee have DOB  %s\n", dob);
                    List<Employee> eList = employeeManagement.search(f.parse(dob));
                    if (eList.size() > 0) {
                        eList.forEach(e -> e.showInfo());
                    } else {
                        System.out.println("No employee exits");
                    }
                } catch (ParseException e) {
                    System.err.println(e.getMessage());
                } finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuEmployeeManagement();
                }
            }
            case "9" -> {
                System.out.print("Enter Office name: ");
                String name = myInp.nextLine();
                try {
                    Office office = officeManagement.searchOffice(name);
                    office.showEmployeeInfor();
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuEmployeeManagement();
                }
            }
            case "10" -> {
                try {
                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(myInp.nextLine());
                    System.out.printf("List of employee in %d year old\n", age);
                    List<Employee> eList = employeeManagement.search(age);
                    if (eList.size() > 0) {
                        eList.forEach(e -> e.showInfo());
                    } else {
                        System.out.println("No employee exits");
                    }
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuEmployeeManagement();
                }
            }
            case "11" -> {
                try {
                    System.out.print("Enter from age: ");
                    int fromAge = Integer.parseInt(myInp.nextLine());
                    System.out.print("Enter to age: ");
                    int toAge = Integer.parseInt(myInp.nextLine());
                    System.out.printf("Employee (%d - %d)\n", fromAge, toAge);
                    List<Employee> eList = employeeManagement.search(fromAge, toAge);
                    if (eList.size() > 0) {
                        eList.forEach(e -> e.showInfo());
                    } else {
                        System.out.println("No employee exits");
                    }
                } catch (NumberFormatException | InputMismatchException e) {
                    System.err.println(e.getMessage());
                }finally {
                    System.out.print("Press any key to continue!!");
                    myInp.nextLine();
                    MenuEmployeeManagement();
                }
            }
            case "12" -> System.out.println("Finish employee management");
            default -> {
                System.out.println("Invalid choice. Try Again!!");
                MenuEmployeeManagement();
            }
        }
    }

    public Office createOffice() {
        System.out.println("Enter Office name: ");
        Office office = new Office();
        office.updateInfor();
        return office;
    }

    public void MenuOfficeManagement() {
        System.out.println("\n*** OFFICE MANAGEMENT SYSTEM ***");
        System.out.println("1. Add office");
        System.out.println("2. Delete office");
        System.out.println("3. Add employee to office");
        System.out.println("4. Show list office");
        System.out.println("5. Show list office of employee");
        System.out.println("6. Set Manager to office");
        System.out.println("7. Show Manager information");
        System.out.println("8. Finish");
        System.out.print("- Choose: ");
        String choice = myInp.nextLine();
        switch (choice) {
            case "1" -> {
                Office office = createOffice();
                officeManagement.addOffice(office);
                System.out.println("Successfully create office!!");
                System.out.print("Press any key to continue!!");
                myInp.nextLine();
                MenuOfficeManagement();
            }
            case "2" -> {
                System.out.print("Enter office name: ");
                String name = myInp.nextLine();
                try {
                    Office office = officeManagement.searchOffice(name);
                    officeManagement.removeOffice(office);
                    officeManagement.removeAllOffice(office);
                    System.out.println("Successfully remove office!!");
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                    MenuOfficeManagement();
                }
            }
            case "3" -> {
                System.out.print("Enter office name: ");
                String name = myInp.nextLine();
                System.out.print("Enter employee id: ");
                String id = myInp.nextLine();
                try {
                    Office office = officeManagement.searchOffice(name);
                    Employee employee = employeeManagement.searchById(id);
                    if (employee instanceof Manager && office.isHasOffice()) {
                        System.err.println("This office had manager");
                    } else if (office.isInOffice(employee)) {
                        System.err.println("Employee already exist");
                    } else {
                        office.add(employee);
                        officeManagement.addParticipate(new ParticipateOffice(employee, office));
                        System.out.println("Successfully add employee");
                    }
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                    MenuOfficeManagement();
                }
            }
            case "4" -> {
                System.out.println("All Office");
                officeManagement.showInfor();
                System.out.print("Press any key to continue!!");
                myInp.nextLine();
                MenuOfficeManagement();
            }
            case "5" -> {
                System.out.print("Enter employee id: ");
                String id = myInp.nextLine();
                try {
                    Employee employee = employeeManagement.searchById(id);
                    System.out.printf("\n*** Office of employee %s ***\n", employee.getId());
                    officeManagement.searchParticipate(employee).forEach(office -> {
                        office.showInfor();
                    });
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                    MenuOfficeManagement();
                }
            }
            case "6" -> {
                try {
                    System.out.print("Enter employee id: ");
                    String id = myInp.nextLine();
                    Employee employee = employeeManagement.searchById(id);
                    System.out.print("Enter office name: ");
                    String oName = myInp.nextLine();
                    Office office = officeManagement.searchOffice(oName);
                    employee = employeeManagement.promote(employee);
                    if (!office.isInOffice(employee)) {
                        office.add(employee);
                    }
                    officeManagement.updatePromote(employee);
                    if (officeManagement.isManaged(office)) {
                        officeManagement.setManger((Manager) employee,office);
                    } else {
                        officeManagement.addManager(new ManageOffice(office,(Manager)employee));
                    }
                } catch (NullPointerException | ManageException e) {
                    System.err.println(e.getMessage());
                    MenuOfficeManagement();
                }
            }
            case "7" -> {
                try {
                    System.out.print("Enter manager id (M-): ");
                    Employee manager = employeeManagement.searchById(myInp.nextLine());
                    officeManagement.showInforManager((Manager)manager);
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                    MenuOfficeManagement();
                }
            }
            case "8" -> System.out.println("Finish Office Management");
            default -> {
                System.out.println("Invalid choice. Try Again!!");
                MenuOfficeManagement();
            }
        }
    }


    public Relative createRelative() throws ParseException, InvalidNameException, InvalidDateException, InvalidEmailException {
        Relative relative = new Relative();
        relative.updateInfor();
        validate(relative);
        return relative;
    }

    public void MenuRelationManagement() {
        System.out.println("\n*** RELATION MANAGEMENT SYSTEM ***");
        System.out.println("1. Add relation information of employee");
        System.out.println("2. Show list relation of employee");
        System.out.println("3. Finish");
        System.out.print("- Choose: ");
        String choice = myInp.nextLine();
        switch (choice) {
            case "1" -> {
                System.out.print("Enter employee id: ");
                String id = myInp.nextLine();
                try {
                    Employee employee = employeeManagement.searchById(id);
                    System.out.println(" Relative Information ");
                    Relative relative = createRelative();
                    relativeManagement.add(new InsurancePolicy(employee, relative));
                    System.out.println("Successfully add relative!!");
                } catch (NullPointerException | InvalidNameException | InvalidDateException | InvalidEmailException |
                         ParseException e) {
                    System.err.println(e.getMessage());
                    MenuRelationManagement();
                }
            }
            case "2" -> {
                System.out.print("Enter employee id: ");
                String id = myInp.nextLine();
                try {
                    Employee employee = employeeManagement.searchById(id);
                    System.out.printf("Employee's relative %s\n", employee.getId());
                    relativeManagement.search(employee).forEach(insurancePolicy -> {
                        insurancePolicy.showInfor();
                    });
                } catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                    MenuRelationManagement();
                }
            }
            case "3" -> System.out.println("Finish Relative Management");
            default -> {
                System.out.println("Invalid choice. Try Again!!");
                MenuRelationManagement();
            }
            }
        }
    }
