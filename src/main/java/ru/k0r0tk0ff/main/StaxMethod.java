package ru.k0r0tk0ff.main;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by k0r0tk0ff on 5/29/2017.
 * Use XMLInputFactory
 */
public class StaxMethod {
    public static void main(String[] arg) throws XMLStreamException, FileNotFoundException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(
                new BufferedInputStream(new FileInputStream("input.xml")));

        while (parser.hasNext()) {
            int event = parser.next();
            /*if(event == XMLStreamConstants.START_ELEMENT) {
                System.out.println(parser.getLocalName());
            }*/
            if(event == XMLStreamConstants.CHARACTERS) {
                System.out.print(parser.getText());
            }
        }
    }
}
