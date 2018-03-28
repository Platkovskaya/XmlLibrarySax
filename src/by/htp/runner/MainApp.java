package by.htp.runner;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.bean.Edition;
import by.htp.logic.LibrarySaxHandler;

public class MainApp {

	public static void main(String[] args)throws ParserConfigurationException, SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		LibrarySaxHandler handler = new LibrarySaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("resources/library.xml"));
		reader.setFeature("http://xml.org/sax/features/validation", true);
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		List<Edition> edition = handler.getEditionList();
		for(Edition e : edition) {
			System.out.println(e.getName());
		}
	}

}
