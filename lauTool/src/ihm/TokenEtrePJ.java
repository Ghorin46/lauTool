package ihm;


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
}
