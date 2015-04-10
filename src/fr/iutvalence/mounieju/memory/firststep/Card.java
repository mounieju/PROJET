package fr.iutvalence.mounieju.memory.firststep;

/* TODO Mettre dans un package. */
/** Classe pour creer une carte
 * 
 * @author liottara */
public class Card
{
	/** Design de la carte sur le plateau */
	private final CardDesign designCard;

	/** Construit une carte d'après les caractéristiques données
	 * 
	 * @param designCard
	 *            apparence de la carte */
	public Card(CardDesign designCard)
	{
		this.designCard = designCard;
	}

	/* TODO JAVADOC. */
	public CardDesign getDesign()
	{
		return this.designCard;
	}

	/* TODO Regarder l'interface Comparable mais n'est-ce pas au Design
	 * d'implémenter cela ? */
	/** Compare le design des deux cartes retournées
	 * 
	 * @param other
	 * @return true: les cartes sont identiques, sinon false */
	public boolean compareTo(Card other)
	{
		return this.designCard == other.designCard;
	}

}
