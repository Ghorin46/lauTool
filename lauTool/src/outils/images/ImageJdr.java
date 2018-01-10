package outils.images;

import java.awt.image.BufferedImage;


public class ImageJdr {
	private		String					libelle;
	private		String					fichier;
	private		BufferedImage			image;
	
	public ImageJdr(String libelle, String fichier) {
		super();
		this.libelle	= libelle;
		this.fichier	= fichier;
		this.image		= OutilsImage.chargeImage(fichier);
	}

	public String getLibelle() {
		return libelle;
	}
	public String getFichier() {
		return fichier;
	}
	public BufferedImage getImage() {
		return image;
	}
}
