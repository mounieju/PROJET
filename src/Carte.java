
public class Carte 
{
	//Attributs
	private final boolean designCarte;
	
	//methodes 
	public Carte(boolean designCarte)
	{
		this.designCarte = designCarte;
	}
	
	public boolean obtenirDesign()
	{
		return this.designCarte;
	}
	
	public boolean comparerCartes(boolean designCarte)
	{
		
	}
	
	
	//Affichage
	
	public String toString()
	{
		if (this.designCarte == DesignCarte.SUSHI)
			return " S ";
		return " R ";
	}
	
	
}
