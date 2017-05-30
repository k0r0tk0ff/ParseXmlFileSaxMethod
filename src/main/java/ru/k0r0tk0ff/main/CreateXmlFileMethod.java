package ru.k0r0tk0ff.main;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

        writer.writeStartElement("entry");
        writer.writeStartElement("field");
        writer.writeCharacters("aaafff");
        writer.writeEndElement();
        writer.writeEndElement();

        writer.writeStartElement("entry");
        writer.writeStartElement("field");
        writer.writeCharacters("dddRRR");
        writer.writeEndElement();
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndDocument();

        File stylesheet = new File("Transform.xslt");
        File datafile = new File("out.xml");

        DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = factory2.newDocumentBuilder();
        Document document2 = builder2.parse(datafile);

        // Use a Transformer for output
        TransformerFactory tFactory = TransformerFactory.newInstance();
        StreamSource stylesource = new StreamSource(stylesheet);

        Transformer transformer = tFactory.newTransformer(stylesource);
        //transformer.setParameter("format-pretty-print", true);
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");


        DOMSource source = new DOMSource(document2);
        StreamResult result = new StreamResult(System.out);

        //for show on screen
        transformer.transform(source, result);

        //for write to file
        transformer.transform(source,
                new StreamResult(
                        new FileOutputStream("temp.xml")
                )
        );
    }
}
