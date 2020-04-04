
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
    public void addAccount(int accNumber, double balance){
        Account a = Account.createWith(accNumber, balance);
        accounts.add(a);
    }
    
    @Override
    public double totalBalance(){
        double totalBalance = 0;
        for(int i = 0; i < accounts.size(); i++){
            totalBalance += accounts.get(i).getBalance();
        }
        return totalBalance;
    }
    
    @Override
    public String getName() {
        return "firma " + name;
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + '}';
    }

    
    
}
