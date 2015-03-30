/* TODO Mettre dans un package. */
/* TODO JAVADOC. */
public class CasePlateau {
    /* TODO Si une CasePlateau est seulement une carte… pourquoi une classe dédiée.
     * Cela ne veut pas dire qu'il faille supprimer cette classe, c'est une question.
     * Vous avez trois niveaux : Plateau -> CasePlateau -> Carte -> Design, n'est-ce pas un peu trop ? Où à revoir ?
     */
    /* TODO JAVADOC. */
    private Carte carte;

    /* TODO JAVADOC. */
    public CasePlateau(Carte carte) {
        this.carte = carte;
    }

    /* TODO JAVADOC. */
    //Methode pour savoir s'il y a une carte sur la case ou non
    public boolean presenceCarte() {
        /* TODO N'est-ce pas carte qu'il faut comparer à NULL ? */
        if (this.CasePlateau == NULL) { return false; }
        return true;
    }

    /* TODO JAVADOC. */
    // Affichage
    public String toString() {
        /* TODO Ne jamais comparer à TRUE ou FALSE ! */
        if (presenceCarte(this.carte) == TRUE) { return this.carte; }
        return " x ";
    }
}
