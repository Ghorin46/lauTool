package ihm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import data.etre.Ennemi;

public class TokenEtreEnnemi extends TokenEtre {
	private static final long serialVersionUID = -4486707009579163967L;
	
	
	
	public TokenEtreEnnemi(Ennemi etre) {
		super(etre);
		
		afficheInfos();
		
/*		setLocation(5, 5);
		setSize(200, 200);
		setVisible(true);
*/
	}
	

	protected void afficheInfos() {
		afficheInfosDebut();
		super.afficheInfos();
		afficheInfosFin();
	}


	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//if(this.panel!=null)
			this.panel.paintComponents(g);
	}
}
