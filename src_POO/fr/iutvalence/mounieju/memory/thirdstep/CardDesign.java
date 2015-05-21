package fr.iutvalence.mounieju.memory.thirdstep;

/**
 * Enumeration of multiple designs a card can have.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 3
 */

public enum CardDesign 
{
	
	////////////////// Attributes //////////////////////////////////////////////////////

    /** Sushi card's design. */
    SUSHI("S"),
    
    /** Ramen card's design. */
    RAMEN("R"),
    
    /** Sushi card's design. */
    NEM("N"),
    
    /** Ramen card's design. */
    MAKI("M"),
    
    /** Sushi card's design. */
    YAKITORI("Y"),
    
    /** Ramen card's design. */
    DAIFUKU("D"),
    
    /** Sushi card's design. */
    TEMPURA("T"),
    
    /** Ramen card's design. */
    ONIGIRI("O");
    
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
