import java.util.Random;

public class CardPile
{ 
    private static Random r = new Random(1);
    //from now on, you can generate random integers
    //via r.nextInt(int n);
    //e.g. random integer from 0 until 10, including 0 and 10:
    //r.nextInt(11);

// This section is for testing purposes.
  public static void main (String[] args) {
    
    
  }

  //This is where the main program begins
  
  private Card[] cards;
  private int numCards;
  
  public CardPile()
  {
    cards = new Card[52];
    numCards = 0;
  }
  
  public void addToBottom (Card c)
  {
    for (int i = 0; i < 52; i++) {
      if (cards[i] == null) {
        cards[i] = c;
        i = 52; //gets us out of the loop
        numCards++;
      }
    }
  }
  
  public Card removeCard (int index)
  {
    if (cards[index] != null) numCards = (numCards - 1);
    
    Card selectedCard = cards[index];
    cards[index] = null;
    for (int i = 0; i < 51; i++) {
      if (cards[i] == null) {
        cards[i] = cards[(i+1)];
        cards[(i+1)] = null;
      }
      
    }
    return selectedCard;
  }
  
  public boolean isEmpty()
  {
    if (numCards == 0) return true;
    else return false;
  }
  
  public void clear()
  {
    for (int i = 0; i < 52; i++)
    {
      cards[i] = null;
    }
    numCards = 0;
  }
   
  
  public int getNumCards()
  {
    return numCards;
  }
  
  public Card peak(int i)
  {
    return cards[i];
  }
  
  public boolean containsCard(Card c)
  {
    for (int i = 0; i < 52; i++)
    {
      if (cards[i] == null) return false; 
      if (cards[i].equals(c)) return true;
    }
      return false;
  }
  
  public boolean containsSuit(Suit suit)
  {
    for (int i = 0; i < 52; i++)
    {
      Card compare = cards[i];
      if (compare != null) {
       if (compare.getSuit() == suit) return true;
     }
    }
      return false;
  }
    
  public String toString()
  {
    String allTheCards = "";
    int a = 0;
    for (int i = 0; i < 52; i++)
    {
      if (cards[i] != null)
      {
        allTheCards = allTheCards + a + "." + cards[i] + " ";
      }
    a++;
    }
    return allTheCards;
  }
  
  public void shuffle()
  {
    Card[] placeHolder = new Card[52];
    Card[] switchArray = new Card[52];
    Card placei, placej;
    for (int loop = 0; loop < 10001; loop++)
    {
      int i, j;
      i = r.nextInt(52);
      j = r.nextInt(52);
      //switchArray[i] = 
      
      placei = cards[i];
      placej = cards[j];
      
      cards[i] = placej;
      cards[j] = placei;
    }
  }
  
  public static CardPile makeFullDeck ()
  {
    CardPile decks = new CardPile();
    Card momentCard;
    for (int i = 0; i < 52; i++)
    {
      for (Suit s : Suit.values())
      {
        for (Value t : Value.values())
        {
          momentCard = new Card(s,t);
          decks.addToBottom(momentCard);
        }
      }
    }
    decks.shuffle();
    return decks;
  }
}