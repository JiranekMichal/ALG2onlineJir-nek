
package pkg02.pkg03.polynoms;

/**
 * Knihvni trida
 * @author Michal Jiránek
 */
public class Polynoms {
    
    private Polynoms(){ //timto neexistuje defaultni prazdny konstruktor -> ted nelze z teto tridy vytvorit objekt
           
    }
    
    public static Polynom sum(Polynom a, Polynom b){
        boolean isABigger = a.getDegree() > b.getDegree();
        Polynom max = isABigger? a : b; //Math.max(a.getDegree(), b.getDegree())
        Polynom min = isABigger? b : a;
        
        double[]sumCoef = new double[max.getDegree() + 1];
        //6 0 3 5 
        //1 3 6
        //-------
        //7 3 9 5
        for (int i = 0; i < max.getDegree() + 1; i++) {
            sumCoef[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            sumCoef[i] = sumCoef[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sumCoef);
    }
    
    
    //DÚ - součin
    public static Polynom multiply(Polynom a , Polynom b){
        int degree = a.getDegree() + b.getDegree();
        double [] multCoef  = new double [degree + 1];
        for (int i = 0; i < a.getDegree() + 1; i++){
            for (int j = 0;j < b.getDegree() + 1; j++){
                multCoef[i+j] = multCoef[i+j] + a.getCoefAt(i)*b.getCoefAt(j);
            }
        }
        return Polynom.getInstanceReverted(multCoef);
    }
    

    public static void main(String[] args) {
        Polynom p1 = Polynom.getInstance(5, -3, 0, 6);
        Polynom p2 = Polynom.getInstance(6, 3, 1);
        System.out.println(Polynoms.sum(p1, p2));
        System.out.println(Polynoms.multiply(p1, p2));
        System.out.println(p1);
        System.out.println(p1.toString2());
        System.out.println(p1.integrate(1,2));
    }
    
}
