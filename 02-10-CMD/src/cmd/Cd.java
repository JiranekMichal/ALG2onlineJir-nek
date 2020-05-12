
package cmd;

import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class Cd extends Command{

    @Override
    public Execution execute(File actualDir) {
        File file;
        if(params.length == 2){
            if("..".equals(params[1])){
                file = new File(actualDir.getParent());
            }else{
                try{
                    file = new File(actualDir.getAbsolutePath() + "\\" + params[1]);
                }catch(Exception e){
                    throw new RuntimeException("Slozka nenalezena.");
                }
            }
            return new Execution(file,"Uspesne provedeno.");
        }else{
            return new Execution(actualDir,"Neplatny prikaz.");
        }
    }
    
}
