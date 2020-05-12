
package cmd;

import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class Rename extends Command{

    @Override
    public Execution execute(File actualDir) {
        if(params.length == 3){
            File file1 = new File(actualDir.getAbsolutePath() + "\\" + params[1]);
            File file2 = new File(actualDir.getAbsolutePath() + "\\" + params[2]);
            file1.renameTo(file2);
            return new Execution(actualDir,"Soubor byl uspesne prejmenovan.");
        }else{
            return new Execution(actualDir,"Neplatny prikaz.");
        }
    }
    
}
