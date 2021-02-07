package ru.job4j.io.serialization;

import ru.job4j.io.Engine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JAXBUsage {

    public static void main(String[] args) throws JAXBException, IOException {

        String[] rooms835 = {"Kitchen", "Bedroom"};
        Flat flat835 = new Flat(false, 32, "Gennadi", rooms835, new Engine(23));
        JAXBContext context = JAXBContext.newInstance(Flat.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(flat835, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            Flat result = (Flat) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
