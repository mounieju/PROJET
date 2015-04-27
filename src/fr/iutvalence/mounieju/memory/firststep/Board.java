package fr.iutvalence.mounieju.memory.firststep;

/**
 * Class to create the board of the game.
 *
 * @author liottara
 * @version TODO
 */

public class Board 
{
    /** Constant: total number of rows by default on the board. */
    private static final int NB_TOT_ROW = 2;
    /** Constant: total number of columns by default on the board. */
    private static final int NB_TOT_COL = 2;
    /** Define a 2D board with cards.  */
    private final Card board[][];

    /** Constructor for the board. */
    public Board() 
    {
        board = new Card[NB_TOT_COL][NB_TOT_ROW];
        /* TODO Initialize your board. */
    }


    /**
     * Method to know if there's a card or not on the board.
     * @param location of the card (x being the abscissa and y the ordinate)
     * @return boolean (true meaning there is a card at the (x,y) location)
     */
    public boolean existingCard(int x, int y) 
    {
        return this.board[x][y] != null;
    }

    @Override
    public String toString() 
    {
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
