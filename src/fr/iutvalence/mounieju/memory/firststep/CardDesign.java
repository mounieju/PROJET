package fr.iutvalence.mounieju.memory.firststep;

/**
 * Enumeration of multiple designs a card can have.
 *
 * @author liottara
 * @version TODO
 */

public enum CardDesign 
{
    /** Sushi card's design. */
    SUSHI(" S "),
    
    /** Ramen card's design. */
    RAMEN(" R ");
    
    /** Constant linking a letter to a design for the display. */
    private final String display;

    /** Constructor for the card's design. 
     * @param disp: display of the card's design.
     */
    CardDesign(final String disp) 
    {
        display = disp;
    }

    @Override
    public String toString() 
    {
    	String cardSeparator = "|";
		String afterCard = this.display+cardSeparator;
		if (this.display == null) return cardSeparator+"()"+afterCard;
		return cardSeparator+afterCard+" ";
    }
}
