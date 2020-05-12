
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
    public Execution execute(File actualDir) {
        File[] files;
        if(params.length == 1 || params.length == 2 && "-e".equals(params[1])){
            files = actualDir.listFiles();
            return new Execution(actualDir,dirToString(files));
        }else if(params.length == 2 && "-o".equals(params[1])){
            files = actualDir.listFiles();
            sort(files);
            return new Execution(actualDir,dirToString(files));
        }else if(params.length == 3 && "-e".equals(params[1])){
            String ending = params[2];
            FileFilter f = (File pathname) -> pathname.getName().endsWith(ending);
            files = actualDir.listFiles(f);
            return new Execution(actualDir,dirToString(files));
        }else if(params.length == 3 && "-s".equals(params[1])){
            int size = Integer.parseInt(params[2]);
            FileFilter f = (File pathname) -> pathname.length()>size;
            files = actualDir.listFiles(f);
            return new Execution(actualDir,dirToString(files));
        }
        return new Execution(actualDir,"Neplatny prikaz.");
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
