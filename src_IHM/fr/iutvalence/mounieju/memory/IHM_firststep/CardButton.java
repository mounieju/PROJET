package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Class for card buttons 
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 2
 */
public class CardButton extends JButton implements ActionListener
{
	////////////////// Attributes //////////////////////////////////////////////////////

    /** Card's button's ordinate & abscissa. */
	private Position posi;
    /** Card's button's controller. */
	private Controller controller;
	
	
    ////////////////////Constructor //////////////////////////////////////////////////////

	/**
	 * Constructor for a card button.
	 * @param i: card's button's ordinate.
	 * @param j: card's button's abscissa. 
	 * @param controller: the controller which controls this class.
	 */
	public CardButton(Position posi, Controller controller)
	{
		super();
		this.posi = posi;
		this.controller = controller;
		addActionListener(this);
	}

    //////////////////// Getters & setters ////////////////////////////////////////////////////////
    
    /** 
     * Get the private attribute of the card's button's position.
     * @return posi: current card's button's position.
     */
	public Position getPosi()
	{
		return posi;
	}

	
    //////////////////// Method ////////////////////////////////////////////////////////

	
	/**
	 * Method to display design on the game.
	 * @param design: card's design. 
	 */
	public void cardButtonFlip(String design)
	{
		this.setText(design);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		controller.flip(posi, this);
		controller.posLastButton(this.posi,this);
	}

}
