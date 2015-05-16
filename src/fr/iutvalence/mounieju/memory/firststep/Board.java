package fr.iutvalence.mounieju.memory.firststep;

import java.util.Objects;

/**
 * Class to create the board of the game.
 *
 * @author liottara
 * @version 1
 */

public class Board 
{
	////////////////// Attributes //////////////////////////////////////////////////////

    /** Constant: total number of rows by default on the board. */
    public static final int NB_TOT_ROW = 2;
    
    /** Constant: total number of columns by default on the board. */
    public static final int NB_TOT_COL = 2;
    
    /** Define a 2D board with cards.  */
    private final Card board[][];

    
////////////////////Constructor ////////////////////////////////////////////////////// 
    
    /** Constructor for the board. */
    public Board() 
    {
        this.board = new Card[NB_TOT_COL][NB_TOT_ROW];
        
        
        /* Initialize board. */        
        this.board[0][0] = new Card(CardDesign.RAMEN);
        this.board[0][1] = new Card(CardDesign.SUSHI);
        this.board[1][0] = new Card(CardDesign.SUSHI);
        this.board[1][1] = new Card(CardDesign.RAMEN);
        
        
        
        /* test flipCard method */
       /* flipCard(this.board[1][1]);
        flipCard(this.board[1][0]);
        flipCard(this.board[1][1]);  try flipping it twice */
       
        

        
        /*test sameCard method */
//        System.out.println(sameCard(this.board[1][1],this.board[1][0]));       

    }
   
    
    
//////////////////// Methods ////////////////////////////////////////////////////////

    
	/**
     * Method to know if one card is the same as another card.
     * @param Choose two cards you want to compare.
     * @return boolean (true: they're the same, else not)
     */

    public boolean sameCard(Card first, Card second) 
    {
    	return Objects.equals(first, second);
    } 
    
   
        
    /** 
     * Flips selected card.
     */

    public Card flipCard(int i, int j)
    {
    	this.board[i][j].flip();
    	return this.board[i][j];
    }
    

   
    /* TODO 
     * link sameCard & flipCard ?
     * flipCard : limit to two cards turned ?
     * create Player and set all methods for him to insert commands
     */
    
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
