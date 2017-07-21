import java.util.Scanner;
public abstract class Player
{
    protected CardPile hand;
    protected CardPile taken;
    protected int points;

    public Player()
    {
      this.hand = new CardPile();
      this.taken = new CardPile();
      this.points = 0;
    }
    
    public boolean containsCard(Card c)
    {
      return this.hand.containsCard(c);
    }

    public int countPoints()
    {
      int totalPoints = 0;
      //check for all of the hearts
      for (Value v : Value.values())
       {
         if (taken.containsCard(new Card(Suit.HEARTS, v)))
           {
             totalPoints++;
           }
       }
       if (taken.containsCard(new Card(Suit.SPADES, Value.QUEEN)))
       {
         totalPoints += 13;
       }

    return totalPoints;
    }

    public void addPoints(int update)
    {
      this.points += update;
    }

    public int getPoints()
    {
      return this.points;
    }

    public void takeCards(CardPile cards)
    {
    Card top = cards.removeCard(0);
    while (top != null)
      {
       this.taken.addToBottom(top);
       top = cards.removeCard(0);
      }
    }

    public void dealCardTo(Card card)
    {
      this.hand.addToBottom(card);
    }

    abstract public Card playLegalMove(CardPile currentTrick);

    public void redeal()
    {
      this.hand.clear();
      this.taken.clear();
    }
}