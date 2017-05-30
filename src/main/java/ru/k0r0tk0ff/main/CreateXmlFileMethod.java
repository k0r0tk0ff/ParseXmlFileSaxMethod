package ru.k0r0tk0ff.main;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by user on 5/30/2017.
 *
 * For single add /n or /n/r
 * writer.writeCharacters(System.getProperty("line.separator"));
 *
 *
 */
public class CreateXmlFileMethod {
    public static void main (String[] arg) throws ParserConfigurationException, IOException, SAXException,
            XMLStreamException, TransformerException {
        final XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("out.xml"), "UTF-8");
        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("root");
        writer.writeStartElement("font");
        writer.writeAttribute("size", "28");
        writer.writeCharacters("TimesNewRoman");
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();
    }
}
