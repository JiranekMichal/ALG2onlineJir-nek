
package pkg02.pkg12.hurricanes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Scanner;

/**
 *
 * @author Michal Jiránek
 */
public class HurricanesEditor{
    private ArrayList<Hurricane> hurricanes = new ArrayList<>();

    public void load() throws FileNotFoundException{
        File file = new File("hurricanedata.txt");
        Scanner inFile = new Scanner(file);
        while(inFile.hasNext()){
            int year = inFile.nextInt();
            String month = inFile.next();
            int pressure = inFile.nextInt();
            int speed = inFile.nextInt();
            String name = inFile.next();
            Hurricane h = new Hurricane(year,month,pressure,speed,name);
            hurricanes.add(h);
        }
    }

    public String getInfoFromTo(int yearFrom, int yearTo) {
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("Huricany od roku %d do roku %d:",yearFrom, yearTo));
        sb.append(String.format("-%10s %10s %10s %10s %10s","name","year","month","pressure","speed"));
        for (Hurricane hurricane : hurricanes) {
            if(hurricane.getYear() >= yearFrom && hurricane.getYear() <= yearTo){
                sb.append(hurricane);
            }
        }
        return sb.toString();
    }

    public String getCategoryAndSpeed(String name) {
        for (Hurricane hurricane : hurricanes) {
            if(hurricane.getName().equals(name)){
                return String.format("%-10s %12s rychlost: %4.2f km/h",name,hurricane.cathegory(),hurricane.speedInKmh());
            }
        }
        return "Tento hurican nenni v zaznamech.";
    }

    public String getSortedBySpeed() {
        sort(hurricanes);
        return getInfoFromTo(Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
}
