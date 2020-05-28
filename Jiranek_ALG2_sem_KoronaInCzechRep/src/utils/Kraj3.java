package utils;

/**
 * Pomocna trida k trid TextToBinary
 *
 * @author Michal Jiránek
 */
class Kraj3 {

    private String name;
    private String karStart;
    private String karEnd;

    public Kraj3(String name, String karStart, String karEnd) {
        this.name = name;
        this.karStart = karStart;
        this.karEnd = karEnd;
    }

    public String getName() {
        return name;
    }

    public String getKarStart() {
        return karStart;
    }

    public String getKarEnd() {
        return karEnd;
    }

}
