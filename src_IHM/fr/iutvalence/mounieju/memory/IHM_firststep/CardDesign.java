package fr.iutvalence.mounieju.memory.IHM_firststep;

/**
 * Enumeration of multiple designs a card can have.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 4
 */

public enum CardDesign 
{
	////////////////// Attributes //////////////////////////////////////////////////////

    /** Sushi card's design. */
    SUSHI("S"),
    
    /** Ramen card's design. */
    RAMEN("R"),
    
    /** Nem card's design. */
    NEM("N"),
    
    /** Maki card's design. */
    MAKI("M"),
    
    /** Yakitori card's design. */
    YAKITORI("Y"),
    
    /** Daifuku card's design. */
    DAIFUKU("D"),
    
    /** Tempura card's design. */
    TEMPURA("T"),
    
    /** Onigiri card's design. */
    ONIGIRI("O");
    
    /** Displays design by a letter. */
    private final String display;

    
    ////////////////////Constructor //////////////////////////////////////////////////////

    /** 
     * Constructor of the card's design with parameters. 
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

	public String getDisplay()
	{
		return display;
	}
}
