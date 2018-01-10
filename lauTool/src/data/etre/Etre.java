package data.etre;

public class Etre {
	private	String	nom;
	private String 	nomFichierToken;

	public Etre(String nom, String nomFichierToken) {
		super();
		this.nom = nom;
		this.nomFichierToken = nomFichierToken;
	}

	public String getNom() {
		return nom;
	}
	public String getNomFichierToken() {
		return nomFichierToken;
	}


	public String toString() {
		return this.nom;
	}
}
