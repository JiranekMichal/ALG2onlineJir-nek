package utils;

import app.Kraj;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static utils.Writer.dataDirectory;

/**
 * Pomocna trida
 *
 * @author Michal Jiránek
 */
public class TextToBinary {

    /**
     * Metoda prevede textovy soubor do binarniho, ktery bude kompatibilni s
     * ReaderBinary
     *
     * @param filename
     * @throws IOException
     */
    public static void textToBinary(String filename) throws IOException {
        if (filename.contains("kraje")) {
            ArrayList<Kraj> kraje = new ArrayList<>();
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
            File tofile1 = new File(dataDirectory, "kraje.dat");
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(tofile1))) {
                for (Kraj kraj : kraje) {
                    dos.writeUTF(kraj.getName());
                    dos.writeInt(kraj.getnObyvatel());
                }
            }
        } else if (filename.contains("statistika")) {
            ArrayList<Kraj2> kraje = new ArrayList<>();
            File statFile = new File(dataDirectory, filename);
            try (BufferedReader inStat = new BufferedReader(new FileReader(statFile))) {
                String line;
                while ((line = inStat.readLine()) != null) {
                    String[] parts = line.split("[ ]+");
                    String name = parts[0];
                    int nNak = Integer.parseInt(parts[1]);
                    int nHos = Integer.parseInt(parts[2]);
                    int nVyl = Integer.parseInt(parts[3]);
                    Kraj2 k = new Kraj2(name, nNak, nHos, nVyl);
                    kraje.add(k);
                }
            }
            File tofile2 = new File(dataDirectory, "statistika.dat");
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(tofile2))) {
                for (Kraj2 kraj : kraje) {
                    dos.writeUTF(kraj.getName());
                    dos.writeInt(kraj.getnNak());
                    dos.writeInt(kraj.getnHos());
                    dos.writeInt(kraj.getnVyl());
                }
            }
        } else {
            ArrayList<Kraj3> kraje = new ArrayList<>();
            File karFile = new File(dataDirectory, filename);
            try (BufferedReader inKar = new BufferedReader(new FileReader(karFile))) {
                String line;
                while ((line = inKar.readLine()) != null) {
                    String[] parts = line.split("[ ]+");
                    String name = parts[0];
                    String karStart = parts[1];
                    String karEnd = parts[2];
                    Kraj3 k = new Kraj3(name, karStart, karEnd);
                    kraje.add(k);

                }
            }
            File tofile3 = new File(dataDirectory, "karantena.dat");
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(tofile3))) {
                for (Kraj3 kraj : kraje) {
                    dos.writeUTF(kraj.getName());
                    dos.writeUTF(kraj.getKarStart());
                    dos.writeUTF(kraj.getKarEnd());
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            textToBinary("kraje.txt");
            textToBinary("statistika.txt");
            textToBinary("karantena.txt");
        } catch (IOException ex) {
            System.out.println("Takovy soubor neexistuje.");
        }
    }
}
