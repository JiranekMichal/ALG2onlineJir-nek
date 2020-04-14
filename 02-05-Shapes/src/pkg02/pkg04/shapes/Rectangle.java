
package pkg02.pkg04.shapes;

/**
 * Nemenny objekt
 * @author Michal Jiránek
 */
public class Rectangle extends Shape {
    //data
    private double a;
    private double b;
    private double area; //vypocitana promenna

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = area();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
    
    private double area(){
        return a*b;
    }

    //neni potreba
    public double getArea() {
        return area;
    }
    
    @Override
    public double computeArea(){
        return area;
    }

    @Override
    public String toString() {
        return "Rectangle: " + "a = " + a + ", b = " + b;
        //return super.toString() + String.format(" a = %.2f, b = %.2f", a, b);
    }
    
}
