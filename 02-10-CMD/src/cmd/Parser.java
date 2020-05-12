
package cmd;

/**
 *
 * @author Michal Jiránek
 */
public class Parser {
    public static Command parse (String line){ //dir -e .java
        String name;
        String[] p = new String[0];
        
        if(line.length() > 0){
            p = line.split(" +");//p[0] dir, p[1] -e, p[2] .java
            char  first = Character.toUpperCase(p[0].charAt(0));
            name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1);
        }else{
            name = "cmd.EmptyCommand";
        }
        try{
            Class c = Class.forName(name);
            Command command = (Command) c.newInstance(); //ze zadaneho nazvu vytvori objekt zadane tridy - command
            if(p.length > 0){
                command.setParams(p);
            }
            return command;
        }catch(Exception e){
            throw new RuntimeException("Nepodařilo se příkaz naparsovat.");
        }
  
    }
}
