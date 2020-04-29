
package pkg02.pkg09.elevengame;

/**
 *
 * @author Michal Jiránek
 */
public class Card {
    private String symbol;
    private String value;
    private int nPoints; //A-1, J,Q,K-0;

    public Card(String symbol, String value, int nPoints) {
        this.symbol = symbol;
        this.value = value;
        this.nPoints = nPoints;
    }

    
    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public int getnPoints() {
        return nPoints;
    }
    
    
}
