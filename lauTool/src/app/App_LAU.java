package app;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.swing.UIManager;

import ihm.Bureau;

public class App_LAU {

	public App_LAU() {
		super();
		
		// INITIALISATION ENVIRONNEMENT ET THEME IHM
		ajusteEnvironnement();
		ajusteTheme();
		
		// CHARGEMENT DONNEES
		Env.bdd = new Database();
		new Loader();
		
		// LANCEMENT IHM
		new Bureau();
	}

	public static void ajusteEnvironnement() {
		Locale.setDefault(Locale.FRENCH);
	}
	
	public static void ajusteTheme() {
		// THEME DE SWING
		//try {
		//	UIManager.setLookAndFeel(Env.theme_UI);
		//	
		//} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
		//	e.printStackTrace();
		//} 

		// POLICE PAR DEFAUT
		Font font	= null;
		try {
			font								= Font.createFont(Font.TRUETYPE_FONT, new File(Env.rep_ressources+File.separator+"font"+File.separator+Env.police_defaut_nom));
			if(font!=null) {
				font							= font.deriveFont(Font.PLAIN, Env.police_defaut_taille);
			} else {
				font							= UIManager.getFont("TextField.font");
				if(font==null) {
					font						= new Font("Segoe UI", Font.PLAIN, Env.police_defaut_taille);
				} else {
					font						= new Font("Segoe UI", Font.PLAIN, Env.police_defaut_taille);
				}
			}
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Env.police_defaut				= font;
		
		// DEFINIR LA POLICE POUR CHAQUE COMPOSANT IHM
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key 		= keys.nextElement();
			Object value 	= UIManager.get (key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put (key, font);
			}
		}
	}

	public static void main(String[] args) {
		new App_LAU();
	}
}
