package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")

public class MenuBarGame extends JMenuBar implements ActionListener
{
	/**La fenêtre	 */
	private JFrame window;

	/** Menu item to change level.	 */
	private JMenuItem menuItemLevel;

	/** * Menu item to exit game.	 */
	private JMenuItem menuItemExit;
	
	
	/**
	 * Cr�ation de la barre de menu
	 * 
	 * @param window
	 *            la fen�tre � laquelle le menu est associ�
	 */
	public MenuBarGame(JFrame window)
	{
		this.window = window;
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
			
			this.add(menu);
			
			// Creates rubric menu "RULES"
			JMenu rules = new JMenu("Rules");
			this.add(rules);

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
			return;
		}
	}
}
