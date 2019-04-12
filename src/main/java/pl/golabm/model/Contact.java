package pl.golabm.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Contact {

    private List<String> phoneNumbers = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    private List<String> icqs = new ArrayList<>();
    private List<String> jabbers = new ArrayList<>();
    private Integer personId;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @XmlElement(name = "phone")
    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<String> getEmails() {
        return emails;
    }

    @XmlElement(name = "email")
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getIcqs() {
        return icqs;
    }

    @XmlElement(name = "icq")
    public void setIcqs(List<String> icqs) {
        this.icqs = icqs;
    }

    public List<String> getJabbers() {
        return jabbers;
    }

    @XmlElement(name = "jabber")
    public void setJabbers(List<String> jabbers) {
        this.jabbers = jabbers;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    public void addICQ(String icq) {
        icqs.add(icq);
    }

    public void addJabber(String jabber) {
        jabbers.add(jabber);
    }

}
