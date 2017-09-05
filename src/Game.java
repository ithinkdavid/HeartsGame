public class Game {
    private Deck gameDeck;
    private Player[] players;

    public void Play(){
        Deal(players);
        Round(players[0], players[1], players[2], players[3]);
        Round(players[1], players[2], players[3], players[0]);
        Round(players[2], players[3], players[0], players[1]);
        Round(players[3], players[0], players[1], players[2]);
        Round(players[0], players[1], players[2], players[3]);
        Round(players[1], players[2], players[3], players[0]);
        Round(players[2], players[3], players[0], players[1]);
    }

    public void Deal(Player[] playersToDeal){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                playersToDeal[i].Hand.add(gameDeck.DealCard());
            }
        }
    }

    public void Round(Player player1, Player player2, Player player3, Player player4){
        Card[] cardsInPlay = new Card[] {null, null, null, null};
        Turn currentTurn = new Turn(cardsInPlay, player1);
        cardsInPlay = currentTurn.PlayCard();
        currentTurn = new Turn(cardsInPlay, player2);
        cardsInPlay = currentTurn.PlayCard();
        currentTurn = new Turn(cardsInPlay, player3);
        cardsInPlay = currentTurn.PlayCard();
        currentTurn = new Turn(cardsInPlay, player4);
        currentTurn.PlayCard();
    }

    public Game(Player player1, Player player2, Player player3, Player player4){
        this.gameDeck = new Deck();
        this.players = new Player[] {player1, player2, player3, player4};
    }
}
