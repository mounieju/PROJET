/* TODO Mettre dans un package. */
/* TODO JAVADOC. */
public class Plateau {
    /* TODO Pourquoi des constantes ? */
    /* TODO JAVADOC. */
    private static final int NB_TOT_LIGNES   = 2;
    /* TODO JAVADOC. */
    private static final int NB_TOT_COLONNES = 2;
    /* TODO Où sont vos cartes ? */

    /* TODO JAVADOC. */
    //Affichage du plateau//
    public String toString() {
        /* TODO À discuter en séance (où à travailler vous même) String vs StringBuffer vs StringBuilder. */
        String plateauAsciiArt = "";

        for (int numeroDeLigne = 0; numeroDeLigne < NB_TOT_LIGNES; numeroDeLigne++) {
            for (int numeroDeColonne = 0; numeroDeColonne < NB_TOT_COLONNES; numeroDeColonne++) {
                plateauAsciiArt += this.cases[numeroDeLigne][numeroDeColonne];
            }

            plateauAsciiArt += "\n";
        }

        return plateauAsciiArt;
    }

}
