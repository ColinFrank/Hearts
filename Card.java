public class Card
{
  private Suit suit;
  private Value value;
  
  public Card (Suit theSuit, Value theValue)
  {
    suit = theSuit;
    value = theValue;
  }
  
  public Suit getSuit ()
  {
    return suit;
  }
  public Value getValue ()
  {
    return value;
  }
  
  public String toString()
  {
    String resultant = (value.toString() + " of " + suit.toString());
    return resultant;  
  }
  
  public boolean equals (Card other)
  {
    if (other.suit == this.suit && other.value == this.value)
      {
        return true;
      }
    else return false;
  }
  
}