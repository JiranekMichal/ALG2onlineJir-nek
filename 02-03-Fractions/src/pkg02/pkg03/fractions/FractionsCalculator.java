
package pkg02.pkg03.fractions;

/**
 *
 * @author Misha
 */
public class FractionsCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraction f1 = Fraction.getInstanceNmb();
        Fraction f2 = Fraction.getInstanceTxt();
        Fraction f3 = plus(f1,f2);
        System.out.println(f3);
        Fraction f4 = minus(f1,f2);
        System.out.println(f4);
        Fraction f5 = times(f1,f2);
        System.out.println(f5);
        Fraction f6 = divide(f1,f2);
        System.out.println(f6);
    }

    private static Fraction plus(Fraction f1, Fraction f2) {
        int c1, c2, j1, j2, c, j;
        c1 = f1.getCitatel();
        j1 = f1.getJmenovatel();
        c2 = f2.getCitatel();
        j2 = f2.getJmenovatel();
        j = spolNasobek(j1, j2);
        c = c1 * (j/j1) + c2 * (j/j2);
        Fraction f =  new Fraction(c,j);
        f = f.simplify();
        return f;
    }

    private static Fraction minus(Fraction f1, Fraction f2) {
        int c1, c2, j1, j2, c, j;
        c1 = f1.getCitatel();
        j1 = f1.getJmenovatel();
        c2 = f2.getCitatel();
        j2 = f2.getJmenovatel();
        j = spolNasobek(j1, j2);
        c = c1 * (j/j1) - c2 * (j/j2);
        Fraction f =  new Fraction(c,j);
        f = f.simplify();
        return f;
    }
    
    private static Fraction times(Fraction f1, Fraction f2) {
        int c1, c2, j1, j2, c, j;
        c1 = f1.getCitatel();
        j1 = f1.getJmenovatel();
        c2 = f2.getCitatel();
        j2 = f2.getJmenovatel();
        c = c1 * c2;
        j = j1 * j2;
        Fraction f =  new Fraction(c,j);
        f = f.simplify();
        return f;
    }

    private static Fraction divide(Fraction f1, Fraction f2) {
        int c1, c2, j1, j2, c, j;
        c1 = f1.getCitatel();
        j1 = f1.getJmenovatel();
        c2 = f2.getCitatel();
        j2 = f2.getJmenovatel();
        c = c1 * j2;
        j = j1 * c2;
        Fraction f =  new Fraction(c,j);
        f = f.simplify();
        return f;
    }

    private static int spolNasobek(int j1, int j2) {
        int vetsi, mensi;
        int zbytek = 1;
        int nasobek = 0;
        if(j1>j2){
            vetsi = j1;
            mensi = j2;
        }else{
            vetsi = j2;
            mensi = j1;
        }
        for(int i = 1; zbytek != 0; i++){
            zbytek = (vetsi * i) % mensi;
            if(zbytek == 0){
                nasobek = (vetsi * i);
            }
        }
        return nasobek;
    }
    
    
    
}
