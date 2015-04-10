package fr.iutvalence.mounieju.memory.firststep;

/** Enumération permettant d'attribuer un design à la carte
 * 
 * @author liottara */
public enum CardDesign
{

	/** Apparence sushi de la carte */
	SUSHI(" S "),

	/** Apparence ramen de la carte */
	RAMEN(" R ");

	private final String display;

	private CardDesign(final String disp)
	{
		display = disp;
	}

	@Override
	public String toString()
	{
		return display;
	}

}
