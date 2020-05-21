
package competition.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import competition.app.Runner;
import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class TextWriter extends Writer{

    @Override
    public void saveResults(String resultFilename, List<Runner> runners) throws IOException{
        File resultFile = new File(dataDirectory, resultFilename);
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile)))) {
            //PrintWritter pw = new PrintWriter(new OutputStreamWriter(System.out/resultFilename,"Cp1250"), true);//kodovani
            pw.println("Nove vysledky:");
            int n = 1;
            for (Runner runner : runners) {
                pw.print(n + ". ");
                pw.println(runner);
                n++;
            }
        }
    }
    
}
