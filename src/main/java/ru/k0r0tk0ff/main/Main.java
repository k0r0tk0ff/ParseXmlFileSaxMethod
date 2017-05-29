package ru.k0r0tk0ff.main;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;

/**
 * Created by k0r0tk0ff on 5/29/17.
 *
 */

public class Main {
	public static void main(String[] arg) throws ParserConfigurationException, IOException, SAXException {

		DefaultHandler handler = new DefaultHandler() {

            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start parse XML...");
            }

            @Override
            public void endDocument() {
                System.out.println("Stop parse XML...");
            }

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
                String str = "";
                for (int i=0; i<length; i++) {
                    str += ch[start+i];
                }
			    System.out.print(str);
			}



            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                //show all characters in elements where attribute == "id"
                String name = attributes.getValue("id");
                if (name != null && !name.isEmpty()) {
                    System.out.print(name);
                }

                //show all elements, where element name != null
                //if(!qName.isEmpty()) System.out.println(qName);

                /*for (int i=0; i<attributes.getLength(); i++ ) {
                    attributes.getLocalName(i);
                    attributes.getValue(i).toString();
                }*/

/*                if(qName.equals("book")) {
                    for (int i=0; i<attributes.getLength(); i++ ) {
                        System.out.println(attributes.getQName(i));
                        System.out.println(attributes.getValue(i));
                    }
                }*/
            }
        };

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		//parser.parse(new File("input.xml"), handler);
		parser.parse(new BufferedInputStream(new FileInputStream("input.xml")), handler);

	}
}
