/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02.pkg04.shapes;

/**
 *
 * @author Michal Jiránek
 */
public class Square extends Rectangle{
    //data
    private double a;
    private double area;

    public Square(double a) {
        super(a, a);
        this.a = a;
        this.area = super.computeArea();
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
