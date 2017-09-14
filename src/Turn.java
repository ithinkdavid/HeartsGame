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
        Card decision = null;
        int maxValue = 0;
        for(Card card : this.currentPlayer.Hand){
            if (card.getIntValue() > maxValue){
                maxValue = card.getIntValue();
                decision = card;
            }
        }
        return decision;
    }

    //Lowest winning heart
    //Lowest losing heart
    //Lowest card
    private Card DecideHeartsCard(){
        Card winningHeart = null;
        Card losingHeart = null;
        Card lowestCard = null;
        int minWinningHeartValue = 15;
        int minLosingHeartValue = 15;
        int minCardValue = 15;
        for (Card card : this.currentPlayer.Hand){
            if(card.getSuit() == Suit.HEARTS){
                if(card.getIntValue() > this.currentWinner.getIntValue()){
                    if(card.getIntValue() < minWinningHeartValue){
                        minCardValue = card.getIntValue();
                        winningHeart = card;
                    }
                }
                else{
                    if(card.getIntValue() < minLosingHeartValue){
                        minLosingHeartValue = card.getIntValue();
                        losingHeart = card;
                    }
                }
            }
            if(card.getIntValue() < minCardValue){
                minCardValue = card.getIntValue();
                lowestCard = card;
            }
        }
        if(winningHeart != null){
            return winningHeart;
        }
        if(losingHeart != null){
            return losingHeart;
        }
        return lowestCard;
    }

    //Lowest winning suit
    //Lowest losing suit
    //Lowest heart
    //Lowest card
    private Card DecideNonHeartsCard(){
        Card winningSuit = null;
        Card losingSuit = null;
        Card lowestHeart = null;
        Card lowestCard = null;
        int minWinningSuitValue = 15;
        int minLosingSuitValue = 15;
        int minHeartValue = 15;
        int minCardValue = 15;
        for(Card card : this.currentPlayer.Hand){
            if(card.getSuit() == this.roundSuit){
                if(card.getIntValue() > this.currentWinner.getIntValue()){
                    if(card.getIntValue() < minWinningSuitValue){
                        minWinningSuitValue = card.getIntValue();
                        winningSuit = card;
                    }
                }
                else{
                    if(card.getIntValue() < minLosingSuitValue){
                        minLosingSuitValue = card.getIntValue();
                        losingSuit = card;
                    }
                }
            }
            if(card.getSuit() == Suit.HEARTS){
                if(card.getIntValue() < minHeartValue){
                    minHeartValue = card.getIntValue();
                    lowestHeart = card;
                }
            }
            if(card.getIntValue() < minCardValue){
                minCardValue = card.getIntValue();
                lowestCard = card;
            }
        }
        if(winningSuit != null){
            return winningSuit;
        }
        if(losingSuit != null){
            return losingSuit;
        }
        if(lowestHeart != null){
            return lowestHeart;
        }
        return lowestCard;
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
