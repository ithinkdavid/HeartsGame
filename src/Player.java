import java.util.HashSet;

public class Player {
    public HashSet<Card> Hand;
    private int id;

    public int getId(){
        return this.id;
    }

    public Player(int id){
        this.id = id;
    }
}
