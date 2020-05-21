
package competition.filehandling;

import competition.app.Runner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Michal Jiránek
 */
public abstract class Reader {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    
    public abstract ArrayList<Runner> getList(String filename, ArrayList<Runner> runners) throws IOException;
}
