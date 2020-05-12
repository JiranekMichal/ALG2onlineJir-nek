
package cmd;

import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class Execution {
    private File actualDir;
    private String text;

    public File getActualDir() {
        return actualDir;
    }

    public String getText() {
        return text;
    }

    public Execution(File actualDir, String text) {
        this.actualDir = actualDir;
        this.text = text;
    }
    
    
}
