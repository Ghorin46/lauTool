package ihm;

import javax.swing.JLabel;

import app.Env;
import data.etre.Etre;

public class TokenEtre extends Token {
	private static final long serialVersionUID = 1734220030547645104L;

	private	Etre	etre;

	private	JLabel	lbNom;		// Nom affiché

	public TokenEtre(Etre etre) {
		super();
		this.etre = etre;
	}
	

	protected void afficheInfos() {
		lbNom 				= new JLabel(etre.toString());
		lbNom.setFont(Env.police_defaut_nom);
		int taille_texte 	= lbNom.getFont().getSize() * lbNom.getText().length();	// Taille du texte en pixels
		//int	texte_pos_x		= (fenetre_diametre/2)-(taille_texte/4)-5;
		//if(texte_pos_x<0)	texte_pos_x=1;
		lbNom.setAlignmentX(JLabel.CENTER);
		lbNom.setAlignmentY(JLabel.CENTER);
		lbNom.setBounds(5, 5, taille_texte, 20);
		//lbNom.setBounds(5, 5, 200, 40);

		panel.add(lbNom);
	}

	
	public Etre getEtre() {
		return etre;
	}
	public void setEtre(Etre etre) {
		this.etre = etre;
	}
}
