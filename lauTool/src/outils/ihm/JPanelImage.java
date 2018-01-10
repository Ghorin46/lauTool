package outils.ihm;


import java.awt.Graphics;

import javax.swing.JPanel;

import outils.images.ImageJdr;

public class JPanelImage extends JPanel {
	private static final long serialVersionUID = 548551178103917254L;

	private ImageJdr image;

	public JPanelImage(ImageJdr image) {
		super();
		this.image = image;
	}


	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), 0, 0, this); 
    }
}