
package cmd;

import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class EmptyCommand extends Command{

    @Override
    public Execution execute(File actualDir) {
        return new Execution(actualDir,"");
    }
    
}
