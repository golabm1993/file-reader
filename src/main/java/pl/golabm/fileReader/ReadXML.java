package pl.golabm.fileReader;

import pl.golabm.model.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReadXML implements IFileReader {

    @Override
    public Customer loadData(String path) {
        File xmlFile = new File(path);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer) unmarshaller.unmarshal(xmlFile);
            return customer;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
