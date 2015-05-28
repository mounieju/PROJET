package fr.iutvalence.mounieju.memory.IHM_firststep;

/** 
 * Main of the Memory.
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 2
 */

public class DisplayGame 
{
	
    /** Runs the game.
     * @param args
     */
    public static void main(String[] args) 
    {
    	Controller controller = new Controller();
    	new Thread(controller).start();

    }
    
}
