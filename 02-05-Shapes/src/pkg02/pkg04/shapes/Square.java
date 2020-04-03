/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02.pkg04.shapes;

/**
 *
 * @author Misha
 */
public class Square extends Rectangle{
    //data
    private double a;

    public Square(double a) {
        super(a, a);
        this.a = a;
    }

    @Override
    public double getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Square: " + "a = " + a;
    }
    
    
    
    
}
