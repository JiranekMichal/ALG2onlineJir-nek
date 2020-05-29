package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import static utils.Comparators.KARAN;
import static utils.Comparators.KOEF;
import static utils.Comparators.NAKAZ;
import static utils.Comparators.NAKAZPERCENT;
import static utils.Comparators.POCHOSP;
import static utils.Comparators.POCOB;
import static utils.Comparators.POCVYLEC;
import utils.IllegalFilenameException;
import utils.Reader;
import utils.ReaderBinary;
import utils.ReaderText;
import utils.ReaderXLS;
import utils.RepublicInterface;
import utils.Writer;
import utils.WriterBinary;
import utils.WriterText;

/**
 * Trida definuje objekt Republic
 *
 * @author Michal Jiránek
 */
public class Republic implements RepublicInterface {

    private ArrayList<Kraj> kraje = new ArrayList<>();

    /**
     * Metoda nacita data ze souboru textovych, nebo binarnich souboru, a uklada
     * je do ArrayListu.
     *
     * @param krajeFilename
     * @param statistikaFilename
     * @param karantenaFilename
     * @throws IOException
     */
    @Override
    public void load(String krajeFilename, String statistikaFilename, String karantenaFilename) throws IOException {
        if (!krajeFilename.contains("kraje")) {
            throw new IllegalFilenameException("Nazev prvniho souboru musi obsahovat kraje.");
        }
        if (!statistikaFilename.contains("statistika")) {
            throw new IllegalFilenameException("Nazev druheho souboru musi obsahovat statistika.");
        }
        if (!karantenaFilename.contains("karantena")) {
            throw new IllegalFilenameException("Nazev tretiho souboru musi obsahovat karantena.");
        }

        kraje.clear();

        Reader r;
        if (krajeFilename.endsWith(".txt")) {
            r = new ReaderText();
        } else if (krajeFilename.endsWith(".dat")) {
            r = new ReaderBinary();
        } else if (krajeFilename.endsWith(".xls")) {
            r = new ReaderXLS();
        } else {
            throw new IllegalArgumentException("Nepordporovana koncovka souboru.");
        }
        kraje = r.getList(krajeFilename, kraje);

        if (statistikaFilename.endsWith(".txt")) {
            r = new ReaderText();
        } else if (statistikaFilename.endsWith(".dat")) {
            r = new ReaderBinary();
        } else if (statistikaFilename.endsWith(".xls")) {
            r = new ReaderXLS();
        } else {
            throw new IllegalArgumentException("Nepordporovana koncovka souboru.");
        }
        kraje = r.getList(statistikaFilename, kraje);

        if (karantenaFilename.endsWith(".txt")) {
            r = new ReaderText();
        } else if (karantenaFilename.endsWith(".dat")) {
            r = new ReaderBinary();
        } else if (karantenaFilename.endsWith(".xls")) {
            r = new ReaderXLS();
        } else {
            throw new IllegalArgumentException("Nepordporovana koncovka souboru.");
        }
        kraje = r.getList(karantenaFilename, kraje);

    }

    /**
     * Metoda uklada informace do dokumentu se zvolenou koncovkou
     *
     * @param filename
     * @throws IOException
     */
    @Override
    public void save(String filename) throws IOException {
        Writer w;
        if (filename.endsWith(".txt")) {
            w = new WriterText();
        } else if (filename.endsWith(".dat")) {
            w = new WriterBinary();
        } else {
            throw new IllegalArgumentException("Nepordporovana koncovka souboru.");
        }
        w.saveResults(filename, kraje);

    }

    /**
     * Metoda vraci string s informacemi o vsech krajich
     *
     * @return
     */
    @Override
    public String getKrajeInfo() {
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        sb.append(String.format("%-24s%-22s%-22s%-27s%-28s%-22s%-22s%-4s%n", "nazev", "pocet obyvatel", "pocet nakazenych(%)", "pocet hostalizovanych", "pocet vylecenych (k.n.)", "zacatek karanteny", "konec karanteny", "dny"));
        sb.append(String.format("%s%n", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        for (Kraj kraj : kraje) {
            sb.append(String.format("%s%n", kraj));
        }
        sb.append(String.format("%s%n", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        return sb.toString();
    }

    /**
     * Metoda tridi kraje dle poctu nakazenych a vraci je setridene jako String
     *
     * @return
     */
    @Override
    public String sortByNakazenych() {
        Collections.sort(kraje, NAKAZ);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "------------------------------------------"));
        sb.append(String.format("%-24s%-20s%n", "nazev", "pocet nakazenych"));
        sb.append(String.format("%s%n", "------------------------------------------"));
        for (Kraj kraj : kraje) {
            sb.append(String.format("%s%n", kraj.toStringNakaz()));
        }
        sb.append(String.format("%s%n", "------------------------------------------"));
        return sb.toString();
    }

    /**
     * Metoda tridi kraje dle pomeru nakazenych a vraci je setridene jako String
     *
     * @return
     */
    @Override
    public String sortByNakazPomer() {
        Collections.sort(kraje, NAKAZPERCENT);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        sb.append(String.format("%-24s%-20s%-20s%-20s%n", "nazev", "pocet nakazenych", "pocet obyvatel", "pomer nakazenych[%]"));
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        for (Kraj kraj : kraje) {
            sb.append(String.format("%s%n", kraj.toStringNakazPerCent()));
        }
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        return sb.toString();
    }

    /**
     * Metoda tridi kraje podle poctu dnu v karantene a vypisuje je
     *
     * @return
     */
    @Override
    public String sortByDnyKaran() {
        Collections.sort(kraje, KARAN);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        sb.append(String.format("%-24s%-20s%-20s%-20s%n", "nazev", "zacatek karanteny", "konec karanteny", "dny v karantene"));
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        for (Kraj kraj : kraje) {
            sb.append(String.format("%s%n", kraj.toStringKarantena()));
        }
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        return sb.toString();
    }

    /**
     * Metoda tridi kraje podle poctu obyvatel a vraci je setridene jako String
     *
     * @return
     */
    @Override
    public String sortByObyvatel() {
        Collections.sort(kraje, POCOB);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "------------------------------------------"));
        sb.append(String.format("%-24s%-20s%n", "nazev", "pocet obyvatel"));
        sb.append(String.format("%s%n", "------------------------------------------"));
        for (Kraj kraj : kraje) {
            sb.append(String.format("%s%n", kraj.toStringObyvatel()));
        }
        sb.append(String.format("%s%n", "------------------------------------------"));
        return sb.toString();
    }

    /**
     * Metoda tridi kraje podle poctu hospitalizovaných osob a vraci je
     * setridene jako String
     *
     * @return
     */
    @Override
    public String sortByHosp() {
        Collections.sort(kraje, POCHOSP);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "-----------------------------------------------"));
        sb.append(String.format("%-24s%-20s%n", "nazev", "pocet hospitalizovaných"));
        sb.append(String.format("%s%n", "-----------------------------------------------"));
        for (Kraj kraj : kraje) {
            sb.append(String.format("%s%n", kraj.toStringHosp()));
        }
        sb.append(String.format("%s%n", "-----------------------------------------------"));
        return sb.toString();
    }

    /**
     * Metoda tridi kraje podle poctu vylecenych osob a vraci je setridene jako
     * String
     *
     * @return
     */
    @Override
    public String sortByVylec() {
        Collections.sort(kraje, POCVYLEC);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "------------------------------------------"));
        sb.append(String.format("%-24s%-20s%n", "nazev", "pocet vylecenych"));
        sb.append(String.format("%s%n", "------------------------------------------"));
        for (Kraj kraj : kraje) {
            sb.append(String.format("%s%n", kraj.toStringVylec()));
        }
        sb.append(String.format("%s%n", "------------------------------------------"));
        return sb.toString();
    }

    /**
     * Metoda tridi kraje podle koeficientu nadeje a vraci je setridene jako
     * String
     *
     * @return
     */
    @Override
    public String sortByKoef() {
        Collections.sort(kraje, KOEF);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        sb.append(String.format("%-24s%-20s%-20s%-20s%n", "nazev", "pocet vylecenych", "pocet nakazenych", "koeficient nadeje"));
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        for (Kraj kraj : kraje) {
            sb.append(String.format("%s%n", kraj.toStringKoef()));
        }
        sb.append(String.format("%s%n", "-----------------------------------------------------------------------------------"));
        return sb.toString();
    }

    /**
     * Metoda nalezne kraje de zadaneho nazvu a rati jeho info jako String
     *
     * @param nazev
     * @return
     */
    @Override
    public String getKrajInfo(String nazev) {
        Kraj k = findKraj(nazev);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%s%n", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        sb.append(String.format("%-24s%-22s%-22s%-27s%-28s%-22s%-22s%-4s%n", "nazev", "pocet obyvatel", "pocet nakazenych(%)", "pocet hostalizovanych", "pocet vylecenych (k.n.)", "zacatek karanteny", "konec karanteny", "dny"));
        sb.append(String.format("%s%n", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        sb.append(String.format("%s%n", k.toString()));
        sb.append(String.format("%s%n", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        return sb.toString();
    }

    private Kraj findKraj(String nazev) {
        for (Kraj kraj : kraje) {
            if (kraj.getName().equals(nazev)) {
                return kraj;
            }
        }
        throw new NoSuchElementException("Kraj " + nazev + " neni evidovan.");
    }

}
