package utils;

import app.Kraj;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Abstrakti trida definujici vypis dat do dokumentu
 *
 * @author Michal Jiránek
 */
public abstract class Writer {

    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");

    public abstract void saveResults(String resultFilename, ArrayList<Kraj> kraje) throws IOException;
}
