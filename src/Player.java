import java.util.HashSet;

public class Player {
    public HashSet<Card> Hand;
    private int id;
    private int score = 0;
    private boolean human = false;

    public int getId(){
        return this.id;
    }

    public int getScore(){
        return this.score;
    }

    public void addScore(){
        score += 1;
    }

    public boolean IsHuman(){
        return this.human;
    }

    public Player(int id, boolean human){
        this.human = human;
        this.id = id;
    }
}
