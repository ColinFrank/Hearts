# Hearts
Implementing the card game Hearts

----------------------------------------------------------------------------------------------------------------------------------------
McGILL HEARTS

The code in Hearts.java, Card.java, and CardPile.java were created by myself in conjunction with the remaining classes to complete an assignment for COMP-202B at McGill University.

The purpose was to use object oriented programming to build up the final game.

----------------------------------------------------------------------------------------------------------------------------------------
RUNNING

To run the program, open Hearts.java in a compiler such as DrJava or Eclipse. Once compiled, run the program and enter integers only into the user interface (if anything but an integer is input a java.util.InputMismatchException will be thrown). If you input an illegal move, say you try to play a seven of hearts when the suite is diamonds, the program will loop back and reprompt your move.

----------------------------------------------------------------------------------------------------------------------------------------
PROPOSED TASK

You will implement the standard version of hearts with two exceptions:
	1.	Players will not pass cards before each round starts. 
	2.	The player who holds the two of clubs will still start each hand, but he/she is not required to play the two of clubs. 

----------------------------------------------------------------------------------------------------------------------------------------
RULES OF HEARTS

The game of Hearts is a card game played by exactly 4 players with a standard set of playing cards. Every card has a suit and a value. Each card has 4 possibilities for its suit (hearts, clubs, diamonds, or spades) and 13 possibilities for its value (ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king). When these possibilities are paired together, there are 52 possible cards.
The object of hearts is to have the lowest score of any player. Players get points by taking certain cards during the course of play. Points are tallied at the end of each hand and the game ends when at least one player reaches 100 points. Since the goal is to avoid points, players generally try to avoid taking these cards. (See exception related to ”shooting the moon” below.)
The game play is as follows:

	1.	At the beginning of each hand, all 52 cards are shuffled and dealt so that each player has 13 cards. Under standard playing rules, the players then exchange cards, but for simplicity, it is not required that you implement this feature. 
	
	2.	The first turn in each round goes to the player who holds the 2 of clubs. In our version, the player holding the 2 of clubs can play any card in his or her hand
	
	3.	Play continues in a clockwise fashion until each player has played 1 card. The rules for what constitutes a legal play are below. The player with the highest card of the four played based on the rules below then takes these four cards and puts them aside in a separate pile next to him/her. This is known as winning a trick. These cards will be used later when the scoring occurs.
	
	4.	Whoever wins a particular trick starts play for the next trick, also known as leading. Since each player has 13 cards to start and plays one card in each trick, there are 13 tricks per deal.
	
	5.	The rules of choosing which card to play are as follows: 
	.	(a)  If you are leading for a trick (i.e. playing the first card in a trick), you may play any card from your hand. 
	.	(b)  If you are NOT leading and you have a card with the same suit as the card that was led in that trick, then you MUST play a card from that suit. For example, if the card led was a club, and you have a club in your hand, then you MUST play a club. Remember that it is the suit of the card led and NOT the suit of the card played immediately before you. 
	.	(c)  If you are NOT leading and you do NOT have a card with the same suit as the card that was led in that trick, then you may play any card that you want. 
	.	(d)  The winner of a trick, who takes all 4 cards, is the player who has the highest card IN THE SUIT THAT WAS LED. Note that Ace is higher than King which is higher than Queen, which is higher than Jack, which is higher than ten, and so on. 
	.	(e)  Generally, since the goal is to avoid getting points and you get points by taking specific cards, players try to avoid taking a trick. There are cases, however, when it is more useful to have control of play by starting than to avoid taking the trick.
	
	6.	After each player plays 13 cards, scoring works as follows: 
	.	(a)  Each player who took a card with the suit of Hearts gets one point for every heart they took. 
	.	(b)  The player who took the Queen of Spades gets 13 points. 
	.	(c)  There is one exception to the above two rules called “shooting the moon.” If a player takes EVERY Heart AND the Queen of Spades, then rather than getting 26 points, each other player gets 26 points. (Remember that the goal is to have the fewest points so this is advantageous.) 

