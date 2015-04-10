package fr.iutvalence.mounieju.memory.firststep;

/* TODO Translate. */

/**
 * Classe pour créer le plateau de jeu.
 *
 * @author liottara
 * @version TODO
 */
public class Board {
    /* TODO Translate. */
    /** Constante: nombre total de lignes par défaut du plateau. */
    /* TODO Translate. */
    private static final int NB_TOT_ROW = 2;
    /* TODO Translate. */
    /** Constante: nombre total de colonnes par défaut du plateau. */
    /* TODO Translate. */
    private static final int NB_TOT_COL = 2;
    /* TODO JAVADOC. */
    private final Card board[][];

    /* TODO JAVADOC. */
    public Board() {
        board = new Card[NB_TOT_COL][NB_TOT_ROW];
        /* TODO Initialize your board. */
    }

    /* TODO Translate. */

    /**
     * Methode pour savoir s'il y a une carte sur la case ou non.
     *
     * @return boolean
     */
    /* TODO Find a better name. */
    public boolean placedCard(int x, int y) {
        return this.board[x][y] != null;
    }

    @Override
    public String toString() {
        /* TODO With StringBuilder. */
        String plateauAsciiArt = "";
        for (int numeroDeLigne = 0; numeroDeLigne < NB_TOT_ROW; numeroDeLigne++) {
            for (int numeroDeColonne = 0; numeroDeColonne < NB_TOT_COL; numeroDeColonne++) {
                plateauAsciiArt += this.board[numeroDeLigne][numeroDeColonne];
            }
            plateauAsciiArt += "\n";
        }
        return plateauAsciiArt;
    }
}
