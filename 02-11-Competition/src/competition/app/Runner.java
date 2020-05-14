
package competition.app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Michal Jiránek
 */
public class Runner implements Comparable<Runner>{
    //data
    private int number;
    private String firstname;
    private String lastname;
    private LocalTime startTime;
    private LocalTime finishTime;
    public static DateTimeFormatter dtfstart = DateTimeFormatter.ofPattern("HH:mm:ss");   //pro vsechny bezce stejne - proto muze byt static 
    public static DateTimeFormatter dtffinish = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    public Runner(int number, String firstname, String lastname) {
        this.number = number;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime, dtfstart);
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime, dtffinish);
    }
    
    public String getStartTimeString(){
        return startTime.format(dtfstart);
    }
    
    public String getFinishTimeString(){
        return finishTime.format(dtffinish);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Runner o) {
        return this.runningTime().compareTo(o.runningTime());
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    
    public LocalTime runningTime(){
        return LocalTime.ofNanoOfDay(finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    
    @Override
    public String toString() {
        return String.format("%-4d%-10s%-10s%-15s%-15s%-15s", number, firstname, lastname, getStartTimeString(),
                getFinishTimeString(), runningTime().format(dtffinish));
    }
    
    

    public LocalTime getFinishTime() {
        return finishTime;
    }
    
    public static void main(String[] args) {
        Runner r = new Runner(18,"Michal","Jiranek");
        r.setStartTime("09:00:00");
        r.setFinishTime("09:19:03:000");
        System.out.println(r);
    }
}
