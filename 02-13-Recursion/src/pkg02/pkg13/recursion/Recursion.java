
package pkg02.pkg13.recursion;

/**
 *
 * @author Michal Jiránek
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(fac(4));
        System.out.println(facR(4));
        int [] a = {23, 45, 21, 46};
        System.out.println(fm(a,a.length));
        System.out.println(fmb(a,0,3));
    }
    
    //factorial - iterativne 4! = 1*2*3*4
    public static int fac(int n){
        int fac = 1;
        for (int i = 2; i <= n; i++) {
            fac = fac*i;
        }
        return fac;
    }
    
    //factorial - recursion
    public static int facR(int n){
        if(n <= 1){
            return 1;
        }else{
            return n*facR(n-1);
        }
    }
    //find max
    public static int fm(int[]a, int n){
        if(n == 1){
            return a[0];
        }
        return Math.max(a[n-1], fm(a,n-1));
    }
    //find max binary
    public static int fmb(int [] a, int from, int to){
        if(from >= to){
            return a[from];
        }
        int half = (from + to)/2;
        int left = fmb(a,from,half);
        int right = fmb(a,half+1,to);
        if (left>=right){
            return left;
        }else{
            return right;
        }
    }
}

