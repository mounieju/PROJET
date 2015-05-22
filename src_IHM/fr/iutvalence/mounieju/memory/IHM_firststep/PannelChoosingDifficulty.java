package fr.iutvalence.mounieju.memory.IHM_firststep;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")

public class PannelChoosingDifficulty extends JPanel 
{
	/**Le bouton radio associé à la base binaire	 */
	private JRadioButton easyRadioButton;
	/**	 * Le bouton radio associé à la base décimale	 */
	private JRadioButton hardRadioButton;
	
	
	/**
	 * Création du panneau de sélection de la base
	 * 
	 * @param buttonsListener
	 *            l'auditeur d'évenements associés aux boutons
	 */
	public PannelChoosingDifficulty(ActionListener buttonsListener)
	{
		// Association d'un layout de type "grille & ligne x 3 colonnes" au panneau
		this.setLayout(new GridLayout(1, 3));


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
		
		// Création d'un groupe (et ajout des boutons au groupe) pour garant
		// l'exclusivité de la sélection
		ButtonGroup group = new ButtonGroup();
		group.add(this.easyRadioButton);
		group.add(this.hardRadioButton);
	}
	/**
	 * Sélection explicite du bouton associé à une base
	 * 
	 * @param base la base
	 */
	public void forcerLaSelectionDeLaBase(Base game)
	{
		switch (game)
		{
		case EASY:
			this.easyRadioButton.setSelected(true);
			break;
		case HARD:
			this.hardRadioButton.setSelected(true);
			break;
		}
	}
	
	/**
	 * Methode interne permettant d'ajouter une grille de boutons au panneau, en fonction de la base
	 * @param nombreDeLignes le nombre de lignes de boutons
	 * @param nombreDeColonnes le nombre de colonnes de boutons
	 * @param labels les labels associés aux boutons
	 * @param auditeurBoutons l'auditeur d'évènements associé aux boutons
	 */
	private void ajouterUneGrilleDeBoutons(int nombreDeLignes, int nombreDeColonnes, char[] labels, ActionListener auditeurBoutons)
	{
		this.setLayout(new GridLayout(nombreDeLignes, nombreDeColonnes));
		
		for (int numeroDeBouton = 0; numeroDeBouton<labels.length; numeroDeBouton++)
		{
			JButton bouton = new JButton(""+labels[numeroDeBouton]);
			bouton.setFocusable(false);
			bouton.addActionListener(auditeurBoutons);
			this.add(bouton);	
		}
	}
	
}
