package competition.filehandling;

import competition.app.Runner;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Michal Jiránek
 */
public class BinaryReader extends Reader {

    @Override
    public ArrayList<Runner> getList(String filename, ArrayList<Runner> runners) throws IOException {
        if (filename.contains("start")) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                boolean isEnd = false;
                while (!isEnd) {
                    try {
                        int number = dis.readInt();
                        String firstname = dis.readUTF();
                        String lastname = dis.readUTF();
                        String startTime = dis.readUTF();
                        Runner r = new Runner (number, firstname, lastname);
                        r.setStartTime(startTime);
                        runners.add(r);
                    } catch (EOFException e) {
                        isEnd = true;
                    }
                }
            }
        } else {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                boolean isEnd = false;
                while (!isEnd) {
                    try {
                        int number = dis.readInt();
                        String finishTime = dis.readUTF();
                        Runner r = findRunner(number,runners);
                        r.setFinishTime(finishTime);
                    } catch (EOFException e) {
                        isEnd = true;
                    }
                }
            }
        }
        return runners;
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
