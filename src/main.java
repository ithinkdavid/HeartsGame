public class main {


    public static void announcePlay(Player player, Card card){
        System.out.print("Player " + player.getId() + " plays " + card.toString() + "\n");
    }

    public static void showCardsInPlay(Card[] cards){
        String message = "Cards in play:\n";
        int count = 0;
        while ((count < cards.length)&&(cards[count] != null)){
            message += cards[count].toString() + "\n";
            count += 1;
        }
        if (count == 0){
            message += "None\n";
        }
        System.out.print(message);
    }

    public static void showPlayerHand(Player player){
        String message = "Your Hand:\n";
        for (Card card : player.Hand){
            message += card.toString() +"\n";
        }
    }
}



