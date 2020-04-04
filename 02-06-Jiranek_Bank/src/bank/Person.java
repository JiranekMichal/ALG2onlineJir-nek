
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
        int length = name.length();
        if(name.charAt(length - 1) == 'a' && name.charAt(length - 2) == 'v' && name.charAt(length - 3) == 'o' ){
            return "pani " + name;
        }
        return "pan " + name;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + '}';
    }

    public static void main(String[] args) {
        Person pekar = new Person("Pekar");
        pekar.addAccount(2150, 200);
        pekar.addAccount(1258, 321);
        Person svecova = new Person("Svecova");
        svecova.addAccount(1263, 1800);
        System.out.println(pekar.getName());
        System.out.println(pekar.totalBalance());
        System.out.println(svecova.getName());
        System.out.println(svecova.totalBalance());
    }
    
   
}
