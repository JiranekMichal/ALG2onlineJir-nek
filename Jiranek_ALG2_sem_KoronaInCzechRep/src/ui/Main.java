package ui;

import app.Republic;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import utils.IllegalFilenameException;

import utils.RepublicInterface;

/**
 * Trida main obsahujici rozhrani
 *
 * @author Michal Jiránek
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    /**
     * Trida Main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RepublicInterface r = new Republic();

        while (true) {
            try {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("Zadej nazvy vstupnich souboru (kraje,statistika,karantena v tomto poradi)");
                System.out.println("-------------------------------------------------------------------------");
                String krajeFile = sc.next();
                String statistikaFile = sc.next();
                String karantenaFile = sc.next();
                try {
                    r.load(krajeFile, statistikaFile, karantenaFile);
                    break;

                } catch (IllegalFilenameException ei) {
                    System.err.println(ei.getMessage());
                } catch (IllegalArgumentException ea) {
                    System.err.println(ea.getMessage());
                }
            } catch (FileNotFoundException e) {
                System.err.println("Spatny zadany soubor. Zadej znovu.");
            } catch (IOException ex) {
                System.err.println("Chyba pri cteni.");
            }
        }
        try {
            Thread.sleep(300); //spozdeni, aby ve vypisu nevyskakovali System.err.printl doprostred vypisu moznosti menu.
        } catch (InterruptedException ex) {
            System.err.println("Preruseni.");
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Vyber moznost:");
        System.out.println("1.  Vypsat info o krajich");
        System.out.println("2.  Ulozit info o krajich");
        System.out.println("3.  Setridit podle poctu obyvatel a vypsat");
        System.out.println("4.  Setridit podle mnozstvi nakazenych a vypsat");
        System.out.println("5.  Setridit podle pomeru nakazenych a vypsat");
        System.out.println("6.  Setridit podle poctu hospitalizovanych a vypsat");
        System.out.println("7.  Setridit podle poctu vylecenych a vypsat");
        System.out.println("8.  Setridit podle koeficientu nadeje a vypsat");
        System.out.println("9.  Setridit podle poctu dnu v karantene a vypsat");
        System.out.println("10. Vypsat info o kraji podle zadaneho nazvu");
        System.out.println("0.  Konec programu");
        System.out.println("---------------------------------------------------");
        int choise = 1;
        while (choise != 0) {
            String choiseLoad = sc.next();
            try {
                choise = Integer.parseInt(choiseLoad);
            } catch (NumberFormatException e) {
                choise = Integer.MAX_VALUE;
            }
            switch (choise) {
                case 1:
                    System.out.println(r.getKrajeInfo());
                    break;
                case 2:
                    System.out.println("Zadej jméno souboru:");
                    String filename = sc.next();
                     {
                        try {
                            r.save(filename);
                        } catch (IOException ex) {
                            System.err.println("Chyba pri zapisu.");
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.println(r.sortByObyvatel());
                    break;
                case 4:
                    System.out.println(r.sortByNakazenych());
                    break;
                case 5:
                    System.out.println(r.sortByNakazPomer());
                    break;
                case 6:
                    System.out.println(r.sortByHosp());
                    break;
                case 7:
                    System.out.println(r.sortByVylec());
                    break;
                case 8:
                    System.out.println(r.sortByKoef());
                    break;
                case 9:
                    System.out.println(r.sortByDnyKaran());
                    break;
                case 10:
                    System.out.println("Zadejte nazev kraje:");
                    String nazev = sc.next();
                    try {
                        System.out.println(r.getKrajInfo(nazev));
                    } catch (NoSuchElementException e) {
                        System.err.println(e.getMessage());
                    }

                case 0:
                    break;
                default:
                    System.err.println("Neplatná volba.");
                    break;
            }
            try {
                Thread.sleep(50); //spozdeni, aby ve vypisu nevyskakovali System.err.printl doprostred vypisu moznosti menu.
            } catch (InterruptedException ex) {
                System.err.println("Preruseni.");
            }
            System.out.println("---------------------------------------------------");
            System.out.println("Vyber moznost:");
            System.out.println("1.  Vypsat info o krajich");
            System.out.println("2.  Ulozit info o krajich");
            System.out.println("3.  Setridit podle poctu obyvatel a vypsat");
            System.out.println("4.  Setridit podle mnozstvi nakazenych a vypsat");
            System.out.println("5.  Setridit podle pomeru nakazenych a vypsat");
            System.out.println("6.  Setridit podle poctu hospitalizovanych a vypsat");
            System.out.println("7.  Setridit podle poctu vylecenych a vypsat");
            System.out.println("8.  Setridit podle koeficientu nadeje a vypsat");
            System.out.println("9.  Setridit podle poctu dnu v karantene a vypsat");
            System.out.println("10. Vypsat info o kraji podle zadaneho nazvu");
            System.out.println("0.  Konec programu");
            System.out.println("---------------------------------------------------");
        }
    }

}
