package pl.golabm.service;

import pl.golabm.exceptions.FileFormatException;
import pl.golabm.model.Person;
import pl.golabm.repository.ContactRepository;
import pl.golabm.repository.PersonRepository;

import java.sql.SQLException;
import java.util.List;

public class MigrationService {

    private PersonRepository personRepository = new PersonRepository();
    private ContactRepository contactRepository = new ContactRepository();
    private ReadFiles readFiles = new ReadFiles();

    public void migrate(String filePath) throws FileFormatException {
        List<Person> persons = readFiles.readFiles(filePath).getPersons();

        for (Person person : persons) {
            try {
                Integer id = personRepository.insertPerson(person);
                person.getContact().setPersonId(id);
                contactRepository.insertContact(person.getContact());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
