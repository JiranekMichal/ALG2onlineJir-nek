
package competition.filehandling;

import java.io.IOException;
import java.util.List;
import competition.app.Runner;

/**
 *
 * @author Michal Jiránek
 */
public abstract class Writer {
    public abstract void saveResults(String resultFilename, List<Runner>runners)throws IOException;
}
