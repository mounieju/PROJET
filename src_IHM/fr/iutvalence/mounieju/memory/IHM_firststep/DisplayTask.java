package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Class dealing with the task of IHM 
 * 
 *@author Alexandra LIOTTARD & Julie MOUNIER
 *@version 1 (IHM)
 */

public class DisplayTask implements Runnable, ActionListener
{
	////////////////// Attributes //////////////////////////////////////////////////////

	/** Game's window */
	private JFrame window;
	private Game game;
	private ChoosingDifficultyPanel chooseDiffPanel;
	
	
    //////////////////// Constructor //////////////////////////////////////////////////////

//	/**
//	 * @param window
//	 * @param chooseDiffPanel
//	 */
//	public DisplayTask(Game game) 
//	{
//		this.game = game;
//	}
//	

	////////////////// Method ////////////////////////////////////////////////////////

	/**
	 * Internal method for initializing the HMI.
	 */
	private void initiateGUI()
	{
		// Creates window frame
		this.window = new JFrame();

		// Modifying window's properties
		this.window.setTitle("The Memory Game");
		this.window.setSize(500, 500);
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Links menu bar to window.
		this.window.setJMenuBar(new MenuBarGame(this.window));
		
		// Displays window
		this.window.setVisible(true);
		
		// Creates the pannel for choosing difficulty
		this.chooseDiffPanel = new ChoosingDifficultyPanel(this);

	}
	
	@Override
	public void run()
	{
		this.initiateGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
//
//	@Override
//	public void notifierChangementDeRepresentationDuNombre(RepresentationDeNombre representationDuNombre)
//	{
//		this.symboles = representationDuNombre.obtenirLesDigits();
//		this.labelDeLaSuiteDeSymboles.setText(this.symboles);
//		this.chooseDiffPanel.forceDifficultyOfGame(gameDiff.getDifficulty());forcerLaSelectionDeLaBase(representationDuNombre.obtenirLaBase());
//	}
//	
}

