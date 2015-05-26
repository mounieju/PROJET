package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.util.Scanner;

/**
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 4
 */
public class GameInputs 
{
	//////////////// Attributes //////////////////////////////////////////////////////
	
	private int difficulty;
	
	
	////////////////// Constructor //////////////////////////////////////////////////////

	public GameInputs()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a level: 1 for 'Easy', 2 for 'Hard'");
		this.difficulty = sc.nextInt();
		/* Deals with input errors. */
		while (this.difficulty != 1 && this.difficulty !=2)
		{
			System.err.printf("Level doesn't exist%n");
			System.out.println("Choose a level: 1 for 'Easy', 2 for 'Hard'");
			this.difficulty = sc.nextInt();
		}	
	}
	
	
    //////////////////// Getter ////////////////////////////////////////////////////////

	/**
	 * @return the difficulty
	 */
	public int getDifficulty() 
	{
		return difficulty;
	}
	
	
	////////////////// Method ////////////////////////////////////////////////////////

	public int askXPosi()
	{
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input card's x position%n");
		int xPosi = sc.nextInt();
		return xPosi;
	}
	
	
	public int askYPosi()
	{
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input card's y position%n");
		int yPosi = sc.nextInt();
		return yPosi;
	}
			
}
