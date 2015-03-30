/* TODO Mettre dans un package. */
/* TODO JAVADOC. */
public class Carte {
    /* TODO Qu'est-ce ? */
    private final boolean designCarte;

    /* TODO JAVADOC. */
    public Carte(boolean designCarte) {
        this.designCarte = designCarte;
    }

    /* TODO JAVADOC. */
    /* TODO Attention au franglais ? */
    public boolean obtenirDesign() {
        return this.designCarte;
    }

    /* TODO JAVADOC. */
    /* TODO Regarder l'interface Comparable mais n'est-ce pas au Design d'implémenter cela ? */
    public boolean comparerCartes(boolean designCarte) {
        /* TODO. */
    }

    /* TODO JAVADOC. */
    @Override
    public String toString() {
        /* TODO Ce type de distinction ne devrait pas être là mais dans DesignCarte… */
        if (this.designCarte == DesignCarte.SUSHI) { return " S "; }
        return " R ";
    }
}
