
public class Plateau 
{
	//Attributs
	private static final int NB_TOT_LIGNES = 2;
	private static final int NB_TOT_COLONNES = 2;

	//Methodes
	
	
	
	
	//Affichage du plateau//
	public String toString()
	{
		String plateauAsciiArt = "";

		for (int numeroDeLigne = 0; numeroDeLigne < NB_TOT_LIGNES; numeroDeLigne++)
		{
			for (int numeroDeColonne = 0; numeroDeColonne < NB_TOT_COLONNES; numeroDeColonne++)
				plateauAsciiArt += this.cases[numeroDeLigne][numeroDeColonne];
			
			plateauAsciiArt += "\n";
		}

		return plateauAsciiArt;
	}

}
