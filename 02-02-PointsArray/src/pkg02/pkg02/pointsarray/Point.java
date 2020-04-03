/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02.pkg02.pointsarray;

/**
 *
 * @author Misha
 */
public class Point {
    //data
    private double x;
    private double y;
    
    //konstruktory
    public Point (double x, double y){
        this.x = x;
        this.y = y;
    }

    
    //metody

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double distFromZero(){
        return (Math.sqrt((Math.pow(this.x, 2))+(Math.pow(this.y, 2))));
    }
    
    public double distFrom(Point other){
        return (Math.sqrt((Math.pow(this.x-other.x, 2))+(Math.pow(this.y-other.y, 2))));
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
