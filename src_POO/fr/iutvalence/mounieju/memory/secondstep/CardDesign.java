package fr.iutvalence.mounieju.memory.secondstep;

/**
 * Enumeration of multiple designs a card can have.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 2
 */

public enum CardDesign 
{
	
	////////////////// Attributes //////////////////////////////////////////////////////

    /** Sushi card's design. */
    SUSHI("S"),
    
    /** Ramen card's design. */
    RAMEN("R");
    
    /** Constant linking a letter to a design for the display. */
    private final String display;

    
    ////////////////////Constructor //////////////////////////////////////////////////////

    /** 
     * Constructor for the card's design. 
     * @param disp: display of the card's design.
     */
    CardDesign(final String disp) 
    {
        display = disp;
    }
    

    //////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() 
    {
    	return display;
    }
}
