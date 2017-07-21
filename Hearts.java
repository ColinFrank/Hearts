public class Hearts
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to McGill Hearts!");
    Player[] players = new Player[4];
    
    //The following code creates 4 players. In this case I've 
    //created two human players and two computer players. Each player can
    //have methods called on them.
    
    players[0] = new HumanPlayer();
    players[1] = new HumanPlayer();
    players[2] = new ComputerPlayer();
    players[3] = new ComputerPlayer();
    
    //1)
    //hasOneHundred will determine when we stop the game. 
    //At the end of each turn we evaluate whether 100 points has been passed.
    
    boolean hasOneHundred = false;
    
    while (!hasOneHundred)
    {
      CardPile deck = new CardPile();      //execute one deal of a hand
      deck = deck.makeFullDeck();
      deck.shuffle();
      
      for (int k = 0; k < 13; k++)       //1)Deal the cards
      {
        players[0].dealCardTo(deck.removeCard(0));
        players[1].dealCardTo(deck.removeCard(0));
        players[2].dealCardTo(deck.removeCard(0));
        players[3].dealCardTo(deck.removeCard(0));
      }
      
      //2)
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
      
      //3) Let each player play one card in a predefined order
      
      CardPile whatsOnTable = new CardPile();
      Card nextPlay;
      int[] storesOrder = new int[4];
      
      //6)If players still have cards remaining, go back to step 3, otherwise count the score of each player.
      
      for (int z = 0; z < 13; z++)
      {
        for (int j = 0; j <= 3; j++)
        {
         nextPlay = players[turn].playLegalMove(whatsOnTable);
         whatsOnTable.addToBottom(nextPlay);
         storesOrder[j] = turn;
         turn++;
         if (turn == 4) turn = 0;
        }
        
       //4)
        //This determines who won the set of 4 cards.
        
        int winner = 0;
        int t = 3;
        Card winningCard = whatsOnTable.peak(0);
        
        for (int j = 0; j <= 2; j++)
        {
          if (whatsOnTable.peak(t).getSuit() == winningCard.getSuit()) //whatsOnTable[0] is the first card played, thus decides the suit)
          {
            if (whatsOnTable.peak(t).getValue().ordinal() > winningCard.getValue().ordinal())
            {
              winningCard = whatsOnTable.peak(t);
              winner = t; //Note: this is not the player number, but the players order number who won.
            }
          }
          t -= 1;
        }
        
        System.out.println("The trick contained " + whatsOnTable.toString());
        System.out.println("Player " + storesOrder[winner] + " won this trick." + '\n');
        players[storesOrder[winner]].takeCards(whatsOnTable);      //5)Give to the player who won the set of 4 cards all four cards. It is now this player's turn.
        turn = storesOrder[winner];
      
      }
      
      //The following checks to see if 100 points has been passed. Should it happen, hasOneHundred is set to true,
      //and the while loop is terminated.
      
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
