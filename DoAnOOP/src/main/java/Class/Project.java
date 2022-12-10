package Class;

import java.text.ParseException;
import java.util.Date;

public class Project implements IConfig, Comparable<Project>{
    private static int NUM_PROJECT = 0;
    private String id;
    {
        id = String.format("P%010d", ++NUM_PROJECT);
    }
    private String name;
    private Date startDay;
    private Date endDay;
    private double totalCost;
    private Employee leader;

    public Project(String name, String startDay, String endDay, double totalCost, Employee leader) throws ParseException {
        this.name = name;
        this.startDay = f.parse(startDay);
        this.endDay = f.parse(endDay);
        this.totalCost = totalCost;
        this.leader = leader;
    }

    public Project() {
    }

    public static int getNumProject() {
        return NUM_PROJECT;
    }

    public static void setNumProject(int numProject) {
        NUM_PROJECT = numProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) throws ParseException {
        this.startDay = f.parse(startDay);
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) throws ParseException {
        this.endDay = f.parse(endDay);
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
        System.out.print("Name: ");
        this.name = myInp.nextLine();
        System.out.print("Start date (dd/MM/yyyy): ");
        this.startDay = f.parse(myInp.nextLine());
        System.out.print("End date (dd/MM/yyyy): ");
        this.endDay = f.parse(myInp.nextLine());
        System.out.print("Total cost: ");
        this.totalCost = myInp.nextDouble();
    }

    public void showInfor() {
        System.out.printf("Id: %s\nName: %s\nStart Date: %s\nEnd Date: %s\nTotal cost: %,.2f\n",this.id,this.name,f.format(this.startDay),f.format(this.endDay),this.totalCost);
        System.out.println("Leader");
        leader.showInfo();
    }

    @Override
    public int compareTo(Project p) {
        return (int) (this.totalCost - p.getTotalCost());
    }
}
