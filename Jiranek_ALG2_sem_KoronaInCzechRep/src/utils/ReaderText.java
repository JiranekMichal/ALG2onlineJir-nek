package utils;

import app.Kraj;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Trida zajistujici nacitani textovych souboru
 *
 * @author Michal Jiránek
 */
public class ReaderText extends Reader {

    /**
     * Metoda nacitajici udaje z textoveho dokumentu do ArrayListu
     *
     * @param filename
     * @param kraje
     * @return
     * @throws IOException
     */
    @Override
    public ArrayList<Kraj> getList(String filename, ArrayList<Kraj> kraje) throws IOException {
        if (filename.contains("kraje")) {
            File krajeFile = new File(dataDirectory, filename);
            try (BufferedReader inKraje = new BufferedReader(new FileReader(krajeFile))) {
                String line;
                while ((line = inKraje.readLine()) != null) {
                    String[] parts = line.split("[ ]+");
                    String name = parts[0];
                    int nObyvatel = Integer.parseInt(parts[1]);
                    Kraj k = new Kraj(name, nObyvatel);
                    kraje.add(k);
                }
            }

        } else if (filename.contains("statistika")) {
            File statistikaFile = new File(dataDirectory, filename);
            try (BufferedReader inKraje = new BufferedReader(new FileReader(statistikaFile))) {
                String line;
                while ((line = inKraje.readLine()) != null) {
                    String[] parts = line.split("[ ]+");
                    try {
                        Kraj k = findKraj(parts[0], kraje);
                        k.setnNakazenych(Integer.parseInt(parts[1]));
                        k.setnHospital(Integer.parseInt(parts[2]));
                        k.setnVylecenych(Integer.parseInt(parts[3]));
                    } catch (NoSuchElementException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }

        } else if (filename.contains("karantena")) {
            File karantenaFile = new File(dataDirectory, filename);
            try (BufferedReader inKraje = new BufferedReader(new FileReader(karantenaFile))) {
                String line;
                while ((line = inKraje.readLine()) != null) {
                    String[] parts = line.split("[ ]+");
                    try {
                        Kraj k = findKraj(parts[0], kraje);
                        k.setStartKarant(parts[1]);
                        k.setEndKarant(parts[2]);
                    } catch (NoSuchElementException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
        return kraje;
    }

    private Kraj findKraj(String part, ArrayList<Kraj> kraje) {
        for (Kraj kraj : kraje) {
            if (kraj.getName().equals(part)) {
                return kraj;
            }
        }
        throw new NoSuchElementException("Kraj " + part + " neni evidovan.");
    }

}
