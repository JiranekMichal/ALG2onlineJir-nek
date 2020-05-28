package utils;

/**
 * Pomocna trida k trid TextToBinary
 *
 * @author Michal Jiránek
 */
class Kraj2 {

    private String name;
    private int nNak;
    private int nHos;
    private int nVyl;

    public Kraj2(String name, int nNak, int nHos, int nVyl) {
        this.name = name;
        this.nNak = nNak;
        this.nHos = nHos;
        this.nVyl = nVyl;
    }

    public String getName() {
        return name;
    }

    public int getnNak() {
        return nNak;
    }

    public int getnHos() {
        return nHos;
    }

    public int getnVyl() {
        return nVyl;
    }

}
