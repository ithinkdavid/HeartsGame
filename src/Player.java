import java.util.HashSet;

public class Player {
    public HashSet<Card> Hand;
    private int id;
    private int score = 0;

    public int getId(){
        return this.id;
    }

    public int getScore(){
        return this.score;
    }

    public void addScore(){
        score += 1;
    }

    public Player(int id){
        this.id = id;
    }
}
