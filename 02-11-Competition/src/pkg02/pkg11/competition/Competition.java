
package pkg02.pkg11.competition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Michal Jiránek
 */
public class Competition {
    private ArrayList<Runner>runners = new ArrayList<>();

    public void load(String startFilename, String finishFilename) throws FileNotFoundException, IOException {
        File startFile = new File(startFilename);
        Scanner inStart = new Scanner(startFile);
        while(inStart.hasNext()){
            int number = inStart.nextInt();
            String firstname = inStart.next();
            String lastname = inStart.next();
            String startTime = inStart.next();
            Runner r = new Runner(number, firstname, lastname);
            r.setStartTime(startTime);
            runners.add(r);
        }
        
        //nacitani pomoci bufferedreader
        File finishFile = new File(finishFilename);
        BufferedReader inFinish = new BufferedReader(new FileReader(finishFile));
        String line;
        while((line = inFinish.readLine()) != null){ //102 10:02:00:000
            String[]parts = line.split("[ ]+");
            Runner r = findRunner(Integer.parseInt(parts[0]));
            r.setFinishTime(parts[1]);
        }
    }
    
    
    private Runner findRunner(int number) {
        for (Runner runner:runners){
            if(runner.getNumber() == number){
                return runner;
            }
        }
        throw new NoSuchElementException("Bezec s cislem " + number + " nebyl na startu.");
    }

    public String getResults() {
        Collections.sort(runners);
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Runner runner : runners) {
            sb.append(String.format("%-2d. %s%n", n, runner));
            n++;
        }
        return sb.toString();
    }

    public void saveResults(String resultFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
