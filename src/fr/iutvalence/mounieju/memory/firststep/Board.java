package fr.iutvalence.mounieju.memory.firststep;

/* TODO Mettre dans un package. */

/** Classe pour créer le plateau de jeu
 * 
 * @author liottara */

public class Board
{
	/** Constante: nombre total de lignes par défaut du plateau */
	private static final int NB_TOT_ROW = 2;
	/** Constante: nombre total de colonnes par défaut du plateau */
	private static final int NB_TOT_COL = 2;
	/* TODO Où sont vos cartes ? */
	private final Card board[][];

	public Board()
	{
		board = new Card[NB_TOT_COL][NB_TOT_ROW];
	}

	/** Methode pour savoir s'il y a une carte sur la case ou non
	 * 
	 * @return boolean */
	public boolean placedCard(int x, int y)
	{
		return this.board[x][y] != null;
		// TODO Initialisation
	}

	@Override
	public String toString()
	{
		/* TODO À discuter en séance (où à travailler vous même) String vs
		 * StringBuffer vs StringBuilder. */
		String plateauAsciiArt = "";

		for (int numeroDeLigne = 0; numeroDeLigne < NB_TOT_ROW; numeroDeLigne++)
		{
			for (int numeroDeColonne = 0; numeroDeColonne < NB_TOT_COL; numeroDeColonne++)
			{
				plateauAsciiArt += this.board[numeroDeLigne][numeroDeColonne];
			}

			plateauAsciiArt += "\n";
		}

		return plateauAsciiArt;
	}

}
