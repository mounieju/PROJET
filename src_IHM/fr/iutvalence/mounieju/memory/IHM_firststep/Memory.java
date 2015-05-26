package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 * Class dealing with the task of IHM 
 * 
 *@author Alexandra LIOTTARD & Julie MOUNIER
 *@version 1 (IHM)
 */

@SuppressWarnings("serial")
public class Memory extends JFrame implements ActionListener
{
	////////////////// Attributes //////////////////////////////////////////////////////

	/** Game's window */
	private JRadioButton easyRB, hardRB;
	private JPanel gamePnl;
	private Controller controller;
	

	
    //////////////////// Constructor //////////////////////////////////////////////////////

	/**
	 * Constructor for the GUI.
	 */
	public Memory(Controller controller)
	{
		this.controller = controller;
		// Modifying window's properties
    	menu();
		init();
		panel();
		setTitle("The Memory Game");
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
}
		
	/**
	 * Private method to create the game's window's menu. 
	 */
	private void menu()
	{
		// Creates component linked to bar menu
		JMenuBar menuBar = new JMenuBar();

		// Creates rubric menu "MENU"
		JMenu menu = new JMenu("Menu");
		// Creates rubric menu "RULES"
			JMenuItem menuItemRules = new JMenuItem("Rules");
			menuItemRules.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "The player's score is based on the number of paired cards found: \n" 
	+"- The board seeks for remaining cards and increment the score each time the player flips two 		identical cards.\n"
	+"- When two identical cards are found, they remain on the board (right side up).\n"
	+"- If not, the game automatically turns them over again (face down).", "How to play", JOptionPane.INFORMATION_MESSAGE);					
				}
				
			});
			menu.add(menuItemRules);
				
			// Creates menu item "EXIT"
			JMenuItem menuItemExit = new JMenuItem("Exit");
			menuItemExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (JOptionPane.showConfirmDialog(null, "Exit Game ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
						dispose();					
				}
				
			});
			menu.add(menuItemExit);
			

		// Adds contents to the menu bar.
		menuBar.add(menu);

		// Links menu bar to window.
		setJMenuBar(menuBar);
	}
	
	/**
	 * Private method to create the game's difficulty buttons. 
	 */
    private void init() 
    {
    	//Creates radio buttons to change the difficulty.
        easyRB = new JRadioButton("Easy");
        easyRB.addActionListener(this);
        hardRB = new JRadioButton("Hard");
        hardRB.addActionListener(this);
    }

    /**
	 * Private method to create the game's panel. 
	 */
	  public void panel() 
	  {
		  // Sets panel with the game cards buttons area.
	        gamePnl = new JPanel();
	        
	        // Sets panel with the difficulty buttons area.
	        JPanel diffPnl = new JPanel();
	        diffPnl.setLayout(new GridLayout(1, 2));
	        diffPnl.add(easyRB);
	        diffPnl.add(hardRB);
	 
	        add(gamePnl, BorderLayout.CENTER);
	        add(diffPnl, BorderLayout.NORTH);
	 
	    }
	  

	/**
	 * Method to set card buttons according to chosen difficulty.
	 * @param line: number of line of game.
	 * @param column: number of columns of game.
	 */
	public void initParty (int line, int column) {
	    gamePnl.setLayout(new GridLayout(line, column, 5, 5));
	    for (int i = 0; i < line; i++) {
	    	for (int j = 0; j < column; j++) {
	    		gamePnl.add(new CardButton(i,j,controller));
	    	}
	    }
	    this.validate();
	}
	  

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == easyRB)
		{
			hardRB.setSelected(false);
			easyRB.setEnabled(false);
			hardRB.setEnabled(false);

			controller.initParty(1);
		}
		if(arg0.getSource() == hardRB)
		{
			easyRB.setSelected(false);
			easyRB.setEnabled(false);
			hardRB.setEnabled(false);
			
			controller.initParty(2);
		}
		
		
	}
}

