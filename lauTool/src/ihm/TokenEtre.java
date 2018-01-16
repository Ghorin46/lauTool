package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

import app.Env;
import data.etre.Etre;

public abstract class TokenEtre extends Token {
	private static final long serialVersionUID = 1734220030547645104L;

	protected	Etre	etre;

	private	JLabel	lbNom;		// Nom affiché

	public TokenEtre(Etre etre) {
		super(etre.getNom(), etre.getNomFichierToken());
		this.etre = etre;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		
		// ----------------------------------------
		// COULEUR DE HIGHLIGHT
		// ----------------------------------------
		if(highlight)
			g2d.setColor(token_color);
		else
			g2d.setColor(Color.BLACK);

		// ----------------------------------------
		// DESSINER L'IMAGE
		// ----------------------------------------
		g2d.drawImage(imageToken.getImage(), 0, 0, null);
		
		// ----------------------------------------
		// CONTOUR DE L'IMAGE
		// ----------------------------------------		
		g.drawOval(0, 0, Env.token_image_size, Env.token_image_size);
		
		if(highlight) {
			g.drawOval(1, 1, (Env.token_image_size-2), (Env.token_image_size-2));
		}
		
		ajouteBulles(g, g2d);
		
		//if(this.panel!=null)
			this.panel.paintComponents(g);
	}

	public abstract void ajouteBulles(Graphics g, Graphics2D g2d);
	public abstract void ajouteInfosDetaillees();


	protected void paintBulle(Graphics g, Graphics2D g2d, String titre, int valeur, int posX, int posY) {
		Color	currentColor	= g2d.getColor();
		g2d.setColor(token_color);

		g.drawOval(posX, posY, 20, 20);
		
		g2d.setColor(currentColor);
	}

	protected void afficheInfos() {
		lbNom = new JLabel(etre.toString());
		
		lbNom.setToolTipText(etre.getNom());
		
//		@SuppressWarnings("rawtypes")
//		Map attributes = Env.police_token_titre.getAttributes();
//		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//		lbNom.setFont(Env.police_token_titre.deriveFont(attributes));

		lbNom.setFont(Env.police_token_titre);
		
		int taille_texte 	= lbNom.getFont().getSize() * lbNom.getText().length();	// Taille du texte en pixels
		lbNom.setAlignmentX(JLabel.CENTER);
		lbNom.setAlignmentY(JLabel.CENTER);
	//	lbNom.setBounds(1, Env.token_size-Env.token_texte_hauteur, taille_texte, Env.token_texte_hauteur);
		lbNom.setBounds(Env.token_image_size+2, 1, taille_texte, Env.token_texte_hauteur);

		panel.add(lbNom);
		
		ajouteInfosDetaillees();

	}

	
	public Etre getEtre() {
		return etre;
	}
	public void setEtre(Etre etre) {
		this.etre = etre;
	}

	public abstract void setTokenColor();

}
