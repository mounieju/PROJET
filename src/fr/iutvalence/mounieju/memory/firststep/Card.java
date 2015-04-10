package fr.iutvalence.mounieju.memory.firststep;

/* TODO Use Generics rather than attribute for the design. */
/* TODO Translate. */
/**
 * Classe pour creer une carte.
 *
 * @author liottara
 * @version TODO
 */
public class Card {
    /* TODO Translate. */
    /** Design de la carte sur le plateau. */
    private final CardDesign design;

    /* TODO Translate. */

    /**
     * Construit une carte d'après les caractéristiques données.
     *
     * @param designCard apparence de la carte
     */
    public Card(CardDesign designCard) {
        this.design = designCard;
    }

    /* TODO JAVADOC. */
    public CardDesign getDesign() {
        return this.design;
    }

    /* TODO Translate. */
    /* TODO Regarder l'interface Comparable mais n'est-ce pas au Design d'implémenter cela ? */

    /**
     * Compare le design des deux cartes retournées.
     *
     * @return true: les cartes sont identiques, sinon false
     */
    public boolean compareTo(Card other) {
        return this.design == other.design;
    }
}
