
package cmd;

import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class Mkdir extends Command{

    @Override
    public Execution execute(File actualDir) {
        if(params.length == 2){
            File file = new File(actualDir.getAbsolutePath() + "\\" + params[1]);
            file.mkdir();
            return new Execution(actualDir,"Soubor byl uspesne vytvoren.");
        }else{
            return new Execution(actualDir,"Neplatny prikaz.");
        }
    }
    
}
