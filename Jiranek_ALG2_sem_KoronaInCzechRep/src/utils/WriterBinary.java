package utils;

import app.Kraj;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Trida zajistuje zapis do binarniho dokumentu
 *
 * @author Michal Jiránek
 */
public class WriterBinary extends Writer {

    /**
     * Metoda uklada naformatovane informace do dokumentu s priponou .dat
     *
     * @param resultFilename
     * @param kraje
     * @throws IOException
     */
    @Override
    public void saveResults(String resultFilename, ArrayList<Kraj> kraje) throws IOException {
        File result = new File(dataDirectory, resultFilename);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(result))) {
            for (Kraj kraj : kraje) {
                dos.writeUTF(kraj.getName());
                dos.writeInt(kraj.getnObyvatel());
                if (kraj.getnNakazenych() == -1) {
                    dos.writeUTF("neni info");
                    dos.writeUTF("neni info");
                    dos.writeUTF("neni info");
                    dos.writeUTF("neni info");
                    dos.writeUTF("neni info");
                } else {
                    dos.writeUTF(String.format("%d", kraj.getnNakazenych()));
                    if (kraj.getnObyvatel() == 0) {
                        dos.writeUTF("neni info");
                    } else {
                        dos.writeUTF(String.format("%6.2f", kraj.getPomerNakaz()));
                    }
                    dos.writeUTF(String.format("%d", kraj.getnHospital()));
                    dos.writeUTF(String.format("%d", kraj.getnVylecenych()));
                    if (kraj.getnNakazenych() == 0) {
                        dos.writeUTF("neni info");
                    } else {
                        dos.writeUTF(String.format("%5.2f", kraj.getKoefNadeje()));
                    }
                }

                if (kraj.getStartKarant() == null) {
                    dos.writeUTF("neni info");
                    dos.writeUTF("neni info");
                    dos.writeLong(0);
                } else {
                    dos.writeUTF(kraj.getStartKarantString());
                    dos.writeUTF(kraj.getEndKarantString());
                    dos.writeLong(kraj.karantenaLength());
                }

            }
        }
    }

}
