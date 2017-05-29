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


			/**
			 * Receive notification of character data inside an element.
			 * <p>
			 * <p>By default, do nothing.  Application writers may override this
			 * method to take specific actions for each chunk of character data
			 * (such as adding the data to a node or buffer, or printing it to
			 * a file).</p>
			 *
			 * @param ch     The characters.
			 * @param start  The start position in the character array.
			 * @param length The number of characters to use from the
			 *               character array.
			 * @throws SAXException Any SAX exception, possibly
			 *                      wrapping another exception.
			 * @see ContentHandler#characters
			 */
/*			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
                String str = "";
                for (int i=0; i<length; i++) {
                    str += ch[start+i];
                }
			    System.out.println(str);
			}*/

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                String name = attributes.getValue("id");
                if (name != null && !name.isEmpty()) {
                    System.out.println(name);
                }
            }
        };

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		//parser.parse(new File("input.xml"), handler);
		parser.parse(new BufferedInputStream(new FileInputStream("input.xml")), handler);

	}
}
