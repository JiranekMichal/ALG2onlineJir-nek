
package pkg02.pkg03.fractions;

import java.util.Scanner;

/**
 *
 * @author Michal Jiránek
 */
public class Fraction {
    //data
    private int citatel;
    private int jmenovatel;
    public static Scanner sc = new Scanner(System.in);

    public Fraction(int citatel, int jmenovatel) {
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
    }
    
    public static Fraction getInstanceNmb(){
        System.out.println("Zadej čitatel a jmenovatel jako 2 čísla.");
        int a = sc.nextInt();
        int b = sc.nextInt();
        return new Fraction(a,b);
    }
    
    public static Fraction getInstanceTxt(){
       System.out.println("Zadej zlomek ve formě čitatel/jmenovatel.");
       String zlomek = sc.next();
       String [] numbers = zlomek.split("/");
       int a = Integer.parseInt(numbers[0]);
       int b = Integer.parseInt(numbers[1]);
       return new Fraction(a,b);
    }

    public int getCitatel() {
        return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    @Override
    public String toString() {
        return citatel + "/" + jmenovatel;
    }
    
    public Fraction simplify(){
        int a;
        int b;
        int helper;
        int newCit;
        int newJme;
        
        if(this.citatel > this.jmenovatel){
            a = this.citatel;
            b = this.jmenovatel;
        }else{
            a = this.jmenovatel;
            b = this.citatel;
        }
        
        while(b != 0){
            helper = a;
            a = b;
            b = helper % b;
        }
        
        newCit = this.citatel / a;
        newJme = this.jmenovatel / a;
        
        return new Fraction(newCit, newJme);
    }
    
}
