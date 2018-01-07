package outils.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class IconeJdr {
	private		String					fichier;
	private		BufferedImage			image;
	private		ImageIcon				icone;

	// ==================================
	// CONSTRUCTEURS
	// ==================================
	public IconeJdr(String fichier) {
		this.fichier 	= fichier;
		this.image		= null;
		this.icone	 	= null;
	}

	// ==================================
	// METHODES
	// ==================================
	public void chargeImage() {
		if(image==null) {
			try {
				image 	= ImageIO.read(new File(fichier));
				icone		= new ImageIcon(image);
			} catch (IOException e) {
				System.out.println(System.getProperty("java.class.path").split(":")[0].toString());
				System.out.println("Erreur IconeJdr.chargeImage() : Fichier " + fichier + " inexistant");
				e.printStackTrace();
			}
		}
	}

	// ==================================
	// ACCESSEURS
	// ==================================
	public String getFichier() {
		return fichier;
	}
	public void setFichier(String fichier) {
		this.fichier 	= fichier;
		this.image		= null;
	}
	public BufferedImage getImage() {
		if(image==null)
			chargeImage();
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public ImageIcon getIcone() {
		if(icone==null)
			chargeImage();
		return icone;
	}
	public void setIcone(ImageIcon icone) {
		this.icone = icone;
	}

	// ==================================
	// REDEFINITION
	// ==================================
	public String toString() {
		return this.fichier;
	}
	public String toStringDetaille() {
		String chaine = this.fichier;
		if(image!=null) {
			chaine += "("+this.image.getWidth()+"x"+this.image.getHeight()+")";
		}
		return chaine;
	}
}
