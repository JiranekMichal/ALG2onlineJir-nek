/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author Michal Jiránek
 */
public abstract class Client {
    //data
    protected String name = "Client";
    protected ArrayList<Account> accounts = new ArrayList<>();
    
    

    public void addAccount(int accNumber, double balance){
        Account a = Account.createWith(accNumber, balance);
        accounts.add(a);
    }
    
    public double totalBalance(){
        double totalBalance = 0;
        for(int i = 0; i < accounts.size(); i++){
            totalBalance += accounts.get(i).getBalance();
        }
        return totalBalance;
    }
    
    public abstract String getName();
    
}
