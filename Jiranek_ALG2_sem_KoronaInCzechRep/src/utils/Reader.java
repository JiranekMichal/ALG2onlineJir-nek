package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import app.Kraj;

/**
 * Abstraktni trida definujici nacitani
 *
 * @author Michal Jiránek
 */
public abstract class Reader {

    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");

    public abstract ArrayList<Kraj> getList(String filename, ArrayList<Kraj> kraje) throws IOException;
}
