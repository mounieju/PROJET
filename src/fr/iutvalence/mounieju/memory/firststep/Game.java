package fr.iutvalence.mounieju.memory.firststep;

import java.util.Scanner;


/** Build the game
 * 
 * @author liottara */

public class Game
{
	////////////////// Attributes //////////////////////////////////////////////////////

    /** Constant: total number of pairs by default in the game. */
	private static final int MAX_PAIR = 2;
	
	/** Constant string to have a line separator. */
	private static final String lineBreak = System.getProperty("line.separator");
	
    /** Define a game with board and scanner. */
	private Board gameBoard;
	private Scanner sc;
	
    /** Variable having the player's score.  */
	private int nb_pair;
	
	
    ////////////////////Constructor //////////////////////////////////////////////////////	
	
	/**
	 * Create the new game
	 */
	public Game()
	{
		sc = new Scanner(System.in);
		this.gameBoard = new Board();
	}
	

    //////////////////// Methods ////////////////////////////////////////////////////////
	
	/**
	 * Method to start the game
	 */
	public void start() 
	{
		boolean victory = false;
		
		//Display the board at the beginning
		System.out.println(gameBoard);
	
		
		while (!victory) 
		{
		  	
			//Choose first Card
			
			System.out.println(lineBreak+"Card 1 : Input card's x position");
		    int firstCardXPosi = sc.nextInt();
			System.out.println(lineBreak+"Card 1 : Input card's y position");
		    int firstCardYPosi = sc.nextInt();	    
		    Card card1 = gameBoard.getCard(firstCardXPosi, firstCardYPosi);
		    
		    
		    //If card 1 already revealed
		    if (!card1.getView())
		    	System.out.println(lineBreak+"Card 1 already found, choose another one");
		   
		    
		    //Else flip card
		    else
		    {
		    	System.out.println(lineBreak+"OK");
		    	gameBoard.flipCard(firstCardXPosi,firstCardYPosi);
		    	
		    //Choose second Card
		    	
		    	System.out.println(lineBreak+"Card 2 : Input card's x position");
			  	int secondCardXPosi = sc.nextInt();
			  	System.out.println(lineBreak+"Card 2 : Input card's y position");
			  	int secondCardYPosi = sc.nextInt();	    
			  	Card card2 =  gameBoard.getCard(secondCardXPosi,secondCardYPosi);
			  	
			  	
			  	//If card 2 same as card 1, returns over the first card
			  	if ((firstCardXPosi == secondCardXPosi) && (firstCardYPosi == secondCardYPosi))
			  	{
			  		System.out.println(lineBreak+"You can't choose the same card twice");
			  		gameBoard.flipCard(firstCardXPosi,firstCardYPosi);
			  	}
			  	
			    //If card 2 already revealed, returns over the first card
			  	else if (!card2.getView())
			  	{
			  		System.out.println(lineBreak+"Card 2 already found, restart choosing your cards");
			  		gameBoard.flipCard(firstCardXPosi,firstCardYPosi);
			  	}
			  	
			  	//Else flip card
			  	else
			  	{
			  		System.out.println(lineBreak+"OK");
			  		gameBoard.flipCard(secondCardXPosi,secondCardYPosi);
			  		
			  	//If cards are still hidden, comparison of the two selected cards
			  		
			  		//If different, flip them back
				  	if (!gameBoard.sameCard(card1,card2))
					{
						gameBoard.flipCard(firstCardXPosi, firstCardYPosi);
						gameBoard.flipCard(secondCardXPosi, secondCardYPosi);
						System.out.println(lineBreak+"Cards not matching, try again!");

						// Display the board after the comparison
						System.out.println(gameBoard);
					}
			  		
				  //If cards are identical, reveal cards & increments the number of pairs
				  	else 
				  	{			
				  			nb_pair++;
				  			System.out.println(lineBreak+"Pair found, good job!");
				  			
				  		// Display the board after the comparison
							System.out.println(gameBoard);
				  	}
					 
			  		
				  }
			
				}
	

		  	//If all pairs found, end of game
		  	if (nb_pair == MAX_PAIR)
		  	{
		  		victory = true;
		  		System.out.println(lineBreak+"Game Over, You won");
		  	}
		  		
		}	
		
	}
	
}

