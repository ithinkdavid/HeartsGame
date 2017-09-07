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
        return this.cardSuit;
    }

    public Value getValue(){
        return this.cardValue;
    }

    public int getIntValue(){ return this.cardValue.toInt(); }
}
