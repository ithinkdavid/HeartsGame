/*
 * A class to represent a single playing card.
 *
 * @author David McArthur
 */
public class Card {
    private Suit cardSuit;
    private Value cardValue;

    public Card(Suit cardSuit, Value cardValue){
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public Suit getSuit(){
        return cardSuit;
    }

    public Value getValue(){
        return cardValue;
    }
}
