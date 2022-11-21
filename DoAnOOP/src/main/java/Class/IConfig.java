package Class;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public interface IConfig {
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    Scanner  myInp = new Scanner(System.in);
    GregorianCalendar GreCalandar = new GregorianCalendar();

    int MAX_OFFICE = 2;

    int BASIC_SALARY = 1000000;
}