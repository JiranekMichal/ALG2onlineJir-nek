
package pkg02.pkg08.calendar;

import java.util.Scanner;


/**
 *
 * @author Misha
 */
public class App {
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choise;
        Calendar.load();
        do{
            System.out.println(Calendar.calendar());
            choise = sc.nextInt();
            switch(choise){
                case 4: Calendar.previousMonth();
                break;
                case 6: Calendar.nextMonth();
                break;
                case 7: Calendar.previousYear();
                break;
                case 9: Calendar.nextYear();
                break;
                case 0: 
                break;
                default:
                    System.out.println("Neplatná volba.");
            }
        }while(choise != 0);
    }
    
}
