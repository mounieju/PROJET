/**
 * 
 */
package fr.iutvalence.mounieju.memory.thirdstep;

/**
 * @author Nejko
 *
 */

public enum Difficulty 
{
	    EASY("Easy"),
	    
	    NORMAL("Normal"),
	    
	    HARD("Hard"),
	    
	    private final String display;

	    Difficulty(final String name) 
	    {
	        display = name;
	    }


		@Override
		public String toString() 
		{
			return display;
		}
}