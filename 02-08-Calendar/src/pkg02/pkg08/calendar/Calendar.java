
package pkg02.pkg08.calendar;

import java.util.Scanner;

/**
 *
 * @author Michal Jiránek
 */
public class Calendar {

    public static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    
    
    //data
    private static int day;
    private static int month;
    private static int year;
    private static final int[] DAYSINMONTH = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static int dayInWeek = dayInWeek();
    
    //konstructor
    private Calendar(int day, int month, int year) {
        this.day = 1;
        this.month = month;
        this.year = year;
    }
    
    //továrni metoda
    public static Calendar load() {
        System.out.println("Zadej den ve formátu dd/mm/yyyy");
        String dayLoad = sc.next();
        String [] dayString = dayLoad.split("/");
        int [] day = new int [dayString.length];
        for (int i = 0; i < day.length; i++) {
            day[i] = Integer.parseInt(dayString[i]);
        }
        return new Calendar(day[0],day[1],day[2]);
    }
    
    //Zelleruv algoritmus
    private static int dayInWeek(){
        int dayZ = day;
        int monthZ = month;
        int yearZ = year;
        
        if(monthZ == 1){
            monthZ = 13;
            yearZ--;
        }
        if(monthZ == 2){
            monthZ = 14;
            yearZ--;
        }
        
        int q = dayZ;
        int m = monthZ;
        int j = yearZ / 100;
        int k = yearZ % 100;
        
        int h = q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;
        int d = ((h + 5) % 7) + 1;
        return d;
    }
    
    //je přestupny rok?
    private static boolean isLeapYear(){
        int zbytek4 = year % 4;
        int zbytek100 = year % 100;
        int zbytek400 = year % 400;
        if(zbytek4 == 0){
            if(zbytek100 == 0){
                return zbytek400 == 0;
            }
            return true;
        }
        return false;
    }
    
    //pocet dni v roce
    public static int daysInYear(){
        if(isLeapYear()){
            return 366;
        }
        return 365;
    }
    
    //retezec - kalendar 
    public static String calendar(){
        /*StringBuilder calendar = new StringBuilder();
        calendar.append("| Po | Ut | St | Ct | Pa | So | Ne |");
        calendar.append("\n");
        calendar.append("  --   --   --   --   --   --   --  ");
        calendar.append("\n");
        calendar.append("|  1 |  2 |  3 |  4 |  5 |  6 |  7 |");
        calendar.append("\n");
        calendar.append("|  8 |  9 | 10 | 11 | 12 | 13 | 14 |");
        return calendar.toString();*/
        
        day = 1;
        int start = dayInWeek();
        int daysInMonth;
        
        if(isLeapYear() && month == 2){
            daysInMonth = 29;
        }else{
            daysInMonth = DAYSINMONTH[month - 1];
        }
        
        int zbytek = 0;
        int lastWeek = (start - 1 + daysInMonth) % 7;
        if(lastWeek != 0){
           zbytek = 7 - lastWeek; 
        }
        
        String nadpis = "";
        switch (month){
            case 1: nadpis = "Leden";
            break;
            case 2: nadpis = "Únor";
            break;
            case 3: nadpis = "Březen";
            break;
            case 4: nadpis = "Duben";
            break;
            case 5: nadpis = "Květen";
            break;
            case 6: nadpis = "Červen";
            break;
            case 7: nadpis = "Červenec";
            break;
            case 8: nadpis = "Srpen";
            break;
            case 9: nadpis = "Září";
            break;
            case 10: nadpis = "Říjen";
            break;
            case 11: nadpis = "Listopad";
            break;
            case 12: nadpis = "Prosinec";
            break;
            
        }
        
        StringBuilder calendar = new StringBuilder();
        calendar.append("||| ");
        calendar.append(nadpis);
        calendar.append(" ");
        calendar.append(year);
        calendar.append(" |||");
        calendar.append("\n");
        calendar.append("  --   --   --   --   --   --   --  ");
        calendar.append("\n");
        calendar.append("| Po | Ut | St | Ct | Pa | So | Ne |");
        calendar.append("\n");
        calendar.append("  --   --   --   --   --   --   --  ");
        calendar.append("\n");
        calendar.append("|");
        for (int i = 1; i < start; i++) {
            calendar.append("    |");
        }
        
        for (int j = 1; j <= daysInMonth; j++) {
            if(j < 10){
                calendar.append("  " + j + " |");
            }else{
                calendar.append(" " + j + " |");
            }
            
            if((j + start - 1)%7 == 0 && j != daysInMonth){
                calendar.append("\n");
                calendar.append("|");
            }
        }
        
        for (int k = 0; k < zbytek; k++) {
            calendar.append("    |");
        }
                
        calendar.append("\n");
        calendar.append("  --   --   --   --   --   --   --  ");
        return calendar.toString();
    }
    
    
    public static void main(String[] args) {
        load();
        //System.out.println(isLeapYear());
        System.out.println(calendar());
    }
    
}
