package outils.images;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class OutilsImage {
	// ==================================
	// OUVERTURE D'IMAGE
	// ==================================
	public static BufferedImage chargeImage(String nomFichier) {
		try {
			BufferedImage	image			= ImageIO.read(new File(nomFichier));
			return image;
		} catch (IOException e) {
			System.out.println("ImageEtre : Erreur IOException de chargement de l'image " + nomFichier);
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e2) {
			System.out.println("ImageEtre : Erreur IllegalArgumentException de chargement de l'image " + nomFichier);
			e2.printStackTrace();
			return null;
		}
	}

	// ==================================
	// COPIE D'ECRAN
	// ==================================
	public static Image getImage(Component component){
		if(component==null)
			return null;
		int width 				= component.getWidth();
		int height 				= component.getHeight();
		BufferedImage 	image 	= new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D 		g 		= image.createGraphics();
		component.paintAll(g);
		g.dispose();
		
		return image;
	}
	public static void sauveImage(Image img, String nomFichier) {
		try {
		    File outputfile = new File(nomFichier);
		    ImageIO.write((RenderedImage) img, "png", outputfile);
		} catch (IOException e) {
		    System.out.println("Impossible de sauver l'image, erreur :  "+e);
		}
	}

	// ==================================
	// CONVERSION
	// ==================================
	public static BufferedImage imageIconToBufferedImage(ImageIcon icone) {
		return (BufferedImage)icone.getImage();
	}
	public static ImageIcon bufferedImageToImageIcon(BufferedImage image) {
		return new ImageIcon(image);
	}
	public static BufferedImage ImageToBufferedImage(Image image) {
		if( image instanceof BufferedImage ) {
			return( (BufferedImage)image );
		} else {
			/** On s'assure que l'image est complètement chargée */
			image = new ImageIcon(image).getImage();
			/** On crée la nouvelle image */
			BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB );
			Graphics g = bufferedImage.createGraphics();
			g.drawImage(image,0,0,null);
			g.dispose();
			return( bufferedImage );
		} 
	}
}
