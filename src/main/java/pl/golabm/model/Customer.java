package pl.golabm.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "persons")
public class Customer {

    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return persons;
    }

    @XmlElement(name = "person")
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "persons=" + persons +
                '}';
    }
}
