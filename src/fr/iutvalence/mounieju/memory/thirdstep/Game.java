package fr.iutvalence.mounieju.memory.thirdstep;

import java.util.Scanner;

/** Build the game
 * 
 * @author liottara */

public class Game
{
	// //////////////// Attributes
	// //////////////////////////////////////////////////////

	/** Constant: total number of pairs by default in the game. */
	private static int MAX_PAIR;

	/** Define a game with board and scanner. */
	private Board gameBoard;
	private Scanner sc;
	

	/** Variable having the player's score. */
	private int nb_pair;

	// //////////////////Constructor
	// //////////////////////////////////////////////////////

	/** Create the new game */
	public Game()
	{
		int difficulty;
		
		sc = new Scanner(System.in);
		System.out.println("Choose a level: 1 for 'Easy', 2 for 'Hard");
		difficulty = sc.nextInt();
		
		if (difficulty == 1)
		{
			this.gameBoard = new Board();
			MAX_PAIR = 2;
		}
		
		if (difficulty == 2)
		{
			this.gameBoard = new Board(4,4);
			MAX_PAIR = 8;
		}

		
		
		
	}

	// ////////////////// Methods
	// ////////////////////////////////////////////////////////

	/** Method to start the game */
	public void start()
	{
		boolean victory = false;

		// Display the board at the beginning
		System.out.println(gameBoard);

		while (!victory)
		{
			// Choose first Card
			
			int firstCardXPosi;
			int firstCardYPosi;
			boolean input1;
			Card card1 = null;

			do
			{
				input1 = true;

				System.out.printf("Card 1 : Input card's x position%n");
				firstCardXPosi = sc.nextInt();
				System.out.printf("Card 1 : Input card's y position%n");
				firstCardYPosi = sc.nextInt();

				
				try
				{
					card1 = gameBoard.get(firstCardXPosi, firstCardYPosi);
				} 
				catch (ArrayIndexOutOfBoundsException e)
				{
					input1 = false;
				}
			} while (!input1);
			

			// If card 1 already revealed
			if (!card1.isHiden())
			{
				System.err.printf("%nCard 1 already found, choose another one%n");
				continue;
			}

			System.out.printf("%nOK%n%n");
			gameBoard.flip(firstCardXPosi, firstCardYPosi);
			System.out.println(gameBoard);
			

			// Choose second Card

			int secondCardXPosi;
			int secondCardYPosi;
			boolean input2;
			Card card2 = null;

			do
			{
				input2 = true;

				System.out.printf("Card 2 : Input card's x position%n");
				secondCardXPosi = sc.nextInt();
				System.out.printf("Card 2 : Input card's y position%n");
				secondCardYPosi = sc.nextInt();
				
				try
				{
					card2 = gameBoard.get(secondCardXPosi, secondCardYPosi);
				} 
				catch (ArrayIndexOutOfBoundsException e)
				{
					input2 = false;
				}
			} while (!input2);

			// If card 2 same as card 1, returns over the first card
			if ((firstCardXPosi == secondCardXPosi) && (firstCardYPosi == secondCardYPosi))
			{
				System.err.printf("You can't choose the same card twice%n%n");
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				continue;
			}

			// If card 2 already revealed, returns over the first card
			if (!card2.isHiden())
			{
				System.err.printf("Card 2 already found, restart choosing your cards%n%n");
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				continue;
			}

			// Else flip card
			System.out.printf("%nOK%n%n");
			gameBoard.flip(secondCardXPosi, secondCardYPosi);
			System.out.println(gameBoard);

			// If cards are still hidden, comparison of the two selected cards

			// If different, flip them back
			if (!card1.equals(card2))
			{
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				gameBoard.flip(secondCardXPosi, secondCardYPosi);
				System.out.printf("%nCards not matching, try again!%n%n");

				// Display the board after the comparison
				System.out.println(gameBoard);
				continue;
			}

			// If cards are identical, reveal cards & increments the number of pairs
			nb_pair++;
			System.out.println("Pair found, good job!");
			// Display the board after the comparison
			System.out.println(gameBoard);

			// If all pairs found, end of game
			if (nb_pair == MAX_PAIR)
			{
				victory = true;
				System.out.println("Game Over, You won");
			}

		}

	}

}
