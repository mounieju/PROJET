package fr.iutvalence.mounieju.memory.fourthstep;

/**
 * Class for a card.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 4
 */

public class Card 
{
	////////////////// Attributes //////////////////////////////////////////////////////
	
    /** Card's design on the board. */
    private final CardDesign design;
    
    /** Card's hidden view. */
    private boolean hidden;
         
    
    //////////////////// Constructor //////////////////////////////////////////////////////
    
	/** 
	 * Constructor of the card with parameters.
     * @param designCard the card's design.
     */
    public Card(CardDesign designCard) 
    {
        this.design = designCard;
        this.hidden = true;
    }

    
    //////////////////// Getter ////////////////////////////////////////////////////////
    
    /** 
     * Get the private attribute of the card's hidden view.
     * @return boolean (true: card is hidden, false: card is revealed).
     */
	public boolean isHidden() 
    {
        return this.hidden;
    }
    
    
    //////////////////// Method ////////////////////////////////////////////////////////
        
	/**
	 * Method when flipping card, changes its view (hidden or revealed).
	 */
	public void flip() 
	{
		this.hidden = !this.hidden;
	}
	
	
	
   /////////////////////////////////////////////////////////////////////////////////////////////////////////    
  
    @Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((design == null) ? 0 : design.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return (design == other.design);
	}

	
	@Override
    public String toString() 
	{
    	return String.format("| %s |", hidden ? "#" : design);
    }
    
}
