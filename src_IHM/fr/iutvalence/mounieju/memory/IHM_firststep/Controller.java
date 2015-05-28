package fr.iutvalence.mounieju.memory.IHM_firststep;

/**
 * Class for the controller of the game.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 2
 */
public class Controller implements Runnable
{
	////////////////// Attributes //////////////////////////////////////////////////////

	/** Controller's access game's view. */
	private Memory memory;
	/** Controller's access game's model. */
	private Board board;
	private Game game;
	/** Position of the last clicked button */
	private Position posLastButton = null;

	
    //////////////////// Getters & setters ////////////////////////////////////////////////////////

	/**
	 * Get the board.
	 * @return Board: current board.
	 */
	public Board getBoard()
	{
		return board;
	}
	
	
	/**
	 * Get the last clicked button.
	 * @return posLastButton: position of the last clicked button.
	 */
	public Position getPosLastButton()
	{
		return this.posLastButton;
	}
	
    //////////////////// Method ////////////////////////////////////////////////////////


	/**
	 * Method to control the chosen difficulty.
	 * @param diff: chosen difficulty.
	 */
	public void initParty(int diff)
	{
		if (diff == 1)
		{
			game = new Game(1, this);
			memory.initParty(2,2);
		} else
		{
			game = new Game(2, this);
			memory.initParty(4, 4);
		}
		this.board = game.getGameBoard();

	}

	@Override
	public void run()
	{
		memory = new Memory(this);
	}

	/**
	 * Method to flip cards.
	 * @param posi: position of the card on board.
	 * @param cardButton: card's button referred to.
	 */
	public void flip(Position posi, CardButton cardButton)
	{
		// Partie traitement.
		game.getGameBoard().flip(posi);
		System.out.println(board); 
		// Partie IHM.
		cardButton.cardButtonFlip(this.getBoard().get(posi).getDesign().getDisplay());
		cardButton.setEnabled(false);
	}
	
	/**
	 * Method to compare cards.
	 * @param card1: first chosen card.
	 * @param card2: second chosen card.
	 */
	public boolean areAPair(Card card1, Card card2)
	{
		if (!card1.equals(card2))
		{
			System.out.printf("Cards not matching, try again!%n");
			return false;
		}
		
		System.out.println("Pair found, good job!");
		return true;
	}
	
	
	/**
	 * Method to initialize game card position as card button's position.
	 * @param posi: position of clicked button.
	 * @param cardbutton: last clicked button.
	 */
	public void posLastButton(Position posi,CardButton button)
	{
		game.cardReturn(posi,button);
	}



}
