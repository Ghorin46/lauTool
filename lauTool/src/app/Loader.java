package app;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;

import data.io.xml.XmlCapaciteLoad;
import data.io.xml.XmlEtreLoad;

public class Loader {

	public Loader() {
		try {
			XmlCapaciteLoad.chargerCapacites();
			XmlEtreLoad.chargerEtres();
		} catch (JDOMException | IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	}
}
