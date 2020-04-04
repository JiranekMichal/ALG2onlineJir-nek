
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
        System.out.println(clients.get(0).getName());
        System.out.println(clients.get(1).getName());
        System.out.println(clients.get(2).getName());
        clients.get(0).addAccount(0001, 1000);
        clients.get(0).addAccount(0002, 500);
        clients.get(1).addAccount(0003, 1200);
        clients.get(2).addAccount(0004, 120);
        System.out.println(clients.get(0).getName() + " - zůstatek: " + clients.get(0).totalBalance());
        System.out.println(clients.get(1).getName() + " - zůstatek: " + clients.get(1).totalBalance());
        System.out.println(clients.get(2).getName() + " - zůstatek: " + clients.get(2).totalBalance());
    }
    
}
