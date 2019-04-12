package pl.golabm.fileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import pl.golabm.model.Contact;
import pl.golabm.model.Customer;
import pl.golabm.model.Person;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadCSV implements IFileReader {
    private final ContactFactory contactFactory = new ContactFactory();

    @Override
    public Customer loadData(String path) {

        Reader reader;
        CSVParser csvParser = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Customer customer = new Customer();

        for (CSVRecord csvRecord : csvParser) {

            Integer age;
            try {
                age = Integer.parseInt(csvRecord.get(2));
            } catch (NumberFormatException e) {
                age = null;
            }

            Person person = new Person(csvRecord.get(0), csvRecord.get(1), age, csvRecord.get(3));
            Contact contact = new Contact();

            for (int i = 4; i < csvRecord.size(); i++) {
                contact = contactFactory.createContact(csvRecord, contact, i);
            }
            person.setContact(contact);
            customer.addPerson(person);
        }
        return customer;
    }
}
