
package cmd;

import java.io.File;

/**
 *
 * @author Michal Jiránek
 */
public class Help extends Command{

    @Override
    public Execution execute(File actualDir) {
        String help = "HELP\n" 
                + String.format("%-28s %s\n", "dir", "Display list of files and folders")
                + String.format("%-28s %s\n", "dir [-o]", "Display list of files and folders")
                + String.format("%-28s %s\n", "dir [-e] [file extension]", "Display list of files and folders with specified extension")
                + String.format("%-28s %s\n", "dir [-s] [size]", "Display list of files and folders bigger than specified size")
                + String.format("%-28s %s\n", "cd [folder name]", "Change directory - move to a specific folder")                
                + String.format("%-28s %s\n", "cd ..", "Change directory - move to the folder one level higher")
                + String.format("%-28s %s\n", "mkdir [folder name]", "Create new folders")
                + String.format("%-28s %s\n", "rename [nameFrom] [nameTo]", "Rename folder or file")
                + String.format("%-28s %s\n", "exit", "Exit CMD")
                + String.format("%-28s %s\n", "help", "Display help");
        return new Execution(actualDir, help);
    }
    
}
