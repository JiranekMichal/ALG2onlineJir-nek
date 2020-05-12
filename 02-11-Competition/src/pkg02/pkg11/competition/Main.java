
package pkg02.pkg11.competition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Michal Jiránek
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Competition c = new Competition();
        try{
            while(true){
                try{
                    System.out.println("Zadej nezvy vstupnich souboru");
                    String startFile = sc.next();
                    String finishFile = sc.next();
                    c.load(startFile, finishFile);
                    break;
                }catch(FileNotFoundException e){
                    System.out.println("Spatny zadany soubor. Zadej znovu.");
                }
            }
            System.out.println(c.getResults());
            //System.out.println("Zadej nazev vystupniho souboru");
            //String resultFile = sc.next();
            //c.saveResults(resultFile);
        }catch(IOException e){
            System.out.println("Chyba pri cteni a zapisu.");
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
    
}
