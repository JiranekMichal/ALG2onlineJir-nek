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

    public abstract void addAccount(int accNumber, double balance);
    
    public abstract double totalBalance();
    
    public abstract String getName();
    
}
