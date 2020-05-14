
package pkg02.pkg12.hurricanes;

import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 *
 * @author Michal Jiránek
 */
public class Main {
    
    public static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HurricanesEditor hrc = new HurricanesEditor();
        try{
            hrc.load();
        }catch(FileNotFoundException e){
            System.out.println("Chyba pri nacitani souboru");
        }
        System.out.println("Zadej obdobi (rok rok):");
        int yearFrom = sc.nextInt();
        int yearTo = sc.nextInt();
        System.out.println(hrc.getInfoFromTo(yearFrom,yearTo));
        System.out.println("Zadej jmeno huricanu:");
        String name = sc.next();
        System.out.println(hrc.getCategoryAndSpeed(name));
        System.out.println("Setridene huricany dle rychosti:");
        System.out.println(hrc.getSortedBySpeed());
        
    }
    
}
