package data.io.xml;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.jdom.xpath.XPath;
import org.xml.sax.SAXException;

import app.Env;
import data.Capacite;
import outils.io.XmlIO;

public class XmlCapaciteLoad {
	public static void chargerCapacites() throws JDOMException, IOException, ParserConfigurationException, SAXException {
		org.jdom.Document	document 	= XmlIO.ouvrirFichierXml(Env.data_fichier_capacites);
		org.jdom.Element	racine		= document.getRootElement();
		XPath 				xpa;
		org.jdom.Element	noeud;
		List<?>				liste;
		Iterator<?>			it;

		// ----------------------------------
		// CHARGER LES CAPACITES SPECIALES DES ENNEMIS
		// ----------------------------------
		xpa		= XPath.newInstance("//capacite_speciale");   
		liste	= xpa.selectNodes(racine) ;
		it		= liste.iterator();
		noeud	= null;
		while(it.hasNext()) {
			noeud		= (org.jdom.Element) it.next();
			chargerCapaciteSpeciale(noeud);
		}
	}
	
	public static void chargerCapaciteSpeciale(org.jdom.Element racine) throws ParserConfigurationException, SAXException, IOException, JDOMException {
		String				nom		= "";
		int					cout	= 0;
		String				effet	= "";

		nom			= XmlIO.getValeurElement("./@nom", racine);
		cout		= Integer.valueOf(XmlIO.getValeurElement("./cout", racine));
		effet		= XmlIO.getValeurElement("./effet", racine);
		
		Env.bdd.ajouteCapaciteSpeciale(new Capacite(nom, cout, effet));
	}
	

}
