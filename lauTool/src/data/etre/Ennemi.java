package data.etre;

public class Ennemi extends Etre {
	private String origine;
	private	int	niveau_atrribut;
	private	int	endurance;
	private int haine;
	private int parade;
	private int bouclier;
	private int armure;
	
	public Ennemi(String nom, String origine, int niveau_atrribut, int endurance, int haine, int parade, int bouclier, int armure) {
		super(nom);
		this.origine = origine;
		this.niveau_atrribut = niveau_atrribut;
		this.endurance = endurance;
		this.haine = haine;
		this.parade = parade;
		this.bouclier = bouclier;
		this.armure = armure;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public int getNiveau_atrribut() {
		return niveau_atrribut;
	}

	public void setNiveau_atrribut(int niveau_atrribut) {
		this.niveau_atrribut = niveau_atrribut;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getHaine() {
		return haine;
	}

	public void setHaine(int haine) {
		this.haine = haine;
	}

	public int getParade() {
		return parade;
	}

	public void setParade(int parade) {
		this.parade = parade;
	}

	public int getBouclier() {
		return bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}

	public int getArmure() {
		return armure;
	}

	public void setArmure(int armure) {
		this.armure = armure;
	}




}
