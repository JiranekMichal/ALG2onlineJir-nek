
package pkg02.pkg09.elevengame;

import java.util.Scanner;

/**
 *
 * @author Michal Jiránek
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static BoardInterface board;
    
    public static void main(String[] args) {
        System.out.println("********************** " + board.getName() + " **********************");
        //vytvořit balíček
        board.makeDeck();
        //zamíchat balíček
        board.shuffelCards();
        //vytáhnout karty - vymazat je z balíčku
        board.drawCards();
        displayCards();
        displayDeck();
        while(board.isAnotherPlayPossible()){ // jeste jsou v balicku karty A existuje JQK nebo sum11
            System.out.println("Vyber karty:");
            String[] selectedCardsPositions = sc.nextLine().split(" +");//jedna nebo více mezer - regulární výraz
            if(!board.playAndReplace(selectedCardsPositions)){
                System.out.println("Nevalidni tah");
            }else{
                displayCards();
                displayDeck();
            }
        }
        if(board.hasWon()){
            System.out.println("Gratuluji");
        }else{
            System.out.println("Nelze hrat");
        }
    }

    private static void displayCards() {
        for (int i = 0; i < board.nCards(); i++) {
            System.out.format("%1d. %20s ", i+1, board.getCardDescriptionAt(i));
            if((i+1)%3==0){
                System.out.println("");
            }
        }
    }

    private static void displayDeck() {
        System.out.println("V balicku je " + board.getDeckSize() + " karet.");
    }
    
}
