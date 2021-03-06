package ihm;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import app.Env;

public class Bureau extends JFrame {
	private static final long serialVersionUID = 590402232418031275L;

	private	JTabbedPane 		onglets;
	private	OngletSystemeDeJeu	onglet_1;
	private	JPanel				onglet_2;
	private	OngletCombat		onglet_3;
	private	JPanel				onglet_4;
	private	JPanel				onglet_5;
	private	JDesktopPane		onglet_6;
	
	public Bureau() throws HeadlessException {
		super();
		
		setTitle("LAU Tool");
		setSize(1400, 950);
		
		gererFermeture();
		
		// Affichage en plein écran
		setVisible(true);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		
		
		setIconImage(Env.getIconeAppli("icone_appli").getImage());
		
		
		// Contenu de la fenêtre
		onglets				= new JTabbedPane();
		
		onglet_1			= new OngletSystemeDeJeu();
		onglet_2			= new JPanel();
		onglet_3			= new OngletCombat();
		onglet_4			= new JPanel();
		onglet_5			= new JPanel();
		onglet_6			= new JDesktopPane();


		onglets.addTab("Système de jeu", onglet_1);
		onglets.addTab("Bestiaire", onglet_2);
		onglets.addTab("Combat", onglet_3);
		onglets.addTab("Voyage", onglet_4);
		onglets.addTab("Rencontre", onglet_5);
		onglets.addTab("Bureau", onglet_6);
		
		onglet_6.setBackground(Env.desktop_couleur_fond);

		onglets.setVisible(true);
		onglets.setOpaque(true);
		onglets.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		getContentPane().add(onglets);

		this.repaint();
	}
	
	private void gererFermeture() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fermerApplication();
			}
		});
	}
	public void fermerApplication() {
		app.Env.app = null;
		this.dispose();
	}
}
