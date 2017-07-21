public class Hearts
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to McGill Hearts!");
    Player[] players = new Player[4];
    
    //The following code creates 4 players. In this case I've 
    //created one human player and three computer players. Each player can
    //have methods called on them.
    
    players[0] = new HumanPlayer();
    players[1] = new ComputerPlayer();
    players[2] = new ComputerPlayer();
    players[3] = new ComputerPlayer();
    
    //1)
    //hasOneHundred will determine when we stop the game. 
    //At the end of each turn we evaluate whether 100 points has been passed.
    
    boolean hasOneHundred = false;
    
    while (!hasOneHundred)
    {
      
      //execute one deal of a hand
      
      CardPile deck = new CardPile();
      deck = deck.makeFullDeck();
      deck.shuffle();
      
      //2) To deal the cards we run a for loop:
      
      for (int k = 0; k < 13; k++)
      {
        players[0].dealCardTo(deck.removeCard(0));
        players[1].dealCardTo(deck.removeCard(0));
        players[2].dealCardTo(deck.removeCard(0));
        players[3].dealCardTo(deck.removeCard(0));
      }
      
      //3)
      //Here we figure out who has the 2 of clubs by making a card called theTwo. 
      //theTwo is compared to each player's hand, and that player is given the first turn.
      //This is also printed to the screen.
      
      int turn = 4;
      Card theTwo = new Card(Suit.SPADES, Value.TWO);
      for (int j = 0; j <= 3; j++)
      {
        if (players[j].hand.containsCard(theTwo))
        {
          turn = j;
        }
      }
      System.out.println("Player " + turn + " begins this round.");
      
      //4)
      //The following for loop contains two nested loops. The first has each 
      //player play a card. The second determines who won the round. Finally the trick 
      //and the winner are printed to the screen.
      
      CardPile whatsOnTable = new CardPile();
      Card nextPlay;
      int[] storesOrder = new int[4];
      
      for (int z = 0; z < 13; z++)
      {
        
        //5
        //The following for loop executes a round where every player plays a card.
        
        for (int j = 0; j <= 3; j++)
        {
         nextPlay = players[turn].playLegalMove(whatsOnTable);
         whatsOnTable.addToBottom(nextPlay);
         storesOrder[j] = turn;
         turn++;
         if (turn == 4) turn = 0;
        }
        
        //6
        //This next for loop determines who won the set of 4 cards.
        
        int winner = 0;
        int t = 3;
        Card winningCard = whatsOnTable.peak(0);
        
        for (int j = 0; j <= 2; j++)
        {
          if (whatsOnTable.peak(t).getSuit() == winningCard.getSuit()) //Note: whatsOnTable[0] is the first card played, thus it decides the suit.
          {
            if (whatsOnTable.peak(t).getValue().ordinal() > winningCard.getValue().ordinal())
            {
              winningCard = whatsOnTable.peak(t);
              winner = t; //Note: this is not the player number, but the players order number who won.
            }
          }
          t -= 1;
        }
        
        System.out.println('\n' + "The trick contained " + whatsOnTable.toString());
        System.out.println("Player " + storesOrder[winner] + " won this trick." + '\n');
        
        //7)
        //The player who won receives the set of 4 cards. It is now this player's turn.
        
        players[storesOrder[winner]].takeCards(whatsOnTable);
        turn = storesOrder[winner];
      
      }
      
      //8
      //The following checks to see if 100 points has been passed. Should it happen, hasOneHundred
      //is set to true, and the while loop is terminated.
      
      int countPoints;
      for (int x = 0; x < 4; x++)
      {
        countPoints = players[x].countPoints();
        players[x].addPoints(countPoints);
        
        System.out.println("Player " + x + " has " + players[x].getPoints() + " points.");
        if (players[x].getPoints() > 100)
        {
          hasOneHundred = true;
        }
      }
     }
    
  //9
  //This determines who won by figuring out who has the lowest number of points.
  //That player is then printed to the screen as The Ultimate Winner.
    
    int ultimateWinner = 11; 
    for (int x = 0; x < 4; x++)
     {
       for (int y = 0; y < 4; y++)
       {
         if (players[x].getPoints() < players[y].getPoints())
         {
           ultimateWinner = x;
         }
       }
     }
    System.out.println('\n' + "The Ultimate Winner is ... Player " + ultimateWinner);
    
  }
}
