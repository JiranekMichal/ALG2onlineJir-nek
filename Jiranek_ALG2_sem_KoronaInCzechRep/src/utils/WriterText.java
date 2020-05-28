package utils;

import app.Kraj;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Trida zajistuje zapis do textoveho dokumentu
 *
 * @author Michal Jiránek
 */
public class WriterText extends Writer {

    /**
     * Metoda uklada naformatovane informace do dokumentu s priponou .txt
     *
     * @param resultFilename
     * @param kraje
     * @throws IOException
     */
    @Override
    public void saveResults(String resultFilename, ArrayList<Kraj> kraje) throws IOException {
        File result = new File(dataDirectory, resultFilename);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(result)))) {
            pw.println(String.format("%s", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
            pw.println(String.format("%-24s%-22s%-22s%-27s%-28s%-22s%-22s%-4s", "nazev", "pocet obyvatel", "pocet nakazenych(%)", "pocet hostalizovanych", "pocet vylecenych (k.n.)", "zacatek karanteny", "konec karanteny", "dny"));
            pw.println(String.format("%s", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
            for (Kraj kraj : kraje) {
                pw.println(kraj);
            }
            pw.println(String.format("%s", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        }

    }

}
