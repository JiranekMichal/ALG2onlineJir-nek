
package competition.filehandling;

import competition.app.Runner;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Michal Jiránek
 */
public abstract class Reader {
    public abstract ArrayList<Runner> getList(String filename, ArrayList<Runner> runners) throws IOException;
}
