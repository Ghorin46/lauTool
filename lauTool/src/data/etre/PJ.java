package data.etre;

public class PJ extends Etre {
	private String Culture;
	private	int	endurance;
	private int espoir;
	
	public PJ(String nom, String nomFichierToken, String culture, int endurance, int espoir) {
		super(nom, nomFichierToken);
		
		this.Culture	= culture;
		this.endurance	= endurance;
		this.espoir		= espoir;
	}

	public String getCulture() {
		return Culture;
	}

	public void setCulture(String culture) {
		Culture = culture;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getEspoir() {
		return espoir;
	}

	public void setEspoir(int espoir) {
		this.espoir = espoir;
	}

}
