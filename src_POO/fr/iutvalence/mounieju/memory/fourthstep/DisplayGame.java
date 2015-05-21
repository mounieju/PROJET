package fr.iutvalence.mounieju.memory.fourthstep;

import fr.iutvalence.mounieju.memory.IHM_firststep.Game;

/** 
 * Main of the Memory.
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 4
 */

public class DisplayGame 
{
	
    /** Displays the game on the terminal.
     * @param args
     */
    public static void main(String[] args) 
    {
    	/* Creates new game. */
    	Game game = new Game();
    	
    	/* Starts the game.  */
    	game.start();
    }
    
}
