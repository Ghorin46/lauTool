package ihm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import data.etre.Ennemi;

public class TokenEtreEnnemi extends Token {
	private static final long serialVersionUID = -4486707009579163967L;
	
	private	Ennemi	etre;
	
	private	JPanel	panel;
	private	JLabel	lbNom;		// Nom affiché
	
	public TokenEtreEnnemi(Ennemi etre) {
		super();
		this.etre = etre;
		
		afficheInfos();
		
/*		setLocation(5, 5);
		setSize(200, 200);
		setVisible(true);
*/
	}
	
	protected void afficheInfos() {
		panel = new JPanel();
		panel.setLayout(null);
		
		lbNom 				= new JLabel(etre.toString()+"aaa");
		//lbNom.setFont(Env.police_defaut);
		int taille_texte 	= lbNom.getFont().getSize() * lbNom.getText().length();	// Taille du texte en pixels
		//int	texte_pos_x		= (fenetre_diametre/2)-(taille_texte/4)-5;
		//if(texte_pos_x<0)	texte_pos_x=1;
		lbNom.setAlignmentX(JLabel.CENTER);
		lbNom.setAlignmentY(JLabel.CENTER);
		//lbNom.setBounds(5, 5, taille_texte, 20);
		lbNom.setBounds(5, 5, 200, 40);

		panel.add(lbNom);

		setContentPane(panel);
		
		ToolTipManager.sharedInstance().setInitialDelay(0);
		ToolTipManager.sharedInstance().setDismissDelay(8000);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//if(this.panel!=null)
			this.panel.paintComponents(g);
	}
}
