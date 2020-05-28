package utils;

import app.Kraj;
import java.util.Comparator;

/**
 * Tato trida obsahuje nastroje na trideni kraju
 *
 * @author Michal Jiránek
 */
public class Comparators {

    public static Comparator<Kraj> NAKAZ = new Comparator<Kraj>() {
        @Override
        public int compare(Kraj o1, Kraj o2) {
            if (o1.getnNakazenych() < o2.getnNakazenych()) {
                return 1;
            } else if (o1.getnNakazenych() == o2.getnNakazenych()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public static Comparator<Kraj> NAKAZPERCENT = new Comparator<Kraj>() {
        @Override
        public int compare(Kraj o1, Kraj o2) {
            if (o1.getPomerNakaz() < o2.getPomerNakaz()) {
                return 1;
            } else if (o1.getPomerNakaz() == o2.getPomerNakaz()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public static Comparator<Kraj> KARAN = new Comparator<Kraj>() {
        @Override
        public int compare(Kraj o1, Kraj o2) {
            if (o1.karantenaLength() < o2.karantenaLength()) {
                return 1;
            } else if (o1.karantenaLength() == o2.karantenaLength()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public static Comparator<Kraj> POCOB = new Comparator<Kraj>() {
        @Override
        public int compare(Kraj o1, Kraj o2) {
            if (o1.getnObyvatel() < o2.getnObyvatel()) {
                return 1;
            } else if (o1.getnObyvatel() == o2.getnObyvatel()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public static Comparator<Kraj> POCHOSP = new Comparator<Kraj>() {
        @Override
        public int compare(Kraj o1, Kraj o2) {
            if (o1.getnHospital() < o2.getnHospital()) {
                return 1;
            } else if (o1.getnHospital() == o2.getnHospital()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public static Comparator<Kraj> POCVYLEC = new Comparator<Kraj>() {
        @Override
        public int compare(Kraj o1, Kraj o2) {
            if (o1.getnVylecenych() < o2.getnVylecenych()) {
                return 1;
            } else if (o1.getnVylecenych() == o2.getnVylecenych()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public static Comparator<Kraj> KOEF = new Comparator<Kraj>() {
        @Override
        public int compare(Kraj o1, Kraj o2) {
            if (o1.getKoefNadeje() < o2.getKoefNadeje()) {
                return 1;
            } else if (o1.getKoefNadeje() == o2.getKoefNadeje()) {
                return 0;
            } else {
                return -1;
            }
        }
    };
}
