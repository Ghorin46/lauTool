package data.etre;

import java.util.List;

import data.Capacite;

public class Ennemi extends Etre {
	private String origine;
	private	int	niveau_atrribut;
	private	int	endurance;
	private int haine;
	private int parade;
	private int bouclier;
	private int armure;
	
	private	List<Capacite>	listeCapacitesSpeciales;
	
	public Ennemi(String nom, String nomFichierToken, String origine, int niveau_atrribut, int endurance, int haine, int parade, int bouclier, int armure, List<Capacite> listeCapacitesSpeciales) {
		super(nom, nomFichierToken);
		this.origine = origine;
		this.niveau_atrribut = niveau_atrribut;
		this.endurance = endurance;
		this.haine = haine;
		this.parade = parade;
		this.bouclier = bouclier;
		this.armure = armure;
		
		this.listeCapacitesSpeciales = listeCapacitesSpeciales;
	}

	
	public List<Capacite> getListeCapacitesSpeciales() {
		return listeCapacitesSpeciales;
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
