package data.io.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.jdom.xpath.XPath;
import org.xml.sax.SAXException;

import app.Env;
import data.Capacite;
import data.etre.Ennemi;
import data.etre.PJ;
import outils.io.XmlIO;

public class XmlEtreLoad {
	public static void chargerEtres() throws JDOMException, IOException, ParserConfigurationException, SAXException {
		org.jdom.Document	document 	= XmlIO.ouvrirFichierXml(Env.data_fichier_etres);
		org.jdom.Element	racine		= document.getRootElement();
		XPath 				xpa;
		org.jdom.Element	noeud;
		List<?>				liste;
		Iterator<?>			it;

		// ----------------------------------
		// CHARGER LES ETRES
		// ----------------------------------
		xpa		= XPath.newInstance("//etre");   
		liste	= xpa.selectNodes(racine) ;
		it		= liste.iterator();
		noeud	= null;
		while(it.hasNext()) {
			noeud		= (org.jdom.Element) it.next();
			chargerEtre(noeud);
		}
	}
	
	public static void chargerEtre(org.jdom.Element racine) throws ParserConfigurationException, SAXException, IOException, JDOMException {
		String	nom				= "";
		String	type			= "";
		String	tokenFileName	= "";

		nom						= XmlIO.getValeurElement("./@nom", racine);
		type					= XmlIO.getValeurElement("./@type", racine);
		
		if(Env.debug)			System.out.println("Etre : " + nom + " (" + type + ")");
		
		if(type.equals("Ennemi")) {
			String	origine			= "";
			int		niv_attribut	= 0;
			int		endurance		= 0;
			int		haine			= 0;
			int		parade			= 0;
			int		bouclier		= 0;
			int		armure			= 0;
			
			ArrayList<Capacite>	listeCapacites	= null;

			origine				= XmlIO.getValeurElement("./origine", racine);
			niv_attribut		= Integer.valueOf(XmlIO.getValeurElement("./niv_atrribut", racine));
			endurance			= Integer.valueOf(XmlIO.getValeurElement("./endurance", racine));
			haine				= Integer.valueOf(XmlIO.getValeurElement("./haine", racine));
			parade				= Integer.valueOf(XmlIO.getValeurElement("./parade", racine));
			bouclier			= Integer.valueOf(XmlIO.getValeurElement("./bouclier", racine));
			armure				= Integer.valueOf(XmlIO.getValeurElement("./armure", racine));
			
			tokenFileName		= XmlIO.getValeurElement("./token", racine);
			
			listeCapacites		= getListeCapacites(racine);
			
			Ennemi	e = new Ennemi(nom, tokenFileName, origine, niv_attribut, endurance, haine, parade, bouclier, armure, listeCapacites);
			Env.bdd.ajouteEnnemi(e);
			
		} else if(type.equals("PJ")) {
			String	culture			= XmlIO.getValeurElement("./culture", racine);
			int		endurance		= Integer.valueOf(XmlIO.getValeurElement("./endurance", racine));
			int		espoir			= Integer.valueOf(XmlIO.getValeurElement("./espoir", racine));
			
			tokenFileName			= XmlIO.getValeurElement("./token", racine);
			
			PJ e = new PJ(nom, tokenFileName, culture, endurance, espoir);
			Env.bdd.ajoutePJ(e);

		}
	}
	
	private static ArrayList<Capacite> getListeCapacites(org.jdom.Element racine) throws JDOMException {
		ArrayList<Capacite>	listeCapacites	= new ArrayList<Capacite>();

		String				nom		= "";

		Iterator<?>			it		= null;
		org.jdom.Element	noeud	= null;
		List<?>				liste	= null;
		XPath 				xpa		= null;

		xpa		= XPath.newInstance("//capacite_speciale");
		liste	= xpa.selectNodes(racine) ;
		it		= liste.iterator();
		while(it.hasNext()) {
			noeud 		= (org.jdom.Element) it.next();
			nom			= XmlIO.getValeurElement("./@nom", noeud);
			
			Capacite capaciteSpeciale	= Env.bdd.getCapaciteSpeciale(nom);
			if(capaciteSpeciale!=null)
				listeCapacites.add(capaciteSpeciale);
		}
		
		return listeCapacites;
	}
}
