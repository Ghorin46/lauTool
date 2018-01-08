package ihm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class OngletSystemeDeJeu extends JPanel {
	private static final long serialVersionUID = -7172977962917898946L;
	
	private	BorderLayout	layoutPanelPrincipal;
	
	private	JToolBar		panelHaut;

	public OngletSystemeDeJeu() {
		super();

		layoutPanelPrincipal	= new BorderLayout();
		this.setLayout(layoutPanelPrincipal);
		
		ajouteHaut();
		ajouteGauche();
		
	}
	
	private void ajouteHaut() {
		panelHaut = new JToolBar();
		panelHaut.setFloatable(false);
		panelHaut.setOrientation(SwingConstants.HORIZONTAL);
		
		panelHaut.add(new JButton("Personnages"));
		panelHaut.add(new JButton("Traits"));
		panelHaut.add(new JButton("Compétences"));
		panelHaut.add(new JButton("Voyage"));
		panelHaut.add(new JButton("Combat"));
		panelHaut.add(new JButton("Rencontre"));
		panelHaut.add(new JButton("Communauté"));
		panelHaut.add(new JButton("Phase de Communauté"));
		panelHaut.add(new JButton("Trésors"));
		

		// Ajouter la barre d'outils au panel général
		this.add(panelHaut, BorderLayout.NORTH);
	}
	private void ajouteGauche() {

	}

	/*
		panelGauche				= new JToolBar();
		panelGauche.setFloatable(false);
		panelGauche.setOrientation(SwingConstants.VERTICAL);

		// Ajouter la barre d'outils au panel général
		this.add(panelGauche, BorderLayout.WEST);
	 */
	
	
}
