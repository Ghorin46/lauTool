package app;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import outils.images.IconeJdr;

public class Env {
	public	static	Boolean		debug;
	public	static	App_LAU		app;
	public	static	Database	bdd;

	public	static	String		os_nom;
	public	static	String		appli_home;
	
	public	static	String		rep_ressources;
	public	static	String		rep_images;
	public	static	String		rep_icones;
	public	static	String		rep_data;
	
	public	static	String		data_fichier_etres;

	public 	static Map<String, IconeJdr>		mapIconesAppli;			// ICONES DE L'APPLICATION
	
	public 	static	String		theme_UI;
	
	public 	static	Color		desktop_couleur_fond	= new Color(90, 36, 36);
	
	public	static	Font		police_defaut;
	public	static	String		police_defaut_nom;
	public	static	int			police_defaut_taille;
	
	static {
		debug					= Boolean.FALSE;
		
		// ENVIRONNEMENT APPLICATIF
		os_nom					= System.getProperty("os.name");
		
		// DOSSIERS
		appli_home				= System.getProperty("user.dir");
		rep_ressources			= appli_home + File.separator + "ressources";
		rep_images				= rep_ressources + File.separator + "images";
		rep_icones				= rep_images + File.separator + "icones";
		rep_data				= rep_ressources + File.separator + "data";
		
		
		// FICHIERS DE DONNEES
		data_fichier_etres		= rep_data + File.separator + "etres.xml";
		
		// ICONES APPLICATION
		mapIconesAppli			= new  TreeMap<String, IconeJdr>();
		mapIconesAppli.put("icone_appli",new IconeJdr(rep_icones + File.separator + "appli.png"));

		// THEME
		theme_UI				= "mdlaf.MaterialLookAndFeel";
		
		desktop_couleur_fond	= new Color(90, 36, 36);
		
		
		police_defaut			= new Font("AndBasR.ttf", Font.PLAIN, 12);
		police_defaut_nom		= "AndBasR.ttf";
		police_defaut_taille	= 12;
	}
	
	public static ImageIcon getIconeAppli(String nom) {
		return mapIconesAppli.get(nom).getIcone();
	}
}
