
package pkg02.pkg04.shapes;

/**
 *
 * @author Michal Jiránek
 */
public abstract class Shape {
    //data
    protected String name = "Geometric object"; //viditelné v potomcích
    protected double area = computeArea();
    
    //metody
    public abstract double computeArea(); //vsichni potomci musi mit tuto metodu
    
    
    public String getShapeName(){ //jen prepouzite v potomcich
        return this.getClass().getSimpleName();
    }
    
    
    @Override
    public String toString(){//prekryva toString objectu, defaulne nad potomky - muze se prekryt
        return name + ": " + getShapeName();
    }
}
