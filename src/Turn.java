import java.util.LinkedList;

// Represents the available information for a player in a single turn
public class Turn {
    private Card[] cardsInPlay;
    private Suit roundSuit;
    private int numberOfCards;
    private Player currentPlayer;
    private Card currentWinner;

    public Card[] PlayCard(){
        ProcessCards(this.cardsInPlay);
        if(this.currentPlayer.IsHuman()){
            this.cardsInPlay[this.numberOfCards] = AskPlayer();
        }
        else{
            this.cardsInPlay[this.numberOfCards] = DecideCard();
        }
        return this.cardsInPlay;
    }

    private Card AskPlayer(){
        return null;
    }

    // Work out current winner
    // Winning card of same suit? Play lowest winner
    // Play lowest heart
    // If not play lowest card of suit
    // Play lowest card (not hearts)
    // Iterate to find these cards, play card which isn't null in order above
    private Card DecideCard(){
        Card decision;
        if(this.numberOfCards == 0){
            decision = DecideFirstCard();
        }
        else{
            if(this.currentWinner.getSuit() == Suit.HEARTS){
                decision = DecideHeartsCard();
            }
            else{
                decision = DecideNonHeartsCard();
            }
        }
        this.currentPlayer.Hand.remove(decision);
        return decision;
    }

    //Find highest value card
    private Card DecideFirstCard(){
        return null;
    }

    //Lowest winning heart
    //Lowest losing heart
    //Lowest card
    private Card DecideHeartsCard(){
        return null;
    }

    //Lowest winning suit
    //Lowest losing suit
    //Lowest heart
    //Lowest card
    private Card DecideNonHeartsCard(){
        return null;
    }

    private Card CurrentWinner(){
        int maxvalue = 0;
        int winner = -1;
        boolean hearts = this.roundSuit == Suit.HEARTS;
        for(int i = 0; i < this.numberOfCards; i++){
            if(hearts){
                if(this.cardsInPlay[i].getSuit() == Suit.HEARTS){
                    if(this.cardsInPlay[i].getIntValue() > maxvalue){
                        maxvalue = this.cardsInPlay[i].getIntValue();
                        winner = i;
                    }
                }
            }
            else{
                if(this.cardsInPlay[i].getSuit() == Suit.HEARTS){
                    maxvalue = this.cardsInPlay[i].getIntValue();
                    hearts = true;
                    winner = i;
                }
                else{
                    if(this.cardsInPlay[i].getSuit() == roundSuit){
                        if(this.cardsInPlay[i].getIntValue() > maxvalue){
                            maxvalue = this.cardsInPlay[i].getIntValue();
                            winner = i;
                        }
                    }
                }
            }
        }
        return this.cardsInPlay[winner];
    }

    private void ProcessCards(Card [] cardList){
        if (cardList[0] == null) {
            this.roundSuit = null;
            this.numberOfCards = 0;
        }
        else {
            this.roundSuit = cardList[0].getSuit();
            int count = 1;
            while((count < cardList.length)&&(cardList[count] != null)){
                count += 1;
            }
            this.numberOfCards = count;
        }
    }

    public Turn (Card[] cardsInPlay, Player currentPlayer){
        this.cardsInPlay = cardsInPlay;
        this.currentPlayer = currentPlayer;
    }
}
