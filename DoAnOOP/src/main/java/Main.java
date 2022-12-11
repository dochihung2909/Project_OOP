import Class.*;
import Management.*;
import Menu.MenuManagement;
import extension.ReadFile;

import javax.naming.InvalidNameException;
import javax.swing.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;

public class Main implements IConfig {
    public static void main(String[] args) throws ParseException, InvalidNameException {
        MenuManagement menuManagement = MenuManagement.getInstance();
        while (true) {
            System.out.println("\n*** SYSTEM ***");
            System.out.printf("\t\tNumber Project now: %d\n", Project.getNumProject());
            System.out.printf("\t\tNumber Employee now: %d\n", Employee.getNumEmployee());
            System.out.printf("\t\tNumber Office now: %d\n", Office.getNumOffice());
            System.out.println("\n1- Project management");
            System.out.println("2- Employee management");
            System.out.println("3- Office management");
            System.out.println("4- Relative management");
            System.out.println("5- Save information and finish section");
            System.out.print("- Choose: ");
            String choice = myInp.nextLine();
            switch (choice) {
                case "1" -> {
                    menuManagement.MenuProjectManagement();
                }
                case "2" -> {
                    menuManagement.MenuEmployeeManagement();
                }
                case "3" -> {
                    menuManagement.MenuOfficeManagement();
                }
                case "4" -> {
                    menuManagement.MenuRelationManagement();
                }
                case "5" -> {
                    ReadFile.writeFile();
                    return;
                }
                default -> System.err.println("Invalid choice");
            }
            System.out.println("Press any key to continue!");
            myInp.nextLine();
        }
    }
}
