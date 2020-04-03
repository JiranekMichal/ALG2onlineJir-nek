
package pkg02.pkg03.polynoms;

import java.util.Arrays;

/**
 *
 * @author Michal Jiránek
 */
public class Polynom {
    //data
    //5x3 + 3x2 + 6  6 0 3 5
    private double [] coef;
    
    //constructors
    //[6 0 3 5]
    //[5 3 0 6]
    //6, 0, 3, 5
    //5, 3, 0, 6
    private Polynom(double[]coef){                             //konstruktor - nelze přetížit --> tovarni metoda ho obalí
        double[]coefTemp = new double[coef.length];            //defenzivni kopie - privatetni i hodnoty pole
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);   //zkopirovani pole
        this.coef = coefTemp;
    }
    
    // tovarni (factory) metody
    public static Polynom getInstanceReverted(double...coef){  //[6 0 3 5]
        return new Polynom(coef);
    }
    
    public static Polynom getInstance(double...coef){  //5, 3, 0, 6, reaguje na jakykoliv pocet doublu, pracuje jako s polem
        double [] coefTemp = new double[coef.length];
        for(int i = 0; i < coef.length; i++){
            coefTemp[coefTemp.length - 1 - i] = coef[i];
        }
        return new Polynom(coefTemp);
    }
    
    
    //metody
    
    //DÚ - vytvorit metodu - hornerovo schema - viz zadani
    //5x3 + 3x2 + 6; pro x=1; y = 5 + 3 + 6 = 14
    public double computeValue(double x){
        double value = 0;
        for (int i = coef.length - 1; i > 0; i--) {
            value = (value + coef[i]) * x ;
        }
        value = value + coef[0];
        return value;
    }
    
    //getter
    public double getCoefAt(int exponent){
        return coef[exponent];
    }
    
    public double [] getAllCoef(){
        return Arrays.copyOf(coef, coef.length);
    }
    
    public int getDegree(){
        return coef.length - 1;
    }
    
    //toString
    @Override
    public String toString() {
        return "Polynom{coef = " + Arrays.toString(coef) + '}';
    }
    //DÚ - metematicky správně vypsalo - nějak takhke 5x^3 + ... (když tam bude nula tak nevypsat atd...)
    public String toString2(){
        String polynome = "";
        if(coef[coef.length - 1] < 0){
            polynome = " - ";
        }
        for (int i = coef.length - 1; i > 0; i--){
            if(coef[i] != 0){
                polynome = polynome + Math.abs(coef[i]) + "x^" + i;
                if(coef[i - 1] >= 0){
                    polynome = polynome + " + ";
                }else{
                    polynome = polynome + " - ";
                }
            }
        }
        polynome = polynome + coef[0];
        return polynome;
    }
    
    
    
    public Polynom derivate(){
        double[] coefDer = new double [this.coef.length - 1];
        for(int i = 0; i < coefDer.length; i++){
            coefDer[i] = coef[i + 1] * (i + 1);
        }
        return new Polynom(coefDer);
    }
    
    //Bonus - integrál na zadané rozsahu
    public double integrate(double a, double b){
        double[] coefInt = new double [this.coef.length + 1];
        for(int i = 0; i < this.coef.length; i++){
            coefInt[i+1] = this.coef[i] / (i + 1);
        }
        Polynom p = new Polynom(coefInt);
        double integral = p.computeValue(b) - p.computeValue(a);
        return integral;
    }
    
    public static void main(String[] args) {
        double[] a = {6, 0, -3, 5};
        Polynom p1 = Polynom.getInstanceReverted(a);
        System.out.println(p1);//toString metoda
        System.out.println(p1.getCoefAt(3));
        System.out.println(p1.derivate());
        System.out.println(p1.computeValue(2));
        System.out.println(p1.integrate(1,2));
        
    }
    
}
