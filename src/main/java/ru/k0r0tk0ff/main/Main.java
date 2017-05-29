package ru.k0r0tk0ff.main;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by k0r0tk0ff on 5/29/17.
 *
 */

public class Main {
	public static void main(String[] arg) throws ParserConfigurationException, IOException, SAXException {

		DefaultHandler handler = new DefaultHandler() {

			/**
			 * Receive notification of the start of an element.
			 * <p>
			 * <p>By default, do nothing.  Application writers may override this
			 * method in a subclass to take specific actions at the start of
			 * each element (such as allocating a new tree node or writing
			 * output to a file).</p>
			 *
			 * @param uri        The Namespace URI, or the empty string if the
			 *                   element has no Namespace URI or if Namespace
			 *                   processing is not being performed.
			 * @param localName  The local name (without prefix), or the
			 *                   empty string if Namespace processing is not being
			 *                   performed.
			 * @param qName      The qualified name (with prefix), or the
			 *                   empty string if qualified names are not available.
			 * @param attributes The attributes attached to the element.  If
			 *                   there are no attributes, it shall be an empty
			 *                   Attributes object.
			 * @throws SAXException Any SAX exception, possibly
			 *                      wrapping another exception.
			 * @see ContentHandler#startElement
			 *
			 */

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
				//String name = attributes.getValue("name");
				String name = attributes.getValue("name");
				//if(name != null && !name.isEmpty())) {
				if(name != null) {
					System.out.println(name);
				}
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
		/*	@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
*//*				String str = "";
				for (int i = 0; 1 < length; i++) {
					str += ch[start+i];
				}
				System.out.println(str);*//*


				//System.out.println(ch);
				System.out.print(ch);
			}*/
		};

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File("HPSUM_InstallDetails.xml"), handler);
		//parser.parse(new InputSource(new FileInputStream("1.xml")), handler);

	}
}
