package data;

public class Capacite {
	private String	nom;
	private	int		cout;
	private	String	effet;
	
	public Capacite(String nom, int cout, String effet) {
		super();
		this.nom = nom;
		this.cout = cout;
		this.effet = effet;
	}

	public String getNom() {
		return nom;
	}

	public int getCout() {
		return cout;
	}

	public String getEffet() {
		return effet;
	}
	

	
}
