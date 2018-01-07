package data.etre;

public class Etre {
	private	String	nom;

	public Etre(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return this.nom;
	}
}
