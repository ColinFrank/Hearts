public class ComputerPlayer extends Player
{
  public Card playLegalMove(CardPile currentTrick)
  {
    //search for the first legal move we can make in our hand
    for (int i = 0; i < this.hand.getNumCards(); i++)
    {
      Card current = this.hand.peak(i);
      if (currentTrick.isEmpty() || currentTrick.peak(0).getSuit() == current.getSuit() || !this.hand.containsSuit(currentTrick.peak(0).getSuit()))
      {
        this.hand.removeCard(i);
        return current;
      }
    }
  return null;
  }
}