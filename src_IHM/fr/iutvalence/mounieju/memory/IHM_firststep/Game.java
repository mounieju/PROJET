package fr.iutvalence.mounieju.memory.IHM_firststep;


/** 
 * Class for the game.
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 1 (IHM)
 */

public class Game
{
	//////////////// Attributes //////////////////////////////////////////////////////

	/** Constant: total number of pairs by default in the game. */
	private static int MAX_PAIR;

	/** Define a game with board and game entries / outputs. */
	private Board gameBoard;
	private GameInputs gameInputs;
	private GameOutputs gameOutputs;
	
	/** Define counter of moves by player. */
	private int numberStrokes;
	/** Define number of pairs found by player. */
	private int nb_pair;

	
	////////////////// Constructor //////////////////////////////////////////////////////

	/** Create the new game */
	public Game()
	{
		/* Define 2 levels of difficulty. */  
		/* Asks for difficulty. */
		this.gameInputs = new GameInputs();
		
		/* Creates little board on 'Easy' mode. */
		if (this.gameInputs.getDifficulty() == 1)
		{
			this.gameBoard = new Board();
			MAX_PAIR = 2;
			this.gameOutputs= new GameOutputs(this.gameBoard.toString()); 
		}
		
		/* Creates bigger board on 'Hard' mode. */
		if (this.gameInputs.getDifficulty() == 2)
		{
			this.gameBoard = new Board(4,4);
			MAX_PAIR = 8;
			this.gameOutputs= new GameOutputs(this.gameBoard.toString());
		}		
	}
	

	////////////////// Method ////////////////////////////////////////////////////////

	/** Method to start the game */
	public void start()
	{
		/* Define victory state. */
		boolean victory = false;
		/* Displays board */
		GameOutputs.getOut(this.gameBoard.toString()); 

		while (!victory)
		{
			/* Choose first card. */
			boolean input1;
			int firstCardXPosi;
			int firstCardYPosi;
			Card card1 = null;
			
			do
			{
				input1 = true;
				/* Asks for first card. */
				firstCardXPosi = this.gameInputs.askXPosi();
				firstCardYPosi = this.gameInputs.askYPosi();
				
				/* Deals with input errors. */
				try
				{
					card1 = gameBoard.get(firstCardXPosi, firstCardYPosi);  
				} 
				catch (ArrayIndexOutOfBoundsException e)
				{
					input1 = false;
					this.gameOutputs.doesCardExist(input1);
				}
			} while (!input1);
			 
		
			/* Case 1: card 1 already revealed. */
			if (this.gameOutputs.isCardForeFound(card1))
			{
				continue;
			}
			
			/* Case 2: card 1 OK to flip. */
			gameBoard.flip(firstCardXPosi, firstCardYPosi);
			GameOutputs.getOut(gameBoard.toString());
			
			
			/* Choose second card. */

			boolean input2;
			int secondCardXPosi;
			int secondCardYPosi;
			Card card2 = null;				
			
			do
			{
				input2 = true;
				/* Asks for first card. */
				secondCardXPosi = this.gameInputs.askXPosi();
				secondCardYPosi = this.gameInputs.askYPosi();
				
				/* Deals with input errors. */
				try
				{
					card2 = gameBoard.get(secondCardXPosi, secondCardYPosi);  
				} 
				catch (ArrayIndexOutOfBoundsException e)
				{
					input2 = false;
					this.gameOutputs.doesCardExist(input2);
				}
			} while (!input2);
			
			
			/* Case 1: card 2 same as card 1, returns over card 1. */
			if (this.gameOutputs.isSameCard(firstCardXPosi, firstCardYPosi, secondCardXPosi, secondCardYPosi))
			{
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				continue;
			}

			/* Case 2: card 2 already revealed, returns over card 1. */ 
			if (this.gameOutputs.isCardForeFound(card2))
			{
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				continue;
			}

			/* Case 3: card 2 OK to flip. */
			gameBoard.flip(secondCardXPosi, secondCardYPosi);
			GameOutputs.getOut(gameBoard.toString());
			

			/* Compare card 1 & card 2. */

			/* Case 1: card 1 different from card 2, increments number of strokes played. */
			if (!this.gameOutputs.areAPair(card1, card2))
			{
				gameBoard.flip(firstCardXPosi, firstCardYPosi);
				gameBoard.flip(secondCardXPosi, secondCardYPosi);
				numberStrokes ++;

				/* Displays board after comparison. */
				GameOutputs.getOut(gameBoard.toString());
				continue;
			}

			/* Case 2: card 1 identical to card 2, revealed, increments number of pairs found & of strokes played. */
			nb_pair++;
			numberStrokes++;
			/* Displays board after comparison. */
			GameOutputs.getOut(gameBoard.toString());
			

			/* Case all pairs found: end of game. */
			if (this.gameOutputs.isGameOver(nb_pair, MAX_PAIR, numberStrokes))
			{
				victory = true;

			}

		}

	}

}
