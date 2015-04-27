package fr.iutvalence.mounieju.memory.firststep;

/* TODO Use Generics rather than attribute for the design. */

/**
 * Class to create a card.
 *
 * @author liottara
 * @version TODO
 */

public class Card 
{
    /** Card's design on the board. */
    private final CardDesign design;

    /** Constructor for the card according to the settings given by the user.
     * @param designCard the card's design.
     */
    public Card(CardDesign designCard) 
    {
        this.design = designCard;
    }

    /** Get the private attribute of the card's design.
     * @return design : the card's design.
     */
    public CardDesign getDesign() 
    {
        return this.design;
    }

    /* TODO Regarder l'interface Comparable mais n'est-ce pas au Design d'implémenter cela ? */

    /**
     * Compare the design of two selected cards.
     * @return true: cards are identical, else false
     */
    public boolean compareTo(Card other) 
    {
        return this.design == other.design;
    }
}
