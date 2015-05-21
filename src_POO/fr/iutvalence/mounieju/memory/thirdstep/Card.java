package fr.iutvalence.mounieju.memory.thirdstep;

/* TODO Use Generics rather than attribute for the design. */

/**
 * Class to create a card.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 3
 */

public class Card 
{
	////////////////// Attributes //////////////////////////////////////////////////////
	
    /** Card's design on the board. */
    private final CardDesign design;
    
    /** Card's face view. */
    private boolean hidden;
         
    
//////////////////// Constructor //////////////////////////////////////////////////////
    
	/** 
	 * Constructor for the card according to the settings given by the user.
     * @param designCard the card's design.
     */
    public Card(CardDesign designCard) 
    {
        this.design = designCard;
        this.hidden = true;
    }

    
 //////////////////// Getters ////////////////////////////////////////////////////////
    
    /** 
     * Get the private attribute of the card's face view.
     * @return boolean (true: card is hidden, false: card is revealed).
     */
	public boolean isHiden() 
    {
        return this.hidden;
    }
    
    
    //////////////////// Methods ////////////////////////////////////////////////////////
        
	/**
	 * Method when flipping card, changes its view (hidden or revealed).
	 */
	public void flip() {
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
    public String toString() {
    	return String.format("| %s |", hidden ? "#" : design);
    }
    
}
