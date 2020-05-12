
package cmd;

import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class CmdEditor implements CmdInterface{
    private boolean isRunning;
    private File actualDir;
    private Command command;


    public CmdEditor(){
        isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
    }
    
    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    @Override
    public String parseAndExecute(String line) {
        //parse
        command = Parser.parse(line);
        //execute
        //isRunning = false;
        Execution ex = command.execute(actualDir);
        actualDir = ex.getActualDir();
        
        if(actualDir == null){
            isRunning = false;
        }
        
        return ex.getText();
    }
    
}
