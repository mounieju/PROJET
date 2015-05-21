package fr.iutvalence.mounieju.memory.IHM_firststep;
import java.util.Scanner;

/** 
 * Class for the game.
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 4
 */

public class Game
{
	//////////////// Attributes //////////////////////////////////////////////////////

	/** Constant: total number of pairs by default in the game. */
	private static int MAX_PAIR;

	/** Define a game with board and scanner. */
	private Board gameBoard;
	private Scanner sc;
	
	/** Define counter of moves by player. */
	private int numberStrokes;
	/** Define number of pairs found by player. */
	private int nb_pair;

	
	////////////////// Constructor //////////////////////////////////////////////////////

	/** Create the new game */
	public Game()
	{
		/* Define 2 levels of difficulty. */  
		int difficulty;
		sc = new Scanner(System.in);
		/* Asks for difficulty. */
		System.out.println("Choose a level: 1 for 'Easy', 2 for 'Hard' ");
		difficulty = sc.nextInt();
		/* Deals with input errors. */
		while (difficulty != 1 && difficulty !=2)
		{
			System.err.printf("Level doesn't exist%n");
			System.out.printf("Choose a level: 1 for 'Easy', 2 for 'Hard'%n");
			difficulty = sc.nextInt();
		}
		/* Creates little board on 'Easy' mode. */
		if (difficulty == 1)
		{
			this.gameBoard = new Board();
			MAX_PAIR = 2;
		}
		/* Creates bigger board on 'Hard' mode. */
		if (difficulty == 2)
		{
			this.gameBoard = new Board(4,4);
			MAX_PAIR = 8;
		}		
	}
	

	////////////////// Method ////////////////////////////////////////////////////////

	/** Method to start the game */
	public void start()
	{
		/* Define victory state. */
		boolean victory = false;
		/* Displays board */
		System.out.println(gameBoard);

		while (!victory)
		{
			/* Choose first card. */
			
			int firstCardXPosi;
			int firstCardYPosi;
			boolean input1;
			Card card1 = null;

			do
			{
				input1 = true;
				/* Asks for first card. */
				System.out.printf("Card 1 : Input card's x position%n");
				firstCardXPosi = sc.nextInt();
				System.out.printf("Card 1 : Input card's y position%n");
				firstCardYPosi = sc.nextInt();
				
				/* Deals with input errors. */
				try
				{
					card1 = gameBoard.get(firstCardXPosi, firstCardYPosi);
				} 
				catch (ArrayIndexOutOfBoundsException e)
				{
					input1 = false;
				}
			} while (!input1);
			
			/* Case 1: card 1 already revealed. */
			if (!card1.isHidden())
			{
				System.err.printf("%nCard 1 already found, choose another one%n");
				continue;
			}
			
			/* Case 2: card 1 OK to flip. */
			gameBoard.flip(firstCardXPosi, firstCardYPosi);
			System.out.println(gameBoard);
			
			
			/* Choose second card. */

			int secondCardXPosi;
			int secondCardYPosi;
			boolean input2;
			Card card2 = null;

			do
			{
				input2 = true;
				/* Asks for second card. */
				System.out.printf("Card 2 : Input card's x position%n");
				secondCardXPosi = sc.nextInt();
				System.out.printf("Card 2 : Input card's y position%n");
				secondCardYPosi = sc.nextInt();
				
				/* Deals with input errors. */
				try
				{
					card2 = gameBoard.get(secondCardXPosi, secondCardYPosi);
				} 
				catch (ArrayIndexOutOfBoundsException e)
				{
					input2 = false;
				}
			} while (!input2);
			
			/* Case 1: card 2 same as card 1, returns over card 1. */
			if ((firstCardXPosi == secondCardXPosi) && (firstCardYPosi == secondCardYPosi))
			{
				System.err.printf("You can't choose the same card twice%n%n");
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				continue;
			}

			/* Case 2: card 2 already revealed, returns over card 1. */ 
			if (!card2.isHidden())
			{
				System.err.printf("Card 2 already found, restart choosing your cards%n%n");
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				continue;
			}

			/* Case 3: card 2 OK to flip. */
			System.out.printf("%nOK%n%n");
			gameBoard.flip(secondCardXPosi, secondCardYPosi);
			System.out.println(gameBoard);
			

			/* Compare card 1 & card 2. */

			/* Case 1: card 1 different from card 2, increments number of strokes played. */
			if (!card1.equals(card2))
			{
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				gameBoard.flip(secondCardXPosi, secondCardYPosi);
				System.out.printf("%nCards not matching, try again!%n%n");
				numberStrokes ++;

				/* Displays board after comparison. */
				System.out.println(gameBoard);
				continue;
			}

			/* Case 2: card 1 identical to card 2, revealed, increments number of pairs found & of strokes played. */
			nb_pair++;
			System.out.println("Pair found, good job!");
			numberStrokes++;
			/* Displays board after comparison. */
			System.out.println(gameBoard);
			

			/* Case all pairs found: end of game. */
			if (nb_pair == MAX_PAIR)
			{
				victory = true;
				System.out.printf("Game Over, You won%n%n");
				System.out.println("Number of strokes: "+numberStrokes);
			}

		}

	}

}
