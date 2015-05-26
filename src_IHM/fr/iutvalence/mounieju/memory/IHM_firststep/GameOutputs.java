package fr.iutvalence.mounieju.memory.IHM_firststep;

public class GameOutputs 
{
	//////////////// Attributes //////////////////////////////////////////////////////

	private String display;
	
	
	//////////////////Constructor //////////////////////////////////////////////////////
	
	public GameOutputs(String string)   
	{  
		this.display = string;  
	}  


	////////////////// Method ////////////////////////////////////////////////////////
	
	/**	 
	 * Display a string  
	 * @param string get the board's representation in ASCII art  
	 */  
	public static void getOut(String string)   
	{  
		System.out.println(string);  
	}  


	public void doesCardExist(boolean input)
	{
		if(input == false)
			System.err.printf("%nCard doesn't exist, choose another one%n");
	}
	
	
	public boolean isCardForeFound(Card card)
	{
		if (!card.isHidden())
		{
			System.err.printf("Card 1 already found, choose another one%n");
			return true;
		}
		return false;
	}
	
	
	public boolean isSameCard(int card1X, int card1Y, int card2X, int card2Y)
	{
		if ((card1X == card2X) && (card1Y == card2Y))
		{
			System.err.printf("You can't choose the same card twice%n");
			return true;
		}
		return false;
	}
	
	
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
	
	
	public boolean isGameOver(int nbpair, int maxpair, int numberStrokes)
	{
		if (nbpair == maxpair)
		{
			System.out.printf("Game Over, You won%n%n");
			System.out.println("Number of strokes: "+numberStrokes);
			return true;
		}
		return false;
	}
	
}
