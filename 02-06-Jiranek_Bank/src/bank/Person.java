
package bank;

import java.util.ArrayList;

/**
 *
 * @author Michal Jiránek
 */
public class Person extends Client{
    //data
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }
   
    @Override
    public void addAccount(int accNumber, double balance) {
        super.addAccount(accNumber, balance);
    }
    
   
    @Override
    public double totalBalance() {
        return super.totalBalance();
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        int length = name.length();
        if(name.charAt(length - 1) == 'a' && name.charAt(length - 2) == 'v' && name.charAt(length - 3) == 'o' ){
            return "pani " + name;
        }
        return "pan " + name;
    }
   
}
