
package pkg02.pkg04.shapes;

/**
 *
 * @author Michal Jiránek
 */
public class Circle extends Shape{ // Circle je typove kompatibilni s Shape, Circle IS A Shape
    //data
    private double r;
    private double area;
    
    //pristup pouze pres konstruktory - private
    private Circle(double r) {
        this.r = r;
        this.area = computeArea();
    }
    
    // tovarni metoda - namisto druheho konstruktoru s d
    public static Circle getInstanceD(double d){
        return new Circle(d/2);
    }
    
    public static Circle getInstanceR(double r){
        return new Circle(r);
    }
    

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle: " + "r = " + r;
        //return super.toString() + String.format(" r = %.2f", r);
    }
    
    @Override
    public double computeArea(){
        return Math.PI*r*r;
    }
    
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceR(4);
        System.out.println(c1);
        System.out.println(c1.computeArea());
        System.out.println(c1.name);
        System.out.println(c1.getShapeName());
        
    }
    
    
}
