package ihm;


import app.Env;
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
}
