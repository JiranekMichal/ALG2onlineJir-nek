
package competition.filehandling;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import competition.app.Runner;

/**
 *
 * @author Michal Jiránek
 */
public class BinaryWriter extends Writer{
    //ukladat pouze data, zadne oddelovace, mezery atd.
    @Override
    public void saveResults(String resultFilename, List<Runner> runners) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFilename))){
            dos.writeUTF("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                dos.writeInt(n);
                //dos.writeChar('.');
                dos.writeUTF(runner.getFirstname());
                //tatkto funguje writeUTF
                int nChars = runner.getLastname().length();
                dos.writeInt(nChars);
                for (int i = 0; i < nChars; i++) {
                    dos.writeChar(runner.getLastname().charAt(i));
                }
                //
                dos.writeLong(runner.runningTime().toNanoOfDay());
                n++;
            }
        }
    }
    
}
