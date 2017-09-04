import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private int last;
    private Card [] Cards;

    // Get random item from array, then to delete swap with array[last] and last -= 1
    // This way it is O(1)
    public Card DealCard(){
        int index = ThreadLocalRandom.current().nextInt(0,this.last + 1);
        Card out = this.Cards[index];
        this.Cards[index] = this.Cards[this.last];
        this.last -= 1;
        return out;
    }

    public Deck(){
        this.last = 51;
        this.Cards = new Card[] {new Card(Suit.CLUBS, Value.TWO),
                new Card(Suit.CLUBS, Value.THREE),
                new Card(Suit.CLUBS, Value.FOUR),
                new Card(Suit.CLUBS, Value.FIVE),
                new Card(Suit.CLUBS, Value.SIX),
                new Card(Suit.CLUBS, Value.SEVEN),
                new Card(Suit.CLUBS, Value.EIGHT),
                new Card(Suit.CLUBS, Value.NINE),
                new Card(Suit.CLUBS, Value.TEN),
                new Card(Suit.CLUBS, Value.JACK),
                new Card(Suit.CLUBS, Value.QUEEN),
                new Card(Suit.CLUBS, Value.KING),
                new Card(Suit.CLUBS, Value.ACE),
                new Card(Suit.HEARTS, Value.TWO),
                new Card(Suit.HEARTS, Value.THREE),
                new Card(Suit.HEARTS, Value.FOUR),
                new Card(Suit.HEARTS, Value.FIVE),
                new Card(Suit.HEARTS, Value.SIX),
                new Card(Suit.HEARTS, Value.SEVEN),
                new Card(Suit.HEARTS, Value.EIGHT),
                new Card(Suit.HEARTS, Value.NINE),
                new Card(Suit.HEARTS, Value.TEN),
                new Card(Suit.HEARTS, Value.JACK),
                new Card(Suit.HEARTS, Value.QUEEN),
                new Card(Suit.HEARTS, Value.KING),
                new Card(Suit.HEARTS, Value.ACE),
                new Card(Suit.DIAMONDS, Value.TWO),
                new Card(Suit.DIAMONDS, Value.THREE),
                new Card(Suit.DIAMONDS, Value.FOUR),
                new Card(Suit.DIAMONDS, Value.FIVE),
                new Card(Suit.DIAMONDS, Value.SIX),
                new Card(Suit.DIAMONDS, Value.SEVEN),
                new Card(Suit.DIAMONDS, Value.EIGHT),
                new Card(Suit.DIAMONDS, Value.NINE),
                new Card(Suit.DIAMONDS, Value.TEN),
                new Card(Suit.DIAMONDS, Value.JACK),
                new Card(Suit.DIAMONDS, Value.QUEEN),
                new Card(Suit.DIAMONDS, Value.KING),
                new Card(Suit.DIAMONDS, Value.ACE),
                new Card(Suit.SPADES, Value.TWO),
                new Card(Suit.SPADES, Value.THREE),
                new Card(Suit.SPADES, Value.FOUR),
                new Card(Suit.SPADES, Value.FIVE),
                new Card(Suit.SPADES, Value.SIX),
                new Card(Suit.SPADES, Value.SEVEN),
                new Card(Suit.SPADES, Value.EIGHT),
                new Card(Suit.SPADES, Value.NINE),
                new Card(Suit.SPADES, Value.TEN),
                new Card(Suit.SPADES, Value.JACK),
                new Card(Suit.SPADES, Value.QUEEN),
                new Card(Suit.SPADES, Value.KING),
                new Card(Suit.SPADES, Value.ACE),};
    }
}
