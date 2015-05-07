package fr.iutvalence.mounieju.memory.firststep;

/* TODO Use Generics rather than attribute for the design. */

/**
 * Class to create a card.
 *
 * @author liottara
 * @version 1
 */

public class Card 
{
	////////////////// Attributes //////////////////////////////////////////////////////
	
    /** Card's design on the board. */
    private final CardDesign design;
    /** Card's face position. */
    private boolean hidden;
    
    
    
//////////////////// Constructor //////////////////////////////////////////////////////
    
	/** Constructor for the card according to the settings given by the user.
     * @param designCard the card's design.
     */
    public Card(CardDesign designCard) 
    {
        this.design = designCard;
        hidden = true;
    }

    
 //////////////////// Methods ////////////////////////////////////////////////////////
    
    /** Get the private attribute of the card's design.
     * @return design : the card's design.
     */
    public CardDesign getDesign() 
    {
        return this.design;
    }
    
    
    
    
    /* TODO improve methods?*/
      
    /** 
     * Get the private attribute of the card's view.
     * @return boolean (true: card is hidden, false: card is revealed).
     */
    public boolean getView() 
    {
        return this.hidden;
    }
    
    
    /**
	 * Method to reveal card.
	 * @return hidden false.
	 */
	public boolean revealCard()
	{
		return this.hidden = false;
	}
	
	
	/**
	 * Method to hide card.
	 * @return hidden true.
	 */
	public boolean hideCard()
	{
		return this.hidden = true;
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
