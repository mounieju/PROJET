package fr.iutvalence.mounieju.memory.IHM_firststep;


/**
 * Class for a card.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 2
 */

public class Card 
{
	////////////////// Attributes //////////////////////////////////////////////////////
	
    /** Card's design on the board. */
    private final CardDesign design;
    
    /** Card's hidden view. */
    private boolean hidden;
    
    private Position posi;
         
    
    //////////////////// Constructor //////////////////////////////////////////////////////
    
	/** 
	 * Constructor of the card with parameters.
     * @param designCard the card's design.
     */
    public Card(CardDesign designCard, Position posi) 
    {
        this.design = designCard;
        this.hidden = true;
        this.posi = posi;
    }
    
    public Card(CardDesign designCard) 
    {
        this.design = designCard;
        this.hidden = true;    }

    
    //////////////////// Getters & setters ////////////////////////////////////////////////////////
    
    /** 
     * Get the private attribute of the card's hidden view.
     * @return boolean (true: card is hidden, false: card is revealed).
     */
	public boolean isHidden() 
    {
        return this.hidden;
    }
	
	/** 
     * Get the private attribute of the card's design.
     * @return design: current card's design.
     */
	public CardDesign getDesign()
	{
		return design;
	}
	
    /** 
     * Get the private attribute of the card's position.
     * @return position: current card's position.
     */
	public Position getPosition() 
    {
        return this.posi;
    }
	
	/** 
     * Set the private attribute of the card's position.
     * @param posi: position of the card to change..
     */
	public void setPosi(Position posi)
	{
		this.posi = posi;
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
