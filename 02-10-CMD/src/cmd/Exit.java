
package cmd;

import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class Exit extends Command{

    @Override
    public Execution execute(File actualDir) {
        return new Execution (null, "Konec programu.");
    }
    
}
