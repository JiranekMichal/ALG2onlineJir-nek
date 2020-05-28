package app;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Trida definuje objekt Kraj
 *
 * @author Michal Jiránek
 */
public class Kraj {

    private String name;
    private int nObyvatel;
    private int nNakazenych = -1;
    private int nHospital = -1; //počet hospitalizovanych
    private int nVylecenych = -1;
    private LocalDate startKarant = null;
    private LocalDate endKarant = null;
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu");
    private String messege = "neni info";

    public Kraj(String name, int nObyvatel) {
        this.name = name;
        this.nObyvatel = nObyvatel;
        if (nObyvatel < 0) {
            System.err.println("Pocet obyvatel musi byt vetsi nez nula. Pocet obyvatel byl upraven na pristupnou hodnotu (kraj " + name + ").");
            this.nObyvatel = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getnObyvatel() {
        return nObyvatel;
    }

    public int getnNakazenych() {
        return nNakazenych;
    }

    public int getnHospital() {
        return nHospital;
    }

    public int getnVylecenych() {
        return nVylecenych;
    }

    /**
     * Metoda pocitajici pomer nakazenych
     *
     * @return
     */
    public double getPomerNakaz() {
        if (nObyvatel == 0) {
            return -1;
        }
        return ((double) nNakazenych / nObyvatel) * 100;
    }

    /**
     * Metoda pocitajici koeficient nadeje
     *
     * @return
     */
    public double getKoefNadeje() {
        if (nVylecenych == 0 && nNakazenych == 0) {
            return -1;
        } else if (nNakazenych == -1) {
            return -1;
        } else if (nNakazenych == 0) {
            return Integer.MAX_VALUE;
        }
        return ((double) nVylecenych / nNakazenych);
    }

    public LocalDate getStartKarant() {
        return startKarant;
    }

    public LocalDate getEndKarant() {
        return endKarant;
    }

    /**
     * Metoda pri nesmyslnem vstupu prenastavi hodnotu na prijatelnou hodnotu.
     *
     * @param nNakazenych
     */
    public void setnNakazenych(int nNakazenych) {
        if (nNakazenych > nObyvatel) {
            System.err.println("Pocet nakazenych nesmi byt vetsi nez pocet obyvatel. Pocet nakazenych byl upraven na pristupnou hodnotu (kraj " + name + ").");
            nNakazenych = nObyvatel;
        } else if (nNakazenych < 0) {
            System.err.println("Pocet nakazenych musi byt vetsi nez nula. Pocet nakazenych byl upraven na pristupnou hodnotu (kraj " + name + ").");
            nNakazenych = 0;
        }
        this.nNakazenych = nNakazenych;
    }

    /**
     * Metoda pri nesmyslnem vstupu prenastavi hodnotu na prijatelnou hodnotu.
     *
     * @param nHospital
     */
    public void setnHospital(int nHospital) {
        if (nHospital > nNakazenych) {
            System.err.println("Pocet hospitalizovanych nesmi byt vetsi nez pocet nakazenych. Pocet hospitalizovanych byl upraven na pristupnou hodnotu (kraj " + name + ").");
            nHospital = nNakazenych;
        } else if (nHospital < 0) {
            System.err.println("Pocet hospitalizovanych musi byt vetsi nez nula. Pocet hospitalizovanych byl upraven na pristupnou hodnotu (kraj " + name + ").");
            nHospital = 0;
        }
        this.nHospital = nHospital;
    }

    /**
     * Metoda pri nesmyslnem vstupu prenastavi hodnotu na prijatelnou hodnotu.
     *
     * @param nVylecenych
     */
    public void setnVylecenych(int nVylecenych) {
        if (nVylecenych > (nObyvatel - nNakazenych)) {
            System.err.println("Pocet vylecenych nesmi byt vetsi nez (pocet obyvatel - pocet nakazenych). Pocet vylecenych byl upraven na pristupnou hodnotu (kraj " + name + ").");
            nVylecenych = nObyvatel - nNakazenych;
        } else if (nVylecenych < 0) {
            System.err.println("Pocet vylecenych musi byt vetsi nez nula. Pocet vylecenych byl upraven na pristupnou hodnotu (kraj " + name + ").");
            nVylecenych = 0;
        }
        this.nVylecenych = nVylecenych;
    }

    /**
     * Metoda prevede datup z formatu dtf(dd.mm.yyyy) na LocalDate a v pripade
     * nesrovnalosti prevede na prijatelnou hodnotu.
     *
     * @param startKarant1
     */
    public void setStartKarant(String startKarant1) {
        this.startKarant = LocalDate.parse(startKarant1, dtf);
        if (startKarant.isAfter(LocalDate.now(ZoneId.systemDefault()))) {
            System.err.println("Zacatek karanteny nemuze byt pozdeji nez dnes. Zacatek karanteny byl upraven na pristupnou hodnotu (kraj " + name + ").");
            this.startKarant = LocalDate.now(ZoneId.systemDefault());
        }
    }

    /**
     * Metoda prevede datup z formatu dtf(dd.mm.yyyy) na LocalDate a v pripade
     * nesrovnalosti prevede na prijatelnou hodnotu. V pripade ze konec
     * karanteny = zacatek, je konec nastaven na dnesni datum(zamerne).
     *
     * @param endKarant1
     */
    public void setEndKarant(String endKarant1) {
        this.endKarant = LocalDate.parse(endKarant1, dtf);
        if (startKarant.isEqual(endKarant)) {
            this.endKarant = LocalDate.now(ZoneId.systemDefault());
        } else if (endKarant.isAfter(LocalDate.now(ZoneId.systemDefault()))) {
            System.err.println("Konec karanteny nemuze byt pozdeji nez dnes. Konec karanteny byl upraven na pristupnou hodnotu (kraj " + name + ").");
            this.endKarant = LocalDate.now(ZoneId.systemDefault());
        } else if (endKarant.isBefore(startKarant)) {
            System.err.println("Konec karanteny nemuze byt drive nez zacatek karanteny. Konec karanteny byl upraven na pristupnou hodnotu (kraj " + name + ").");
            this.endKarant = startKarant;
        }
    }

    /**
     * Metoda ziskava String prepis zacatku karanteny v definovanem tvaru
     *
     * @return
     */
    public String getStartKarantString() {
        return startKarant.format(dtf);
    }

    /**
     * Metoda ziskava String prepis konce karanteny v definovanem tvaru
     *
     * @return
     */
    public String getEndKarantString() {
        return endKarant.format(dtf);
    }

    /**
     * Metoda vraci String pro informace o kraji, osetruje nechtene hodnoty
     *
     * @return
     */
    @Override
    public String toString() {
        if (startKarant == null && nNakazenych == -1) {
            return String.format("%-24s%-22d%-22s%-27s%-28s%-22s%-22s%-4d", name, nObyvatel, messege, messege, messege, messege, messege, 0);
        } else if (nNakazenych == -1) {
            return String.format("%-24s%-22d%-22s%-27s%-28s%-22s%-22s%-4d", name, nObyvatel, messege, messege, messege, getStartKarantString(), getEndKarantString(), karantenaLength());
        } else if (startKarant == null && getPomerNakaz() == -1 && nNakazenych == -1) {
            return String.format("%-24s%-22d%-8d(%9s)%-3s%-27d%-12d(%9s)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, messege, "", nHospital, nVylecenych, messege, "", messege, messege, 0);
        } else if (startKarant == null) {
            if (nNakazenych == 0) {
                if (nVylecenych == 0) {
                    return String.format("%-24s%-22d%-11d(%6.2f)%-3s%-27d%-12d(%9s)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, getPomerNakaz(), "", nHospital, nVylecenych, messege, "", messege, messege, 0);
                }
                return String.format("%-24s%-22d%-11d(%6.2f)%-3s%-27d%-18d(%3s)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, getPomerNakaz(), "", nHospital, nVylecenych, "Inf", "", messege, messege, 0);
            }
            return String.format("%-24s%-22d%-11d(%6.2f)%-3s%-27d%-16d(%5.2f)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, getPomerNakaz(), "", nHospital, nVylecenych, getKoefNadeje(), "", messege, messege, 0);
        } else if (getPomerNakaz() == -1) {
            if (nNakazenych == 0) {
                if (nVylecenych == 0) {
                    return String.format("%-24s%-22d%-8d(%9s)%-3s%-27d%-12d(%9s)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, messege, "", nHospital, nVylecenych, messege, "", getStartKarantString(), getEndKarantString(), karantenaLength());
                }
                return String.format("%-24s%-22d%-8d(%9s)%-3s%-27d%-18d(%3s)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, messege, "", nHospital, nVylecenych, "Inf", "", getStartKarantString(), getEndKarantString(), karantenaLength());
            }
            return String.format("%-24s%-22d%-8d(%9s)%-3s%-27d%-16d(%5.2f)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, messege, "", nHospital, nVylecenych, getKoefNadeje(), "", getStartKarantString(), getEndKarantString(), karantenaLength());
        } else if (nNakazenych == 0) {
            if (nVylecenych == 0) {
                return String.format("%-24s%-22d%-11d(%6.2f)%-3s%-27d%-12d(%9s)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, getPomerNakaz(), "", nHospital, nVylecenych, messege, "", getStartKarantString(), getEndKarantString(), karantenaLength());
            }
            return String.format("%-24s%-22d%-11d(%6.2f)%-3s%-27d%-18d(%3s)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, getPomerNakaz(), "", nHospital, nVylecenych, "Inf", "", getStartKarantString(), getEndKarantString(), karantenaLength());
        }
        return String.format("%-24s%-22d%-11d(%6.2f)%-3s%-27d%-16d(%5.2f)%-5s%-22s%-22s%-4d", name, nObyvatel, nNakazenych, getPomerNakaz(), "", nHospital, nVylecenych, getKoefNadeje(), "", getStartKarantString(), getEndKarantString(), karantenaLength());
    }

    /**
     * Metoda vraci String pro vypis pro pocet nakazenych v kraji a take
     * upravuje vypis pri chybejicich hodnotach
     *
     * @return
     */
    public String toStringNakaz() {
        if (nNakazenych == -1) {
            return String.format("%-24s%-20s", name, messege);
        }
        return String.format("%-24s%-20d", name, nNakazenych);
    }

    /**
     * Metoda vraci String pro vypis pomeru nakazenych v kraji a take upravuje
     * vypis pri chybejicich hodnotach
     *
     * @return
     */
    public String toStringNakazPerCent() {
        if (nNakazenych == -1) {
            return String.format("%-24s%-20s%-20d%-20s", name, messege, nObyvatel, messege);
        }
        String pomer = String.format("%.2f", getPomerNakaz());
        if (getPomerNakaz() == -1) {
            return String.format("%-24s%-20d%-20d%-20s", name, nNakazenych, nObyvatel, messege);
        }
        return String.format("%-24s%-20d%-20d%-20s", name, nNakazenych, nObyvatel, pomer);
    }

    /**
     * Metoda vraci String pro vypis pomeru nakazenych v kraji a take upravuje
     * vypis pri chybejicich hodnotach
     *
     * @return
     */
    public String toStringKarantena() {
        if (startKarant == null) {
            return String.format("%-24s%-20s%-20s%-20d", name, messege, messege, 0);
        }
        return String.format("%-24s%-20s%-20s%-20d", name, getStartKarantString(), getEndKarantString(), karantenaLength());
    }

    /**
     * Metoda vraci String pro vypis pro pocet obyvatel v kraji
     *
     * @return
     */
    public String toStringObyvatel() {
        return String.format("%-24s%-20d", name, nObyvatel);
    }

    /**
     * Metoda vraci String pro vypis pro pocet hospitalizovanych v kraji a take
     * upravuje vypis pri chybejicich hodnotach
     *
     * @return
     */
    public String toStringHosp() {
        if (nNakazenych == -1) {
            return String.format("%-24s%-20s", name, messege);
        }
        return String.format("%-24s%-20d", name, nHospital);
    }

    /**
     * Metoda vraci String pro vypis pro pocet vylecenych v kraji a take
     * upravuje vypis pri chybejicich hodnotach
     *
     * @return
     */
    public String toStringVylec() {
        if (nNakazenych == -1) {
            return String.format("%-24s%-20s", name, messege);
        }
        return String.format("%-24s%-20d", name, nVylecenych);
    }

    /**
     * Metoda vraci String pro vypis pro koeficient nadeje v kraji a take
     * upravuje vypis pri chybejicich hodnotach
     *
     * @return
     */
    public String toStringKoef() {
        if (nNakazenych == -1) {
            return String.format("%-24s%-20s%-20s%-20s", name, messege, messege, messege);
        } else if (getKoefNadeje() == Integer.MAX_VALUE) {
            return String.format("%-24s%-20d%-20d%-20s", name, nVylecenych, nNakazenych, "Inf");
        } else if (nNakazenych == 0) {
            return String.format("%-24s%-20d%-20d%-20s", name, nVylecenych, nNakazenych, messege);
        }
        String koef = String.format("%.2f", getKoefNadeje());
        return String.format("%-24s%-20d%-20d%-20s", name, nVylecenych, nNakazenych, koef);
    }

    /**
     * Metoda pocita, kolik dni byl/je kraj v karantene.
     *
     * @return
     */
    public long karantenaLength() {
        if (startKarant == null) {
            return 0;
        }
        long duration = DAYS.between(startKarant, endKarant);
        return duration;
    }

}
