package fr.iutvalence.mounieju.memory.IHM_firststep;


public class Controller implements Runnable
{
	/** Controller's access game's view. */
	private Memory memory;
	/** Controller's access game's model. */
	private Board board;

	
	public Board getBoard()
	{
		return board;
	}

	/**
	 * Method to control the chosen difficulty.
	 * @param diff: chosen difficulty.
	 */
	public void initParty(int diff)
	{
		if (diff == 1)
		{
			board = new Board(2, 2);
			memory.initParty(2,2);
		} else
		{
			board = new Board(4, 4);
			memory.initParty(4, 4);
		}
	}

	@Override
	public void run()
	{
		memory = new Memory(this);
	}

	public void flip(int i, int j, CardButton cardButton)
	{
		// Partie traitement.
		board.flip(i, j);
		cardButton.cardButtonFlip(this.getBoard().get(i, j).getDesign().getDisplay());
	}
}
