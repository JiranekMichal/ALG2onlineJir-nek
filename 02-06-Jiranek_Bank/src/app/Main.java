
package app;

import bank.Client;
import bank.Company;
import bank.Person;
import java.util.ArrayList;

/**
 *
 * @author Michal Jiránek
 */
public class Main {

    private static ArrayList<Client> clients = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clients.add(new Person("Pekar"));
        clients.add(new Person("Svecova"));
        clients.add(new Company("Skoda"));
        clients.get(0).addAccount(0001, 1000);
        clients.get(0).addAccount(0002, 500);
        clients.get(1).addAccount(0003, 1200);
        clients.get(2).addAccount(0004, 120);
        clientAccounts("Skoda");
        clientAccounts("Svecova");
        clientAccounts("Novak");
        clientAccounts("Pekar");
    }
    
    public static void clientAccounts(String name){
        boolean goOn = true;
        for (int i = 0; i < clients.size() && goOn; i++){
            if(name == clients.get(i).getName()){
                System.out.println(clients.get(i) + " - zůstatek: " + clients.get(i).totalBalance());
                goOn = false;
            }
        }
        if(goOn == true){
            System.out.println("Tento klient neexistuje.");
        }
    }
    
}
