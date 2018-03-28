package by.htp.logic;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.bean.Edition;
import by.htp.enumeration.TagName;

public class LibrarySaxHandler extends DefaultHandler {
	private List<Edition> editionList = new ArrayList<Edition>();
	private Edition edition;
	private StringBuilder text;

	public List<Edition> getEditionList() {
		return editionList;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName:" + localName + ", qName: " + qName);

		text = new StringBuilder();
		if (qName.equals("edition")) {
			edition = new Edition();
			edition.setId((Integer.parseInt(attributes.getValue("id"))));
		}
	}

	@Override
	public void characters(char[] buffer, int start, int length) throws SAXException {
		text.append(buffer, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		TagName tagName = TagName.valueOf(qName.toUpperCase());
		switch (tagName) {

		case TYPE:
			edition.setType(text.toString());
			break;

		case NAME:
			edition.setName(text.toString());
			break;

		case AUTHOR:
			edition.setAuthor(text.toString());
			break;

		case YEAR:
			edition.setYear(Integer.parseInt(text.toString()));
			break;

		case COUNT:
			edition.setCount(Integer.parseInt(text.toString()));
			break;

		case READATHOME:
			edition.setReadAtHome(text.toString());
			break;

		case COUNTOFREADINGDAYS:
			edition.setCountOfReadingDays(Integer.parseInt(text.toString()));
			break;

		case EDITION:
			editionList.add(edition);
			edition = null;
			break;
		}
	}

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}

}
