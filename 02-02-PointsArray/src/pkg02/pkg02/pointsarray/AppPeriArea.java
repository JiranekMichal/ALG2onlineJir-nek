/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02.pkg02.pointsarray;

import java.util.Scanner;

/**
 *
 * @author Misha
 */
public class AppPeriArea {
    static Point [] array;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x;
        double y;
        System.out.println("Zadej počet bodů.");
        int pocetBodu = sc.nextInt();
        Point [] array = new Point [pocetBodu];
        for(int i = 0; i < pocetBodu; i++){
            System.out.println("Zadej souřadnice " + (i+1) + ". bodu.");
            x = sc.nextDouble();
            y = sc.nextDouble();
            array[i] = new Point(x,y);
        }
        
        for (Point array1 : array) {
            System.out.println(array1);
        }
        
        System.out.println("Obvod je " + perimetr());
        System.out.println("Obsah je " + area());
    }
    
    
    
    private static double perimetr(){
        double perimetr = 0;
        for(int i = 0; i < array.length - 1; i++){
            perimetr = perimetr + array[i].distFrom(array[i+1]);
        }    
        perimetr = perimetr + array[array.length - 1].distFrom(array[0]);
        return perimetr;
    }
    
    private static double area(){
        double area = 0;
        for(int i = 0; i < array.length - 1; i++){
            area = area + (array[i].getX()*array[i+1].getY() - array[i+1].getX()*array[i].getY());
        }
        area = area + (array[array.length - 1].getX()*array[0].getY() - array[0].getX()*array[array.length - 1].getY());
        area = (Math.abs(area))/2;
        return area;
    }
    
}
