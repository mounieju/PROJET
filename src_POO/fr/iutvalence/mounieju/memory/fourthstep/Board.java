package fr.iutvalence.mounieju.memory.fourthstep;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import fr.iutvalence.mounieju.memory.IHM_firststep.Card;
import fr.iutvalence.mounieju.memory.IHM_firststep.CardDesign;

/**
 * Class for the board of the game.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 4
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
    

    //////////////////// Constructors ////////////////////////////////////////////////////// 
    
    /** Constructor of the board. */
    public Board() 
    {
        this.board = new Card[NB_TOT_ROW][NB_TOT_COL];
        
        /* Creating deck of paired cards associated with design */
        List<Card> deck = new LinkedList<Card>();
        for (CardDesign design : CardDesign.values()) 
        {
        	deck.add(new Card(design));
        	deck.add(new Card(design));
        	if (deck.size() == NB_TOT_COL*NB_TOT_ROW)
        		break;	
        }
        /* Shuffling deck, changing order of cards */
        Collections.shuffle(deck);
        
        /* Initialize board. */        
        for (int i = 0; i < NB_TOT_ROW; i++)
        	for (int j =0; j < NB_TOT_COL; j++)
        		this.board[i][j] = deck.remove(0);
    }
    
    
    /** Constructor of the board with parameters. */
    public Board(int nbCol, int nbRow) 
    {
    	NB_TOT_COL = nbCol;
    	NB_TOT_ROW = nbRow;
    	this.board = new Card[NB_TOT_ROW][NB_TOT_COL];
        
        /* Creating deck of paired cards associated with design */
        List<Card> deck = new LinkedList<Card>();
        for (CardDesign design : CardDesign.values()) 
        {
        	deck.add(new Card(design));
        	deck.add(new Card(design));
        	if (deck.size() == NB_TOT_COL*NB_TOT_ROW)
        		break;
        }
        /* Shuffling deck, changing order of cards */
        Collections.shuffle(deck);

        /* Initialize board. */        
        for (int i = 0; i < NB_TOT_ROW; i++)
        	for (int j =0; j < NB_TOT_COL; j++)
        		this.board[i][j] = deck.remove(0);        
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
	    
    
	//////////////////// Method ////////////////////////////////////////////////////////
         
    /** 
     * Method to flip selected card.
     * @param x: abscissa   ;   y: ordinate.
     * @return flipped Card (with hidden view changed).
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
        StringBuilder asciiArtBoard = new StringBuilder();
        
        asciiArtBoard.append("  ");
        
        //Display numbers of column above the board
        for(int col= 0 ; col < NB_TOT_COL ; col++)
        {
        	asciiArtBoard.append("  " +col+"  ");
        }
        
        asciiArtBoard.append("\n");
        asciiArtBoard.append("  ");
        for(int col= 0 ; col < NB_TOT_COL ; col++)
        {
            asciiArtBoard.append("-----");
        }
        asciiArtBoard.append("\n");
        
        for (int numberOfRows = 0; numberOfRows < NB_TOT_ROW; numberOfRows++) 
        {
            asciiArtBoard.append(numberOfRows+" ");
            for (int numberOfColumns = 0; numberOfColumns < NB_TOT_COL; numberOfColumns++) 
            {
                asciiArtBoard.append(this.board[numberOfRows][numberOfColumns]);
            }
                        
            asciiArtBoard.append("\n");
            asciiArtBoard.append("  ");
            for(int col= 0 ; col < NB_TOT_COL ; col++)
            {
                asciiArtBoard.append("-----");
            }
            asciiArtBoard.append("\n");

        }
        return asciiArtBoard.toString();
    }
}
