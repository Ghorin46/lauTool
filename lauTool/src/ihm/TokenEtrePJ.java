package ihm;


import java.awt.Graphics;
import java.awt.Graphics2D;

import app.Env;
import data.etre.PJ;

public class TokenEtrePJ extends TokenEtre {
	private static final long serialVersionUID = -4486707009579163967L;
	
	
	public TokenEtrePJ(PJ etre) {
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
		token_color	= Env.token_color_pj;
	}

	@Override
	public void ajouteBulles(Graphics g, Graphics2D g2d) {
		
	}

	@Override
	public void ajouteInfosDetaillees() {
		// TODO Auto-generated method stub
		
	}
}
