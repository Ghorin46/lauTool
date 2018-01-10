package ihm;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import app.Env;
import outils.ihm.JPanelImage;
import outils.images.ImageJdr;

public class OngletCombat extends JPanel {
	private static final long serialVersionUID = -7172977962917898946L;
	
	private	BorderLayout		layoutPanelPrincipal;
	
	private	JToolBar			panelHaut;

	private	JPanelImage			panelCentre;
	private	ImageJdr			imagePosturesCombat;


	public OngletCombat() {
		super();

		layoutPanelPrincipal	= new BorderLayout();
		this.setLayout(layoutPanelPrincipal);
		
		ajouteHaut();
		ajouteGauche();
		ajouteCentre();
		ajouteBas();
		
	}
	
	private void ajouteHaut() {
		panelHaut = new JToolBar();
		panelHaut.setFloatable(false);
		panelHaut.setOrientation(SwingConstants.HORIZONTAL);
		
		panelHaut.add(new JButton("un"));
		panelHaut.add(new JButton("deux"));
		panelHaut.add(new JButton("trois"));
		panelHaut.add(new JButton("quatre"));
		panelHaut.add(new JButton("cinq"));
		panelHaut.add(new JButton("six"));
		panelHaut.add(new JButton("sept"));
		panelHaut.add(new JButton("huit"));
		panelHaut.add(new JButton("neuf"));
		

		// Ajouter la barre d'outils au panel général
		this.add(panelHaut, BorderLayout.NORTH);
	}
	private void ajouteGauche() {

	}

	private void ajouteCentre() {
		imagePosturesCombat	= new ImageJdr("Postures de Combat", Env.rep_images + File.separator + "postures_de_combat.jpg");
		panelCentre	= new JPanelImage(imagePosturesCombat);
		panelCentre.setLayout(null);
		
		Token token = new TokenEtreEnnemi(Env.bdd.getListeEtreEnemmi().get(0));
		token.setBounds(50, 50, 200, 200);
		panelCentre.add(token);
		token.setVisible(true);
		token.setEnabled(true);
		token.setSize(200, 200);

		
		this.add(panelCentre, BorderLayout.CENTER);
		
	}
	private void ajouteBas() {
		
	}
}
