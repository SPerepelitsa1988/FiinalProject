package com.telesens;

import com.thoughtworks.xstream.XStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XmlReader {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(new File("./person.xml")))) {
            StringBuilder xml = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                xml.append(line);
            }
            XStream xStream = new XStream();
            XStream.setupDefaultSecurity(xStream);
            xStream.allowTypes(new Class[] { Person.class});
            xStream.processAnnotations(Person.class);
            Person person = (Person)xStream.fromXML(xml.toString());

            System.out.println(person);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
