
package competition.filehandling;

import java.io.IOException;
import java.util.List;
import competition.app.Runner;
import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public abstract class Writer {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    
    public abstract void saveResults(String resultFilename, List<Runner>runners)throws IOException;
}
