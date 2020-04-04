
package bank;

/**
 *
 * @author Michal Jiránek
 */
public class Account {
    //data
    private int accountNumber;;
    private double balance;

    private Account(int accountNumber, double zustatek) {
        this.accountNumber = accountNumber;
        this.balance = zustatek;
    }
    
    public static Account createEmpty(int accountNumber){
        return new Account(accountNumber, 0);
    }
    
    public static Account createWith(int cisloUctu, double zustatek){
        return new Account(cisloUctu, zustatek);
    }
    
    public void insert(double insert){
        this.balance += insert;
    }
    
    public void withdraw(double withdraw){
        this.balance -= withdraw;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "; Balance: " + balance;
    }
    
}
