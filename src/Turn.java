import java.util.LinkedList;

// Represents the available information for a player in a single turn
public class Turn {
    private Card[] cardsInPlay;
    private Player currentPlayer;

    public Card[] PlayCard(){
        return null;
    }

    public Turn (Card[] cardsInPlay, Player currentPlayer){
        this.cardsInPlay = cardsInPlay;
        this.currentPlayer = currentPlayer;
    }
}
