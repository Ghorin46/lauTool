package ihm;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import app.Env;
import data.Capacite;
import data.etre.Ennemi;

public class TokenEtreEnnemi extends TokenEtre {
	private static final long serialVersionUID = -4486707009579163967L;
	
	
	public TokenEtreEnnemi(Ennemi etre) {
		super(etre);
		
		afficheInfos();
	}

	protected void afficheInfos() {
		afficheInfosDebut();
		super.afficheInfos();
		afficheInfosFin();
	}

	@Override
	public void setTokenColor() {
		token_color	= Env.token_color_ennemi;
	}

	@Override
	public void ajouteBulles(Graphics g, Graphics2D g2d) {
		paintBulle(g, g2d, "Niv Attr", ((Ennemi)etre).getNiveau_atrribut(), 1, 1);
	}

	@Override
	public void ajouteInfosDetaillees() {
		int	no_ligne = 1;
		for(Capacite capaciteSpeciale:((Ennemi)etre).getListeCapacitesSpeciales()) {
			JLabel	lbNomCapaciteSpeciale	= new JLabel(capaciteSpeciale.getNom());
			lbNomCapaciteSpeciale.setFont(Env.police_token_texte);
			lbNomCapaciteSpeciale.setToolTipText("[" + capaciteSpeciale.getCout() + "] " + capaciteSpeciale.getEffet());
			int taille_texte 	= lbNomCapaciteSpeciale.getFont().getSize() * lbNomCapaciteSpeciale.getText().length();	// Taille du texte en pixels
//			lbNomCapaciteSpeciale.setAlignmentX(JLabel.CENTER);
//			lbNomCapaciteSpeciale.setAlignmentY(JLabel.CENTER);
			lbNomCapaciteSpeciale.setBounds(Env.token_image_size+2, 1 + (no_ligne * Env.token_texte_hauteur), taille_texte, Env.token_texte_hauteur);

			panel.add(lbNomCapaciteSpeciale);
			
			no_ligne++;
		}
				

		
	}

}
