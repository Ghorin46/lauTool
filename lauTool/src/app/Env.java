package app;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import outils.images.IconeJdr;
import outils.images.ImageJdr;

public class Env {
	// ============================================================
	// APPLICATION
	// ============================================================
	public	static	Boolean		debug;
	
	public	static	App_LAU		app;
	public	static	Database	bdd;

	static {
		debug					= Boolean.FALSE;
	}
	
	// ============================================================
	// ENVIRONNEMENT : OS, REPERTOIRES...
	// ============================================================
	public	static	String		os_nom;
	public	static	String		appli_home;
	
	public	static	String		rep_ressources;
	public	static	String		rep_images;
	public	static	String		rep_icones;
	public	static	String		rep_tokens;
	public	static	String		rep_data;
	
	static {
		// ENVIRONNEMENT APPLICATIF
		os_nom					= System.getProperty("os.name");
		
		// DOSSIERS
		appli_home				= System.getProperty("user.dir");
		
		rep_ressources			= appli_home + File.separator + "ressources";
		rep_images				= rep_ressources + File.separator + "images";
		rep_tokens				= rep_ressources + File.separator + "tokens";
		rep_icones				= rep_ressources + File.separator + "icones";
		rep_data				= rep_ressources + File.separator + "data";
	}

	// ============================================================
	// FICHIERS DE DONNEES
	// ============================================================
	public	static	String		data_fichier_etres;
	public	static	String		data_fichier_capacites;

	static {
		// FICHIERS DE DONNEES
		data_fichier_etres		= rep_data + File.separator + "etres.xml";
		data_fichier_capacites	= rep_data + File.separator + "capacites.xml";

	}
	
	// ============================================================
	// ELEMENTS GRAPHIQUES
	// ============================================================
	public 	static Map<String, IconeJdr>		mapIconesAppli;			// ICONES DE L'APPLICATION
	public 	static Map<String, ImageJdr>		mapImagesAppli;			// IMAGES DE L'APPLICATION
	
	public	static	int	token_size_longueur;
	public	static	int	token_size_hauteur;
	public	static	int	token_image_size;
	public	static	int	token_texte_hauteur;
	
	public	static	Color	token_color_ennemi;
	public	static	Color	token_color_pj;
	public	static	Color	token_color_pnj;
	public	static	Color	token_color_animal;
	public	static	Color	token_color_autre;
	
	static {
		// ICONES APPLICATION
		mapIconesAppli	= new  TreeMap<String, IconeJdr>();
		mapIconesAppli.put("icone_appli",new IconeJdr(rep_icones + File.separator + "appli.png"));
		
		// TOKENS
		token_image_size		= 64;
		token_size_longueur		= token_image_size+200;
		token_size_hauteur		= token_image_size+1;
		token_texte_hauteur		= 20;
		
		// COULEURS DES PERSONNAGES
		token_color_pj			= Color.BLUE;
		token_color_pnj			= Color.BLACK;
		token_color_animal		= Color.GRAY;
		token_color_ennemi		= Color.RED;
		token_color_autre		= Color.WHITE;
	}
	
	public static ImageIcon getIconeAppli(String nom) {
		return mapIconesAppli.get(nom).getIcone();
	}

	// ============================================================
	// THEME : COULEURS, POLICES ...
	// ============================================================
	public 	static	String		theme_UI;
	
	public 	static	Color		desktop_couleur_fond	= new Color(90, 36, 36);
	
	public	static	Font		police_defaut;
	public	static	String		police_defaut_nom;
	public	static	int			police_defaut_taille;
	
	public	static	Font		police_token_titre;
	public	static	Font		police_token_texte;
	
	static {
		// THEME
		theme_UI				= "mdlaf.MaterialLookAndFeel";

		// COULEURS
		desktop_couleur_fond	= new Color(90, 36, 36);
		
		// POLICES
		police_defaut			= new Font("AndBasR.ttf", Font.PLAIN, 12);
		police_defaut_nom		= "AndBasR.ttf";
		police_defaut_taille	= 12;
		
		police_token_titre		= police_defaut.deriveFont(Font.BOLD);
		police_token_texte		= police_defaut;
	}

}
