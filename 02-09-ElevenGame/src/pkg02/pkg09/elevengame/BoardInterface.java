
package pkg02.pkg09.elevengame;

/**
 *
 * @author Michal Jiránek
 */
public interface BoardInterface {

    public String getName();
    
    public int nCards();

    public int getDeckSize();
    
    public String getCardDescriptionAt(int index); 
   
    public boolean isAnotherPlayPossible();

    public boolean playAndReplace(String[] selectedCardsPositions);

    public boolean hasWon();

}
