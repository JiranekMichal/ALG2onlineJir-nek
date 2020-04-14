
package pkg02.pkg04.shapes;


import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Michal Jiránek
 */
public class ShapesApp {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Shape> shapes = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choise;
        
        do{
           displayMenu();
           choise = readChoise();
           switch(choise){
               case 0:
                   break;
               case 1:
                   clearObjects();
                   break;
               case 2: 
                   addSquare();
                   break;
               case 3:
                   addRectangle();
                   break;
               case 4:
                   addCircle();
                   break;
               case 5:
                   printObjects();
                   break;
               case 6:
                   computeArea();
                   break;
               case 7:
                   findWithMaxArea();
                   break;
               case 8:
                   getObjectInfo();
                   break;
               case 9:
                   sortByArea();
                   break;
               default:
                   System.out.println("Neplatná volba.");
                 
                           
           }
        }while(choise != 0);
    }

    private static void displayMenu() {
        System.out.println("---------------------------------");
        System.out.println("1. Nová sada");
        System.out.println("2. Přidej čtverec");
        System.out.println("3. Přidej obdélník");
        System.out.println("4. Přidej kruh");
        System.out.println("5. Ukaž zadané objekty");
        System.out.println("6. Vypočti celkovou plochu");
        System.out.println("7. Ukaž objekt s největší plochou");
        System.out.println("8. Ukaž info o objektu");
        System.out.println("9. Setřiď objekty podle plochy");
        System.out.println("0. Konec programu");
        System.out.println("---------------------------------");
        
    }

    private static int readChoise() {
        return sc.nextInt();
    }

    private static void clearObjects() {
        shapes.clear();
    }

    private static void addSquare() {
        double a;
        do{
            System.out.println("Zadej délku strany.");
            a = sc.nextDouble();
            if (a <= 0){
                System.out.println("Velikost hrany musí být větší než nula.");
            }
        }while(a <= 0);
        
        Square s = new Square(a);
        shapes.add(s);
    }

    private static void addRectangle() {
        double a;
        double b;
        do{
           System.out.println("Zadej délky stran.");
           a = sc.nextDouble();
           b = sc.nextDouble(); 
           if(a <= 0 || b <= 0){
               System.out.println("Velikost hran musí být větší než nula.");
           }
        }while(a <= 0 || b <= 0);
        Rectangle r = new Rectangle(a,b);
        shapes.add(r);
    }

    private static void addCircle() {
        Circle c = null;
        int choise;
        do{
            System.out.println("---------------------------------");
            System.out.println("Zadej:");
            System.out.println("1. Poloměr");
            System.out.println("2. Průměr");
            System.out.println("---------------------------------");
            choise = sc.nextInt();
            switch (choise){
                case 1:
                    c = addCircleR();
                    break;
                case 2:
                    c = addCircleD();
                    break;
                default:
                    System.out.println("Neplatná volba.");
            }
        }while(choise != 1 && choise !=2);
        shapes.add(c);
    }

    private static Circle addCircleR() {
        double r;
        do{
            System.out.println("Zadej poloměr.");
            r = sc.nextDouble();
            if (r <= 0){
                System.out.println("Poloměr musí být větší než nula.");
            }
        }while(r <= 0);
        Circle c1 = Circle.getInstanceR(r);
        return c1;
    }

    private static Circle addCircleD() {
        double d;
        do{
            System.out.println("Zadej průměr.");
            d = sc.nextDouble();
            if (d <= 0){
                System.out.println("Průměr musí být větší než nula.");
            }
        }while(d <= 0);
        Circle c1 = Circle.getInstanceD(d);
        return c1;
    }

    private static void printObjects() {
        double area;
        for (int i = 0; i < shapes.size(); i++ ) {
            area = shapes.get(i).computeArea();
            System.out.print(shapes.get(i) + ", S = " + area);
            System.out.println("");
        }
    }

    private static void computeArea() {
        double area = 0;
        for (Shape shape : shapes){
            area += shape.computeArea();
        }
        System.out.println("Celkový obsah:");
        System.out.println("S = " + area);
    }

    private static void findWithMaxArea() {
        double area = 0;
        double maxArea = 0;
        int maxIndex = 0;
        for (int i = 0; i < shapes.size(); i++ ){
            area = shapes.get(i).computeArea();
            if(area > maxArea){
                maxArea = area;
                maxIndex = i;
            }
        }
        System.out.println(shapes.get(maxIndex) + ", S = " + maxArea );
        
    }

    private static void getObjectInfo() {
        int choise;
        do{
            System.out.println("---------------------------------");
            System.out.println("Vyber ze zadaných objektů:");
            for (int i = 0; i < shapes.size(); i++) {
                System.out.println((i+1) + ". " + shapes.get(i));
            }
            System.out.println("---------------------------------");
            choise = sc.nextInt();
            if (choise == 0){
                System.out.println("Neplatná volba.");
            }
        }while(choise == 0);
        System.out.println(shapes.get(choise - 1) + ", S = " + shapes.get(choise - 1).computeArea());
    }

    private static void sortByArea() {
        Shape helper;
        for(int i = 0; i < shapes.size(); i++){
            double min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < shapes.size() - i; j++) {
                if(min > shapes.get(j).computeArea()){
                    min = shapes.get(j).computeArea();
                    minIndex = j;
                }
            }
            helper = shapes.get(minIndex);
            shapes.remove(minIndex);
            shapes.add(helper);
        }
        printObjects();
    }
   
}
