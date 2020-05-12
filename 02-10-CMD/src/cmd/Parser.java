
package cmd;

/**
 *
 * @author Michal Jiránek
 */
public class Parser {
    public static Command parse (String line){ //dir -e .java
        String[] p = line.split(" +");//p[0] dir, p[1] -e, p[2] .java
        //TODO - osetrit prazdny prikaz
        char  first = Character.toUpperCase(p[0].charAt(0));
        String name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1);
        try{
            Class c = Class.forName(name);
            Command command = (Command) c.newInstance(); //ze zadaneho nazvu vytvori objekt zadane tridy - command
            command.setParams(p);
            return command;
        }catch(Exception e){
            throw new RuntimeException("Nepodařilo se příkaz naparsovat.");
        }

    }
}
