public class Game {
    private Deck gameDeck;
    private Player[] players;

    public Player Play(){
        Deal(players);
        Round(new Player[] {players[0], players[1], players[2], players[3]});
        Round(new Player[] {players[1], players[2], players[3], players[0]});
        Round(new Player[] {players[2], players[3], players[0], players[1]});
        Round(new Player[] {players[3], players[0], players[1], players[2]});
        Round(new Player[] {players[0], players[1], players[2], players[3]});
        Round(new Player[] {players[1], players[2], players[3], players[0]});
        Round(new Player[] {players[2], players[3], players[0], players[1]});
        return FindWinner();
    }

    public Player FindWinner(){
        int max = 0;
        Player winner = null;
        for(int i = 0; i < 4; i++){
            if(players[i].getScore() > max){
                max = players[i].getScore();
                winner = players[i];
            }
        }
        return winner;
    }

    public void Deal(Player[] playersToDeal){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                playersToDeal[i].Hand.add(gameDeck.DealCard());
            }
        }
    }

    public void Round(Player[] roundPlayers){
        Card[] cardsInPlay = new Card[] {null, null, null, null};
        Turn currentTurn;
        for(int i = 0; i < 4; i++) {
            currentTurn = new Turn(cardsInPlay, roundPlayers[i]);
            cardsInPlay = currentTurn.PlayCard();
        }
        int winner = WinnerOfRound(cardsInPlay, cardsInPlay[0].getSuit());
        roundPlayers[winner].addScore();
    }

    public int WinnerOfRound(Card[] cardsInPlay, Suit roundSuit){
        int maxvalue = 0;
        int winner = -1;
        boolean hearts = roundSuit == Suit.HEARTS;
        for(int i = 0; i < cardsInPlay.length; i++){
            if(hearts){
                if(cardsInPlay[i].getSuit() == Suit.HEARTS){
                    if(cardsInPlay[i].getIntValue() > maxvalue){
                        maxvalue = cardsInPlay[i].getIntValue();
                        winner = i;
                    }
                }
            }
            else{
                if(cardsInPlay[i].getSuit() == Suit.HEARTS){
                    maxvalue = cardsInPlay[i].getIntValue();
                    hearts = true;
                    winner = i;
                }
                else{
                    if(cardsInPlay[i].getSuit() == roundSuit){
                        if(cardsInPlay[i].getIntValue() > maxvalue){
                            maxvalue = cardsInPlay[i].getIntValue();
                            winner = i;
                        }
                    }
                }
            }
        }
        return winner;
    }



    public Game(Player player1, Player player2, Player player3, Player player4){
        this.gameDeck = new Deck();
        this.players = new Player[] {player1, player2, player3, player4};
    }
}
