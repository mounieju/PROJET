package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/** 
 * Class choosing difficulty panel.
 * 
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 1 (IHM)
 */

@SuppressWarnings("serial")

public class ChoosingDifficultyPanel extends JPanel 
{
	////////////////// Attributes //////////////////////////////////////////////////////

	/** Radio button associated with easy game difficulty */
	private JRadioButton easyRadioButton;
	/** Radio button associated with hard game difficulty */
	private JRadioButton hardRadioButton;
	
	
    //////////////////// Constructor //////////////////////////////////////////////////////

	/**
	 * Creating the difficulty selection panel.
	 * @param buttonsListener: the events listener associated with the buttons.
	 */
	public ChoosingDifficultyPanel(ActionListener buttonsListener)
	{
		 //Association of a type of layout to the panel (grid of 1 line & 2 columns).
		this.setLayout(new GridLayout(1, 2));


		// Creating EASY button
		this.easyRadioButton = new JRadioButton("EASY");
		this.easyRadioButton.setFocusable(false);
		this.easyRadioButton.setSelected(false);
		this.easyRadioButton.addActionListener(buttonsListener);
		this.add(this.easyRadioButton);

		// Creating HARD button
		this.hardRadioButton = new JRadioButton("HARD");
		this.hardRadioButton.setFocusable(false);
		this.hardRadioButton.setSelected(false);
		this.hardRadioButton.addActionListener(buttonsListener);
		this.add(this.hardRadioButton);
		
		// Creating group (to gather the buttons)
		ButtonGroup group = new ButtonGroup();
		group.add(this.easyRadioButton);
		group.add(this.hardRadioButton);
	}
	
	
	/**
	 * Explicit selection of the button associated to a base.
	 * 
	 * @param gameDiff : difficulty of game.
	 */

	public void forceDifficultyOfGame(GameInputs gameDiff)
	{
		switch (gameDiff.getDifficulty())
		{
		case 1:
			this.easyRadioButton.setSelected(true);
			break;
		case 2:
			this.hardRadioButton.setSelected(true);
			break;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	// TODO Review that method !!! /////////////////////////////////////////////
	
	/**
	 * Internal Method for adding a grid panel of buttons, depending on the difficulty of the game.
	 * @param nombreDeLignes le nombre de lignes de boutons
	 * @param nombreDeColonnes le nombre de colonnes de boutons
	 * @param labels les labels associés aux boutons
	 * @param listenerBoutons l'auditeur d'évènements associé aux boutons
	 */
	private void addButtonGrid(int nombreDeLignes, int nombreDeColonnes, char[] labels, ActionListener listenerButtons)
	{
		this.setLayout(new GridLayout(nombreDeLignes, nombreDeColonnes));
		
		for (int numberOfButtons = 0; numberOfButtons<labels.length; numberOfButtons++)
		{
			JButton button = new JButton(""+labels[numberOfButtons]);
			button.setFocusable(false);
			button.addActionListener(listenerButtons);
			this.add(button);	
		}
	}
	
}
