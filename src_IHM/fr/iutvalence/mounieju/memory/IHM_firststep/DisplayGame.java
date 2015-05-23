package fr.iutvalence.mounieju.memory.IHM_firststep;

import javax.swing.SwingUtilities;


/** 
 * Main of the Memory.
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 1 (IHM)
 */

public class DisplayGame 
{
	
    /** Displays the game on the terminal.
     * @param args
     */
    public static void main(String[] args) 
    {
    	SwingUtilities.invokeLater(new DisplayTask());
    	/* Creates new game. */
    	Game game = new Game();
		
		
    	
    	/* Starts the game.  */
    	game.start();
    }
    
}
