package fr.iutvalence.mounieju.memory.firststep;

import java.util.Scanner;

/** Build the game
 * 
 * @author liottara */

public class Game
{
	private Board gameBoard;
	private Scanner sc;

	public Game()
	{
		sc = new Scanner(System.in);
		gameBoard = new Board();
	}

	public void start() {
		boolean victory = false;
		while (!victory) {
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
	  	
	  	//Compare the two selected Cards
	  	if (!gameBoard.sameCard(card1,card2))
		    {
	  		gameBoard.flipCard(firstCardXPosi,firstCardYPosi);
		  	gameBoard.flipCard(secondCardXPosi,secondCardYPosi);
		    }
	}
}
