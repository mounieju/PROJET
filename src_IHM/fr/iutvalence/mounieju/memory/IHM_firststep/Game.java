package fr.iutvalence.mounieju.memory.IHM_firststep;


/** 
 * Class for the game.
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 2
 */

public class Game
{
	//////////////// Attributes //////////////////////////////////////////////////////

	/** Constant: total number of pairs by default in the game. */
	private static int MAX_PAIR;

	/** Define a game with board and game entries / outputs. */
	private Board gameBoard;

	/**Define a game with a controller. */
	private Controller controller;
	
	/** Define counter of moves by player. */
	private int numberStrokes;
	/** Define number of pairs found by player. */
	private int nb_pair;
	/** Define attributes to remember the two selected cards to compare after */ 
	private Position posi1;
	private Card card1;
	private Position posi2;
	private Card card2;
	private CardButton button1;


	
	////////////////// Constructor //////////////////////////////////////////////////////

	/** Create the new game */
	public Game(int diff, Controller controller)
	{
		/* Define 2 levels of difficulty. */		
		/* Creates little board on 'Easy' mode. */
		if (diff == 1)
		{
			this.gameBoard = new Board();
			MAX_PAIR = 2;
		}
		
		/* Creates bigger board on 'Hard' mode. */
		if (diff == 2)
		{
			this.gameBoard = new Board(4,4);
			MAX_PAIR = 8;
		}
		
		this.controller = controller;
	}
	
	
    //////////////////// Getters & setters ////////////////////////////////////////////////////////

	/**
	 * Get the game board.
	 * @return gameBoard: the actual game board.
	 */
	public Board getGameBoard()
	{
		return gameBoard;
	}

	
	////////////////// Methods ////////////////////////////////////////////////////////
	
	/**
	 * Method to store two selected cards to compare after. 
	 * @param posi: position of the card.
	 * @param button: the clicked button.
	 */
	public void cardReturn(Position posi, CardButton button){
		// Storing the first card.
		if(this.posi1==null){
			this.posi1 = posi;		
			this.card1 = this.gameBoard.get(posi);
			this.button1 = button;
		}
		// Storing the second card.
		else {
			this.posi2 = posi;		
			this.card2 = this.gameBoard.get(posi);
			// Comparing the two cards.
			// If same, disables button cards and locks visibility.
			if(card1.equals(card2)){
				this.nb_pair ++;
				this.numberStrokes ++;
				this.button1.setEnabled(false);
				button.setEnabled(false);
				//Checks if game finished.
				if(this.checkWin()){
					System.out.println("FIN DE PARTI");
					System.out.printf("Number of strokes: %d", numberStrokes);

					System.exit(0);
				}
				// Else enables them and hides them.
			}else {
				this.button1.setText("");
				button.setText("");
				
				this.button1.setEnabled(true);
				this.button1 = null;
				button.setEnabled(true);
				this.numberStrokes ++;

			}
			// "Cleans" the memory of the two previously selected cards to have room for others. 
			this.posi1=null;
		}

	}
	
	
	/**
	 * Method to check if game over.
	 * @return boolean (true : game over,  false: not).
	 */
	public boolean checkWin(){
		return (this.nb_pair == MAX_PAIR);
	}
	
	
	/** Method to start the game 
	 * @throws InterruptedException */
	public void start() throws InterruptedException
	{
		/* Define victory state. */
		boolean victory = false;

		while (!victory)
		{
			/* Choose first card. */
			boolean input1;
			Card card1 = null;			
			
			do
			{
				input1 = true;
				/* Asks for first card. */
				while(this.controller.getPosLastButton()==null){
					Thread.sleep(1000);
				}
				System.out.println("ok");
				Position posi1 = this.controller.getPosLastButton();
				card1.setPosi(posi1);
				
			} while (!input1);
				
			/* Case 1: card 1 already revealed. */
			// Buttons disabled so no risks
			
			/* Choose second card. */

			boolean input2;
			Card card2 = null;				
			
			do
			{
				input2 = true;
				/* Asks for first card. */
				while(this.controller.getPosLastButton()==null){

					Thread.sleep(100);

					System.out.println("non");
				}
				System.out.println("ok");
				Position posi2 = this.controller.getPosLastButton();
				card2.setPosi(posi2);
				
				/* Deals with input errors. */
				try
				{
					card2 = gameBoard.get(posi2);  
				} 
				catch (ArrayIndexOutOfBoundsException e)
				{
					input2 = false;
				//	this.gameOutputs.doesCardExist(input2);
				}
			} while (!input2);
			
			
			/* Case 1: card 2 same as card 1, returns over card 1. */
			// Card disabled after clicking so no risks.

			/* Case 2: card 2 already revealed, returns over card 1. */ 
			// Buttons disabled so no risks


			/* Case 3: card 2 OK to flip. */
			gameBoard.flip(card2.getPosition());
			

			/* Compare card 1 & card 2. */

			/* Case 1: card 1 different from card 2, increments number of strokes played. */
			if (!this.controller.areAPair(card1, card2))
			{
				gameBoard.flip(card1.getPosition());
				gameBoard.flip(card2.getPosition());
				numberStrokes ++;
				continue;
			}

			/* Case 2: card 1 identical to card 2, revealed, increments number of pairs found & of strokes played. */
			nb_pair++;
			numberStrokes++;
			

			/* Case all pairs found: end of game. */
			if (this.checkWin())
			{
				victory = true;

			}

		}

	}


}
