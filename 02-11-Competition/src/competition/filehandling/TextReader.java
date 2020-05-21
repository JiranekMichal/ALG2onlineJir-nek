package competition.filehandling;

import competition.app.Runner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Michal Jiránek
 */
public class TextReader extends Reader {

    @Override
    public ArrayList<Runner> getList(String filename, ArrayList<Runner> runners) throws IOException {
        if (filename.contains("start")) {
            File startFile = new File(dataDirectory,filename);
            try (BufferedReader inStart = new BufferedReader(new FileReader(startFile))) {
                String line;
                while ((line = inStart.readLine()) != null) {
                    String[] parts = line.split("[ ]+");
                    int number = Integer.parseInt(parts[0]);
                    String firstname = parts[1];
                    String lastname = parts[2];
                    String startTime = parts[3];
                    Runner r = new Runner(number, firstname, lastname);
                    r.setStartTime(startTime);
                    runners.add(r);
                }
                return runners;
            }
        } else {
            File finishFile = new File(dataDirectory,filename);
            try (BufferedReader inFinish = new BufferedReader(new FileReader(finishFile))) {
                String line;
                while ((line = inFinish.readLine()) != null) { //102 10:02:00:000
                    String[] parts = line.split("[ ]+");
                    try {
                        Runner r = findRunner(Integer.parseInt(parts[0]), runners);
                        r.setFinishTime(parts[1]);
                    } catch (NoSuchElementException e) {
                        System.err.print(e.getMessage());//neexistujici bezec se preskoci
                    }
                }
                return runners;
            }
        }
    }
    
    private Runner findRunner(int number, ArrayList<Runner>runners) {
        for (Runner runner : runners) {
            if (runner.getNumber() == number) {
                return runner;
            }
        }
        throw new NoSuchElementException("Bezec s cislem " + number + " nebyl na startu.");
    }

}
