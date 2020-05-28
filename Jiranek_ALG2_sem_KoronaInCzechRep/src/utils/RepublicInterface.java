package utils;

import java.io.IOException;

/**
 * Interface tridy Republic
 *
 * @author Michal Jiránek
 */
public interface RepublicInterface {

    public void load(String kraje, String statistika, String karantena) throws IOException;

    public void save(String filename) throws IOException;

    public String getKrajeInfo();

    public String sortByNakazenych();

    public String sortByNakazPomer();

    public String sortByDnyKaran();

    public String sortByObyvatel();

    public String sortByHosp();

    public String sortByVylec();

    public String sortByKoef();

    public String getKrajInfo(String name);

}
