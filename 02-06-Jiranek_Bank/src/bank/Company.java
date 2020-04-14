
package bank;

import java.util.ArrayList;

/**
 *
 * @author Michal Jiránek
 */
public class Company extends Client{
    //data
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();

    public Company(String name) {
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
        return "firma " + name;
    }

    
    
}
