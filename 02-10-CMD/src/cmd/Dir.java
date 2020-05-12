
package cmd;

import java.io.File;
import java.io.FileFilter;
import static java.util.Arrays.sort;
import java.util.Date;

/**
 *
 * @author Michal Jiránek
 */
public class Dir extends Command{

    @Override
    public String execute(File actualDir) {
        File[] files;
        if(params.length == 1 || params.length == 2 && "-e".equals(params[1])){
            files = actualDir.listFiles();
            return dirToString(files);
        }else if(params.length == 2 && "-o".equals(params[1])){
            files = actualDir.listFiles();
            sort(files);
            return dirToString(files);
        }else if(params.length == 3 && "-e".equals(params[1])){
            //files = actualDir.listFiles
            //return dirToString(files);
        }
        return "0";
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if(file.isDirectory()){
                sb.append(String.format("%s\n", file.getName()));
            }else{
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }

    
}
