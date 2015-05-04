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
        this.board = new Card[NB_TOT_COL][NB_TOT_ROW];
        
        
        /* TODO Initialize your board. */        
        this.board[0][0] = new Card(CardDesign.RAMEN);
        this.board[0][1] = new Card(CardDesign.SUSHI);
        this.board[1][0] = new Card(CardDesign.SUSHI);
        this.board[1][1] = new Card(CardDesign.RAMEN);
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
        String asciiArtBoard = " ---------\n";
        for (int numberOfRows = 0; numberOfRows < NB_TOT_ROW; numberOfRows++) {
            for (int numberOfColumns = 0; numberOfColumns < NB_TOT_COL; numberOfColumns++) {
                asciiArtBoard += this.board[numberOfRows][numberOfColumns].getDesign();
            }
            asciiArtBoard += "\n ---------\n";
        }
        return asciiArtBoard;
    }
}
