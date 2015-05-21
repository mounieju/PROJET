package fr.iutvalence.mounieju.memory.thirdstep;


/**
 * Class to create the board of the game.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 3
 */

public class Board 
{
	////////////////// Attributes //////////////////////////////////////////////////////

    /** Constant: total number of rows by default on the board. */
    public static int NB_TOT_ROW = 2;
    
    /** Constant: total number of columns by default on the board. */
    public static int NB_TOT_COL = 2;
    
    /** Define a 2D board with cards.  */
    private final Card board[][];
    


    
////////////////////Constructors ////////////////////////////////////////////////////// 
    
    /** Constructor for the board. */
    public Board() 
    {
        this.board = new Card[NB_TOT_COL][NB_TOT_ROW];
        
        
        /* Initialize board. */        
        this.board[0][0] = new Card(CardDesign.RAMEN);
        this.board[0][1] = new Card(CardDesign.SUSHI);
        this.board[1][0] = new Card(CardDesign.SUSHI);
        this.board[1][1] = new Card(CardDesign.RAMEN);
    }
    
    
    /** Constructor for the board. */
    public Board(int nbCol, int nbRow) 
    {
    	NB_TOT_COL = nbCol;
    	NB_TOT_ROW = nbRow;
    	
        this.board = new Card[NB_TOT_COL][NB_TOT_ROW];
        
        
        /* Initialize board. */        
        this.board[0][0] = new Card(CardDesign.SUSHI);
        this.board[0][1] = new Card(CardDesign.SUSHI);
        this.board[0][2] = new Card(CardDesign.NEM);
        this.board[0][3] = new Card(CardDesign.NEM);
        this.board[1][0] = new Card(CardDesign.RAMEN);
        this.board[1][1] = new Card(CardDesign.RAMEN);
        this.board[1][2] = new Card(CardDesign.YAKITORI);
        this.board[1][3] = new Card(CardDesign.YAKITORI);
        this.board[2][0] = new Card(CardDesign.DAIFUKU);
        this.board[2][1] = new Card(CardDesign.DAIFUKU);
        this.board[2][2] = new Card(CardDesign.TEMPURA);
        this.board[2][3] = new Card(CardDesign.TEMPURA);
        this.board[3][0] = new Card(CardDesign.ONIGIRI);
        this.board[3][1] = new Card(CardDesign.ONIGIRI);
        this.board[3][2] = new Card(CardDesign.MAKI);
        this.board[3][3] = new Card(CardDesign.MAKI);
        
    }
    

 
//////////////////// Getter ////////////////////////////////////////////////////////
    
	/** 
	* Get the card on the board.
	* @param x: abscissa ;  y: ordinate.
	* @return card : the card's design.
	*/
	public Card get(int x, int y) 
	{
		return this.board[x][y];
	}
	    
    
	//////////////////// Methods ////////////////////////////////////////////////////////
         
    /** 
     * Method to flip selected card.
     * @param x:abscissa   ;   y: ordinate.
     * @return flipped Card (with face view changed).
     */

    public Card flip(int x, int y)
    {
    	this.board[x][y].flip();
    	return this.board[x][y];
    }
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////      
   

    @Override
    public String toString() 
    {
        /* TODO With StringBuilder. */
        String asciiArtBoard = " --------\n";
        for (int numberOfRows = 0; numberOfRows < NB_TOT_ROW; numberOfRows++) 
        {
            for (int numberOfColumns = 0; numberOfColumns < NB_TOT_COL; numberOfColumns++) 
            {
                asciiArtBoard += this.board[numberOfRows][numberOfColumns];
            }
            asciiArtBoard += "\n --------\n";
        }
        return asciiArtBoard;
    }
}
