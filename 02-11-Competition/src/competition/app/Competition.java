package competition.app;

import competition.filehandling.BinaryReader;
import competition.utils.IllegalFilenameException;
import competition.filehandling.Writer;
import competition.filehandling.TextWriter;
import competition.filehandling.BinaryWriter;
import competition.filehandling.Reader;
import competition.filehandling.TextReader;
import competition.utils.TxtToDat;
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

    private ArrayList<Runner> runners = new ArrayList<>();

    public void load(String startFilename, String finishFilename) throws FileNotFoundException, IOException {
        //start2019, Start2019, start19 2000-2030
        //if(!startFilename.matches("^[Ss]tart(20)?([0-2][0-9] | 30)")){//regularni vyraz
            //throw new IllegalFilenameException("Nepodporovany nazev souboru.")
        //}
        if(!startFilename.contains("start")){
            throw new IllegalFilenameException("Start soubor musi obsahovat start.");
        }
        if(!finishFilename.contains("finish")){
            throw new IllegalFilenameException("Finish soubor musi obsahovat finish.");
        }

        Reader r;
        if (startFilename.endsWith(".txt")) {
            r = new TextReader();
            }else if(startFilename.endsWith(".dat")){
            r = new BinaryReader();
        } else {
            throw new IllegalArgumentException("Nepordporovana koncovka souboru.");
        }
        runners = r.getList(startFilename, runners);
        
        if (finishFilename.endsWith(".txt")) {
            r = new TextReader();
            }else if(startFilename.endsWith(".dat")){
            r = new BinaryReader();
        } else {
            throw new IllegalArgumentException("Nepordporovana koncovka souboru.");
        }
        runners = r.getList(finishFilename, runners);

        
        
        //nacitani pomoci Scanner
        /*File startFile = new File(startFilename);
        try (Scanner inStart = new Scanner(startFile)) {
            while (inStart.hasNext()) {
                int number = inStart.nextInt();
                String firstname = inStart.next();
                String lastname = inStart.next();
                String startTime = inStart.next();
                Runner r = new Runner(number, firstname, lastname);
                r.setStartTime(startTime);
                runners.add(r);
            }
        }

        //nacitani pomoci BufferedReader
        File finishFile = new File(finishFilename);
        try (BufferedReader inFinish = new BufferedReader(new FileReader(finishFile))) {
            String line;
            while ((line = inFinish.readLine()) != null) { //102 10:02:00:000
                String[] parts = line.split("[ ]+");
                try {
                    Runner r = findRunner(Integer.parseInt(parts[0]));
                    r.setFinishTime(parts[1]);
                } catch (NoSuchElementException e) {
                    System.err.print(e.getMessage());//neexistujici bezec se preskoci
                }
            }
        }
    }

    private Runner findRunner(int number) {
        for (Runner runner : runners) {
            if (runner.getNumber() == number) {
                return runner;
            }
        }
        throw new NoSuchElementException("Bezec s cislem " + number + " nebyl na startu.");
    }*/
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

    public void saveResults(String resultFilename) throws IOException {
        Collections.sort(runners);
        Writer w;
        if (resultFilename.endsWith(".txt")) {
            w = new TextWriter();
            }else if(resultFilename.endsWith(".dat")){
            w = new BinaryWriter();
        } else {
            throw new IllegalArgumentException("Nepordporovana koncovka souboru.");
        }
        w.saveResults(resultFilename, runners);
    }

}
