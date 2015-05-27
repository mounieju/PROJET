package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Class for card buttons 
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 4
 */
public class CardButton extends JButton implements ActionListener
{
	////////////////// Attributes //////////////////////////////////////////////////////

    /** Card's button's ordinate & abscissa. */
	private int i;
	private int j;
    /** Card's button's controller. */
	private Controller controller;
	
	private CardDesign cardDesign;

	
    ////////////////////Constructor //////////////////////////////////////////////////////

	/**
	 * Constructor for a card button.
	 * @param i: card's button's ordinate.
	 * @param j: card's button's abscissa. 
	 * @param controller: the controller which controls this class.
	 */
	public CardButton(int i, int j, Controller controller)
	{
		super();
		this.i = i;
		this.j = j;
		this.controller = controller;
		addActionListener(this);
	}


	public void cardButtonFlip(String design)
	{
		this.setText(design);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		System.out.println(String.format("(%d,%d)", i, j));
		controller.flip(i,j, this);

	}

}
