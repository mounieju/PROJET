package fr.iutvalence.mounieju.memory.firststep;

/* TODO Translate. */
/**
 * Enumération permettant d'attribuer un design à la carte.
 *
 * @author liottara
 * @version TODO
 */
public enum CardDesign {
    /* TODO Translate. */
    /** Apparence sushi de la carte. */
    SUSHI(" S "),
    /* TODO Translate. */
    /** Apparence ramen de la carte. */
    RAMEN(" R ");
    /* TODO JAVADOC. */
    private final String display;

    /* TODO JAVADOC. */
    CardDesign(final String disp) {
        display = disp;
    }

    @Override
    public String toString() {
        return display;
    }
}
