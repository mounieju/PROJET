package fr.iutvalence.mounieju.memory.firststep;

import java.util.Scanner;

/** Build the game
 * 
 * @author liottara */

public class Game
{
	private Board gameBoard;
	private Scanner sc;
	

	
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
		  	
		  	
		  	//Display the board after returning the cards
		  	System.out.println(gameBoard);
		  	
		  	//Compare the two selected Cards
		  	if (!gameBoard.sameCard(card1,card2) /*&& (card1 != this.card1OK) && (card2 != this.card2OK)*/)
			{
		  		gameBoard.flipCard(firstCardXPosi,firstCardYPosi);
			  	gameBoard.flipCard(secondCardXPosi,secondCardYPosi);

			  	//Display the after flip cards (if they are different)
			  	System.out.println(gameBoard);
			}

		  	
		  	/**
			 * If the player can flip 2 identical cards
			 */
		  	if ((firstCardXPosi == secondCardXPosi) && (firstCardYPosi == secondCardYPosi))
		  		System.out.println("You can't flip 2 identical cards");
		 
		  		
		}
	}
}

