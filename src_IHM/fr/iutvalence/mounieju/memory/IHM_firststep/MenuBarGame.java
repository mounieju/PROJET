package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Class for menu bar.
 *
 * @author Alexandra LIOTTARD & Julie MOUNIER.
 * @version 1 (IHM)
 */
@SuppressWarnings("serial")

public class MenuBarGame extends JMenuBar implements ActionListener
{
	////////////////// Attributes //////////////////////////////////////////////////////

	/** Menu bar's window */
	private JFrame window;

	/** Menu item to change level.	 */
	private JMenuItem menuItemLevel;

	/** * Menu item to exit game.	 */
	private JMenuItem menuItemExit;
	
    //////////////////// Constructor //////////////////////////////////////////////////////

	/**
	 * Creating the bar menu.
	 * @param window: window to which the menu is attached.
	 */
	public MenuBarGame(JFrame window)
	{
		this.window = window;
		
			// Creates rubric menu "MENU"
			JMenu menu = new JMenu("Menu");
			this.add(menu);
			
				// Creates menu "LEVEL"
				this.menuItemLevel = new JMenu("Change level");
				this.menuItemLevel.addActionListener(this);
				menu.add(this.menuItemLevel);
			
				// Creates menu item "EXIT"
				this.menuItemExit = new JMenuItem("Exit");
				this.menuItemExit.addActionListener(this);
				menu.add(this.menuItemExit);

			// Creates rubric menu "RULES"
			JMenu rules = new JMenu("Rules");
			this.add(rules);

	}
	
	
	/**
	 * Processing events associated with headings items.
	 * @param event: occurred event. 
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Identification of the selected item, event source
		JMenuItem itemSelected = (JMenuItem) event.getSource();

		if (itemSelected == this.menuItemLevel)
		{
			// Display a dialog delivering a simple message
			JOptionPane.showConfirmDialog(null,"choose one", "choose one", JOptionPane.YES_NO_OPTION);
			return;
		}

		if (itemSelected == this.menuItemExit)
		{
			// Display a dialog box with two options (confirm / cancel)
			if (JOptionPane.showConfirmDialog(this.window, "Exit Game ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				// Destruction in case of closing confirmation window
				this.window.dispose();
			return;
		}
	}
}
