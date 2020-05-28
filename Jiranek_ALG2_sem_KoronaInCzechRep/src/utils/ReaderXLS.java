package utils;

import app.Kraj;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Trida zajistujici nacitani excelovskeho souboru
 *
 * @author Michal Jiránek
 */
public class ReaderXLS extends Reader {

    /**
     * Metoda nacita udaje z excelovske tabulky do ArrayListu
     *
     * @param filename
     * @param kraje
     * @return
     * @throws IOException
     */
    @Override
    public ArrayList<Kraj> getList(String filename, ArrayList<Kraj> kraje) throws IOException {
        if (filename.contains("kraje")) {
            String name = "";
            int nObyvatel = 0;
            File krajeFile = new File(dataDirectory, filename);
            Workbook wb = null;
            try {
                wb = Workbook.getWorkbook(krajeFile);
            } catch (BiffException ex) {
                System.err.println(ex.getMessage());
            }
            Sheet s = wb.getSheet(0);
            int rows = s.getRows();
            int cols = s.getColumns();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Cell c = s.getCell(j, i);
                    if (j == 0) {
                        name = c.getContents();
                    } else if (j == 1) {
                        nObyvatel = Integer.parseInt(c.getContents());
                    }
                }
                Kraj k = new Kraj(name, nObyvatel);
                kraje.add(k);
            }
        } else if (filename.contains("statistika")) {
            String name = "";
            int nNakaz = 0;
            int nHosp = 0;
            int nVylec = 0;
            File statistikaFile = new File(dataDirectory, filename);
            Workbook wb = null;
            try {
                wb = Workbook.getWorkbook(statistikaFile);
            } catch (BiffException ex) {
                System.err.println(ex.getMessage());
            }
            Sheet s = wb.getSheet(0);
            int rows = s.getRows();
            int cols = s.getColumns();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Cell c = s.getCell(j, i);
                    if (j == 0) {
                        name = c.getContents();
                    } else if (j == 1) {
                        nNakaz = Integer.parseInt(c.getContents());
                    } else if (j == 2) {
                        nHosp = Integer.parseInt(c.getContents());
                    } else if (j == 3) {
                        nVylec = Integer.parseInt(c.getContents());
                    }
                }
                try {
                    Kraj k = findKraj(name, kraje);
                    k.setnNakazenych(nNakaz);
                    k.setnHospital(nHosp);
                    k.setnVylecenych(nVylec);
                } catch (NoSuchElementException e) {
                    System.err.println(e.getMessage());
                }

            }
        } else if (filename.contains("karantena")) {
            String name = "";
            String startKara = "";
            String stopKara = "";
            File karantenaFile = new File(dataDirectory, filename);
            Workbook wb = null;
            try {
                wb = Workbook.getWorkbook(karantenaFile);
            } catch (BiffException ex) {
                System.err.println(ex.getMessage());
            }
            Sheet s = wb.getSheet(0);
            int rows = s.getRows();
            int cols = s.getColumns();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Cell c = s.getCell(j, i);
                    if (j == 0) {
                        name = c.getContents();
                    } else if (j == 1) {
                        startKara = c.getContents();
                    } else if (j == 2) {
                        stopKara = c.getContents();
                    }
                }
                try {
                    Kraj k = findKraj(name, kraje);
                    k.setStartKarant(startKara);
                    k.setEndKarant(stopKara);
                } catch (NoSuchElementException e) {
                    System.err.println(e.getMessage());
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
