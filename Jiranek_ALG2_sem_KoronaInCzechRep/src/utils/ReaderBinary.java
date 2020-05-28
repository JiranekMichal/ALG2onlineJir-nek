package utils;

import app.Kraj;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import static utils.Reader.dataDirectory;

/**
 * Trida zajistujici nacitani binarnich souboru
 *
 * @author Michal Jiránek
 */
public class ReaderBinary extends Reader {

    /**
     * Metoda nacitajici udaje z binarniho dokumentu do ArrayListu
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
            try (DataInputStream dis = new DataInputStream(new FileInputStream(krajeFile))) {
                boolean isEnd = false;
                while (!isEnd) {
                    try {
                        String name = dis.readUTF();
                        int nObyvatel = dis.readInt();
                        Kraj k = new Kraj(name, nObyvatel);
                        kraje.add(k);
                    } catch (EOFException e) {
                        isEnd = true;
                    }
                }
            }

        } else if (filename.contains("statistika")) {
            File statistikaFile = new File(dataDirectory, filename);
            try (DataInputStream dis = new DataInputStream(new FileInputStream(statistikaFile))) {
                boolean isEnd = false;
                while (!isEnd) {
                    try {
                        String name = dis.readUTF();
                        int nNakazenych = dis.readInt();
                        int nHospital = dis.readInt();
                        int nVylecenych = dis.readInt();
                        try {
                            Kraj k = findKraj(name, kraje);
                            k.setnNakazenych(nNakazenych);
                            k.setnHospital(nHospital);
                            k.setnVylecenych(nVylecenych);
                        } catch (NoSuchElementException e) {
                            System.err.println(e.getMessage());
                        }
                    } catch (EOFException e) {
                        isEnd = true;
                    }
                }
            }

        } else if (filename.contains("karantena")) {
            File karantenaFile = new File(dataDirectory, filename);
            try (DataInputStream dis = new DataInputStream(new FileInputStream(karantenaFile))) {
                boolean isEnd = false;
                while (!isEnd) {
                    try {
                        String name = dis.readUTF();
                        String startKarant = dis.readUTF();
                        String endKarant = dis.readUTF();
                        try {
                            Kraj k = findKraj(name, kraje);
                            k.setStartKarant(startKarant);
                            k.setEndKarant(endKarant);
                        } catch (NoSuchElementException e) {
                            System.err.println(e.getMessage());
                        }
                    } catch (EOFException e) {
                        isEnd = true;
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
