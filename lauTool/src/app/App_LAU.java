package app;

import java.util.Locale;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ihm.Bureau;

public class App_LAU {

	public App_LAU() {
		super();
		
		// INITIALISATION APPLI
		Locale.setDefault(Locale.FRENCH);
		try {
			UIManager.setLookAndFeel(Env.theme_UI);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} 
		
		
		// CHARGEMENT DONNEES
		Env.bdd = new Database();
		new Loader();
		
		// LANCEMENT IHM
		new Bureau();
	}

	public static void main(String[] args) {
		new App_LAU();
	}
}
