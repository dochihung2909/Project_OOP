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
            System.out.println("\n*** H&H COMPANY ***");
            System.out.printf("\t\tSố lượng dự án hiện có: %d\n", Project.getNumProject());
            System.out.printf("\t\tSố lượng nhân viên hiện có: %d\n", Employee.getNumEmployee());
            System.out.printf("\t\tSố lượng phòng ban hiện có: %d\n", Office.getNumOffice());
            System.out.println("\n1- Quản lý dự án");
            System.out.println("2- Quản lý nhân viên");
            System.out.println("3- Quản lý phòng ban");
            System.out.println("4- Quản lý nhân thân của nhân viên");
            System.out.println("5- Lưu thông tin và kết thúc chương trình");
            System.out.print("- Chọn chức năng: ");
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
                default -> System.err.println("Invalid choice");
            }
            System.out.printf("Press any key to continue!");
            myInp.nextLine();
        }
    }
}
