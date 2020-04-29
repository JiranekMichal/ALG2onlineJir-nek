
package pkg02.pkg09.elevengame;

import static java.lang.Integer.parseInt;
import java.util.Collections;

/**
 *
 * @author Michal Jiránek
 */
public class Board implements BoardInterface{
    Card[] cards; //9 karet na stole
    Deck deck; //balicek karet
    
    
    @Override
    public void makeDeck() {
        deck.deckCards.add(new Card("kary", "A", 1));
        deck.deckCards.add(new Card("kary", "2", 2));
        deck.deckCards.add(new Card("kary", "3", 3));
        deck.deckCards.add(new Card("kary", "4", 4));
        deck.deckCards.add(new Card("kary", "5", 5));
        deck.deckCards.add(new Card("kary", "6", 6));
        deck.deckCards.add(new Card("kary", "7", 7));
        deck.deckCards.add(new Card("kary", "8", 8));
        deck.deckCards.add(new Card("kary", "9", 9));
        deck.deckCards.add(new Card("kary", "10", 10));
        deck.deckCards.add(new Card("kary", "J", 0));
        deck.deckCards.add(new Card("kary", "Q", 0));
        deck.deckCards.add(new Card("kary", "K", 0));
        
        deck.deckCards.add(new Card("piky", "A", 1));
        deck.deckCards.add(new Card("piky", "2", 2));
        deck.deckCards.add(new Card("piky", "3", 3));
        deck.deckCards.add(new Card("piky", "4", 4));
        deck.deckCards.add(new Card("piky", "5", 5));
        deck.deckCards.add(new Card("piky", "6", 6));
        deck.deckCards.add(new Card("piky", "7", 7));
        deck.deckCards.add(new Card("piky", "8", 8));
        deck.deckCards.add(new Card("piky", "9", 9));
        deck.deckCards.add(new Card("piky", "10", 10));
        deck.deckCards.add(new Card("piky", "J", 0));
        deck.deckCards.add(new Card("piky", "Q", 0));
        deck.deckCards.add(new Card("piky", "K", 0));
        
        deck.deckCards.add(new Card("srdce", "A", 1));
        deck.deckCards.add(new Card("srdce", "2", 2));
        deck.deckCards.add(new Card("srdce", "3", 3));
        deck.deckCards.add(new Card("srdce", "4", 4));
        deck.deckCards.add(new Card("srdce", "5", 5));
        deck.deckCards.add(new Card("srdce", "6", 6));
        deck.deckCards.add(new Card("srdce", "7", 7));
        deck.deckCards.add(new Card("srdce", "8", 8));
        deck.deckCards.add(new Card("srdce", "9", 9));
        deck.deckCards.add(new Card("srdce", "10", 10));
        deck.deckCards.add(new Card("srdce", "J", 0));
        deck.deckCards.add(new Card("srdce", "Q", 0));
        deck.deckCards.add(new Card("srdce", "K", 0));
        
        deck.deckCards.add(new Card("listy", "A", 1));
        deck.deckCards.add(new Card("listy", "2", 2));
        deck.deckCards.add(new Card("listy", "3", 3));
        deck.deckCards.add(new Card("listy", "4", 4));
        deck.deckCards.add(new Card("listy", "5", 5));
        deck.deckCards.add(new Card("listy", "6", 6));
        deck.deckCards.add(new Card("listy", "7", 7));
        deck.deckCards.add(new Card("listy", "8", 8));
        deck.deckCards.add(new Card("listy", "9", 9));
        deck.deckCards.add(new Card("listy", "10", 10));
        deck.deckCards.add(new Card("listy", "J", 0));
        deck.deckCards.add(new Card("listy", "Q", 0));
        deck.deckCards.add(new Card("listy", "K", 0));
        
    }
    
    @Override
    public String getName() {
        return "Hra jedenactka";
    }
    
    @Override
    public void shuffelCards() {
        Collections.shuffle(deck.deckCards);
    }
    
    @Override
    public void drawCards() {
        int cardsLength = 9;
        for (int i = 0; i < cardsLength; i++) {
            cards[i] = deck.deckCards.get(i);
        }
    }


    @Override
    public int nCards() {
        return cards.length;
    }

    @Override
    public int getDeckSize() {
        return deck.getDeckSize();
    }
    
    @Override
    public String getCardDescriptionAt(int index){
        return cards[index].getSymbol() + cards[index].getValue();
    }

    @Override
    public boolean isAnotherPlayPossible() {//je na stole JQK nebo soucet 11 A jsou ještě v balicku karty?
        return is11() || isJQK();
    }

    @Override
    public boolean playAndReplace(String[] selectedCardsPositions) {//hra..je 11? souhlasí, líznout další atd.
        //read
        if (selectedCardsPositions.length > 3 || selectedCardsPositions.length < 2){
            return false;
        }
        if (selectedCardsPositions.length == 3){
            boolean isJ = false;
            boolean isQ = false;
            boolean isK = false;
            for (int i = 0; i < selectedCardsPositions.length; i++) {
                if(cards[i].getValue() == "J"){
                    isJ = true;
                }
                if(cards[i].getValue() == "Q"){
                    isQ = true;
                }
                if(cards[i].getValue() == "K"){
                    isK = true;
                }
                if(isJ && isQ && isK){
                    moveCards(selectedCardsPositions);
                    return true;
                }
            }
            return false;
        }
        if (selectedCardsPositions.length == 2){
            if(cards[parseInt(selectedCardsPositions[0])-1].getnPoints() + cards[parseInt(selectedCardsPositions[1])-1].getnPoints() != 11){
                return false;
            }
            moveCards(selectedCardsPositions);
            return true;
        }
        return false;
        
    }
    
    private void moveCards(String [] selectedCardsPositions){
        for (int i = 0; i < selectedCardsPositions.length ; i++) {
            if(deck.getDeckSize() > 0){
                cards[parseInt(selectedCardsPositions[i])-1] = deck.deckCards.get(0);
                deck.deckCards.remove(0);
            }else{
                cards[parseInt(selectedCardsPositions[i])-1] = new Card("","",0);
            }
        }
    }

    @Override
    public boolean hasWon() {
        if(deck.getDeckSize() == 0 && cards.length == 0){
            return true;
        }else{
            return false;    
        }
    }


    private boolean is11() {
        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = i; j < cards.length; j++) {
                if(cards[i].getnPoints()!=0 && cards[j].getnPoints()!=0){
                    int soucet = cards[i].getnPoints() + cards[j].getnPoints();
                    if(soucet == 11){
                        return true;
                    }
                }
                
            }
        }
        return false;
    }

    private boolean isJQK() {
        boolean isJ = false;
        boolean isQ = false;
        boolean isK = false;
        for (int i = 0; i < cards.length; i++) {
            if(cards[i].getValue() == "J"){
                isJ = true;
            }
            if(cards[i].getValue() == "Q"){
                isQ = true;
            }
            if(cards[i].getValue() == "K"){
                isK = true;
            }
            if(isJ && isQ && isK){
                return true;
            }
        }
        return false;
    }

    

    
}
