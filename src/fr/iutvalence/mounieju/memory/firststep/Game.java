package fr.iutvalence.mounieju.memory.firststep;

import java.util.Scanner;


/** Build the game
 * 
 * @author liottara */

public class Game
{
	private Board gameBoard;
	private Scanner sc;
	
	private static final int MAX_PAIR = 2;
	private int nb_pair;
	


	
	
	/**
	 * Create the new board
	 */
	public Game()
	{
		sc = new Scanner(System.in);
		this.gameBoard = new Board();
	}


	
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
		  	
			//Flip first Card
			System.out.println("Card 1 : Input card's x position");
		    int firstCardXPosi = sc.nextInt();
			System.out.println("Card 1 : Input card's y position");
		    int firstCardYPosi = sc.nextInt();	    
		    Card card1 = gameBoard.flipCard(firstCardXPosi,firstCardYPosi);
		    
		    //Flip second Card
		  	System.out.println("Card 2 : Input card's x position");
		  	int secondCardXPosi = sc.nextInt();
		  	System.out.println("Card 2 : Input card's y position");
		  	int secondCardYPosi = sc.nextInt();	    
		  	Card card2 = gameBoard.flipCard(secondCardXPosi,secondCardYPosi);
		  	
		  	//If the card is already turned over
			if (card1.identical)
	  			gameBoard.flipCard(firstCardXPosi,firstCardYPosi);
		  	if (card2.identical)
		  		gameBoard.flipCard(secondCardXPosi,secondCardYPosi); 
		  	
		  	
		  	
		  	//Display the board after returning the cards
		  	System.out.println(gameBoard);

		  	//If cards are different
		  	if (!(card1.identical) && !(card2.identical))
		  	{
		  		
		  	
			  	//Compare the two selected Cards
			  	if (!gameBoard.sameCard(card1,card2))
				{

					gameBoard.flipCard(firstCardXPosi, firstCardYPosi);
					gameBoard.flipCard(secondCardXPosi, secondCardYPosi);

					// Display the after flip cards (if they are different)
					System.out.println(gameBoard);
				}
		  		
			  	else 
			  	{
			  		//Compare if coordinates of cards are identical
			  		if ((firstCardXPosi == secondCardXPosi) && (firstCardYPosi == secondCardYPosi))
				  		System.out.println("You can't flip 2 identical cards");
			  		
			  		//If this is not the case , that the cards are identical and increments the number of pair
			  		else
			  		{
			  			card1.identicalCard();
			  			card2.identicalCard();
			  						  			
			  			nb_pair++;			  		
			  		}
				 
		  		
			  	}
		
			}
		  	
		  	//If cards are identicals
		  	else
		  	{
		  		if (card1.identical)
		  			gameBoard.flipCard(secondCardXPosi,secondCardYPosi);
			  	if (card2.identical)
			  		gameBoard.flipCard(firstCardXPosi,firstCardYPosi); 
			  	
			  	//Display the after flip cards (if they are different)
			  	System.out.println(gameBoard);
		  	}
		  		

		  	//If the number of pair is the maximum the game finish
		  	if (nb_pair == MAX_PAIR)
		  	{
		  		victory = true;
		  		System.out.println("Fin du jeu");
		  	}
		  		
		}	
		
	}
	
}

