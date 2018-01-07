package app;

import java.util.ArrayList;
import java.util.List;

import data.etre.Animal;
import data.etre.Ennemi;
import data.etre.PJ;
import data.etre.PNJ;

public class Database {
	private List<Ennemi> listeEtreEnemmi;
	private List<PNJ> listeEtrePNJ;
	private List<PJ> listeEtrePJ;
	private List<Animal> listeEtreAnimal;
	
	public Database() {
		super();
		listeEtreEnemmi	= new ArrayList<Ennemi>();
		listeEtrePNJ	= new ArrayList<PNJ>();
		listeEtrePJ	= new ArrayList<PJ>();
		listeEtreAnimal	= new ArrayList<Animal>();
		
	}
	public void ajouteEnemi(Ennemi enemi) {
		if(!listeEtreEnemmi.contains(enemi)) {
			listeEtreEnemmi.add(enemi);
		}
	}
	public void ajoutePNJ(PNJ pnj) {
		if(!listeEtrePNJ.contains(pnj)) {
			listeEtrePNJ.add(pnj);
		}
	}
	public void ajoutePJ(PJ pj) {
		if(!listeEtrePJ.contains(pj)) {
			listeEtrePJ.add(pj);
		}
	}
	public void ajouteAnimal(Animal animal) {
		if(!listeEtreAnimal.contains(animal)) {
			listeEtreAnimal.add(animal);
		}
	}

	
	public List<Ennemi> getListeEtreEnemmi() {
		return listeEtreEnemmi;
	}
	public List<PNJ> getListeEtrePNJ() {
		return listeEtrePNJ;
	}
	public List<PJ> getListeEtrePJ() {
		return listeEtrePJ;
	}
	public List<Animal> getListeEtreAnimal() {
		return listeEtreAnimal;
	}
	
	
}
