
public class CasePlateau 
{	
	//Attributs
	private Carte carte;

		
	//Methodes
	
	
	public CasePlateau(Carte carte)
	{
		this.carte = carte;
	}
	

	//Methode pour savoir s'il y a une carte sur la case ou non
	public boolean presenceCarte ()
	{
		if (this.CasePlateau == NULL)
			return false;
		return true;
	}
	
	
	
	
	
	
//TODO 
	
	// Affichage
	public String toString()
	{
		if (presenceCarte(this.carte) == TRUE)
			return this.carte;
		return " x ";
	}
}
