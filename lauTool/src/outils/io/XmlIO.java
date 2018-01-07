package outils.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

public class XmlIO {
	// ======================================================
	// FONCTIONS XML
	// ======================================================
	public static Element xml_creerElement(Element pere, String nom, String valeur) {
		Element element = new Element(nom);
		element.addContent(valeur);
		pere.addContent(element);

		return element;
	}
	public static Element xml_creerElement(Element pere, String nom) {
		Element element = new Element(nom);
		pere.addContent(element);

		return element;
	}
	public static void xml_creerAttribut(Element element, String nom, String valeur) {
		if(valeur==null)
			valeur = "";
		Attribute attribut = new Attribute(nom, valeur);
		element.setAttribute(attribut);
	}
	public	static String getValeurElement(String chemin, org.jdom.Element noeud) throws JDOMException {
		XPath xpa = XPath.newInstance(chemin);
		return xpa.valueOf(noeud);
	}

	// ======================================================
	// FICHIER XML
	// ======================================================
	public static org.jdom.Document ouvrirFichierXml(String nomFichier) throws JDOMException, IOException {
		SAXBuilder sxb 				= new SAXBuilder();
		File fichier				= new File(nomFichier);
		org.jdom.Document document 	= sxb.build(fichier);
		fichier						= null;
		return document;
	}
	public static void genererFichier(String nom, Document document) {
	    XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	    try {
	    	String 				fichier = nom;
	    	FileOutputStream	output	= new FileOutputStream(new File(fichier));
			sortie.output(document, output);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
