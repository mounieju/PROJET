package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Task dealing with IHM 
 * 
 *@author Alexandra LIOTTARD & Julie MOUNIER
 *@version 1
 */

public class DisplayTask implements Runnable, ActionListener
{
	/**La fenêtre	 */
	private JFrame window;
	

	/**
	 * Methode interne permettant d'initialiser l'IHM
	 */
	private void initiateGUI()
	{
		// Creates window frame
		this.window = new JFrame();

		// Modification window's properties
		// Title, dimensions (in pixels)
		this.window.setTitle("The Memory Game");
		this.window.setSize(500, 500);
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Links menu bar to window.
		this.window.setJMenuBar(new MenuBarGame(this.window));
		
		// Displays window
		this.window.setVisible(true);


	}
	
	@Override
	public void run()
	{
		this.initiateGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}

