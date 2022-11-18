package Class;

import java.text.ParseException;
import java.util.Date;

public class Project implements IConfig {
    private static int countId = 0;
    private String id;
    {
        countId++;
        id = String.format("P%010d", countId);
    }
    private String name;
    private Date start;
    private Date end;
    private double totalCost;
    private Employee leader;

    public Project(String id, String name, String start, String end, double totalCost, Employee leader) throws ParseException {
        this.id = id;
        this.name = name;
        this.start = f.parse(start);
        this.end = f.parse(end);
        this.totalCost = totalCost;
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(String start) throws ParseException {
        this.start = f.parse(start);
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(String end) throws ParseException {
        this.end = f.parse(end);
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public String getId() {
        return id;
    }

    public void updateInfor() throws ParseException {
        System.out.println("Update Infor");
        System.out.print("Name: ");
        this.name = myInp.nextLine();
        System.out.print("Start date (dd/MM/yyyy): ");
        this.start = f.parse(myInp.nextLine());
        System.out.print("End date (dd/MM/yyyy): ");
        this.end = f.parse(myInp.nextLine());
        System.out.print("Total cost: ");
        this.totalCost = myInp.nextDouble();
    }

    public void showInfor() {
        System.out.printf("Id: %s\nName: %s\nStart Date: %s\nEnd Date: %s\nTotal cost: %f\n",this.id,this.name,f.format(this.start),f.format(this.end),this.totalCost);
        System.out.println("Leader");
        leader.showInfo();
    }
}
