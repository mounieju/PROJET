package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

	/** Menu item to change level.	 */
	private JMenuItem menuItemLevel;

	/** * Menu item to exit game.	 */
	private JMenuItem menuItemExit;
	
	
	@Override
	public void run()
	{
		// Creates window frame
		this.window = new JFrame();

		// Modification window's properties
		// Title, dimensions (in pixels)
		window.setTitle("The Memory Game");
		window.setSize(500, 500);



		
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Creates component linked to bar menu
		JMenuBar menuBar = new JMenuBar();

		// Creates rubric menu "MENU"
		JMenu menu = new JMenu("Menu");
			// Creates menu item "LEVEL"
			this.menuItemLevel = new JMenuItem("Change level");
			this.menuItemLevel.addActionListener(this);
			menu.add(this.menuItemLevel);
		
			// Creates menu item "EXIT"
			this.menuItemExit = new JMenuItem("Exit");
			this.menuItemExit.addActionListener(this);
			menu.add(this.menuItemExit);
		
		// Creates rubric menu "RULES"
		JMenu rules = new JMenu("Rules");


		// Adds contents to the menu bar.
		menuBar.add(menu);
		menuBar.add(rules);

		
		// Links menu bar to window.
		this.window.setJMenuBar(menuBar);
		
		// Displays window
		this.window.setVisible(true);


	}
	
	/**
	 * Traitement des évènements associés aux items de rubriques
	 * 
	 * @param event
	 *            l'événement survenu
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Identification de l'item sélectionné, source de l'événement
		JMenuItem itemSelected = (JMenuItem) event.getSource();

		if (itemSelected == this.menuItemLevel)
		{
			// Affichage d'un boite de dialogue délivrant un simple message
			JOptionPane.showMessageDialog(this.window, "Choose a level", "Change level", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (itemSelected == this.menuItemExit)
		{
			// Affichage d'un boite de dialogue proposant 2 options
			// (confirmer/annuler)
			if (JOptionPane.showConfirmDialog(this.window, "Exit Game ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				// destruction de la fenêtre en cas de confirmation de fermeture
				this.window.dispose();
		}
	}
}

