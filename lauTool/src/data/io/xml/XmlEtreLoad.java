package data.io.xml;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.jdom.xpath.XPath;
import org.xml.sax.SAXException;

import app.Env;
import data.etre.Ennemi;
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
		String	origine			= "";
		int		niv_attribut	= 0;
		int		endurance		= 0;
		int		haine			= 0;
		int		parade			= 0;
		int		bouclier		= 0;
		int		armure			= 0;

		nom						= XmlIO.getValeurElement("./@nom", racine);
		type					= XmlIO.getValeurElement("./@type", racine);
		
		if(Env.debug)			System.out.println("Etre : " + nom + " (" + type + ")");
		
		if(type.equals("Ennemi")) {
			
			origine				= XmlIO.getValeurElement("./@origine", racine);
			
			niv_attribut		= Integer.valueOf(XmlIO.getValeurElement("./niv_atrribut", racine));
			endurance			= Integer.valueOf(XmlIO.getValeurElement("./endurance", racine));
			haine				= Integer.valueOf(XmlIO.getValeurElement("./haine", racine));
			parade				= Integer.valueOf(XmlIO.getValeurElement("./parade", racine));
			bouclier			= Integer.valueOf(XmlIO.getValeurElement("./bouclier", racine));
			armure				= Integer.valueOf(XmlIO.getValeurElement("./armure", racine));
					
			Ennemi	e = new Ennemi(nom, origine, niv_attribut, endurance, haine, parade, bouclier, armure);
			Env.bdd.ajouteEnemi(e);
		}
	}
}
