package pl.golabm.repository;

import pl.golabm.model.Contact;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ContactRepository extends AbstractDAO {

    public ContactRepository() {
        super();
    }

    public void insertContact(Contact contact) throws SQLException, ClassNotFoundException {
        execStatement(contact, contact.getPhoneNumbers(), 2);
        execStatement(contact, contact.getEmails(), 1);
        execStatement(contact, contact.getIcqs(), 0);
        execStatement(contact, contact.getJabbers(), 3);
    }

    private void execStatement(Contact contact, List<String> contactList, int i) throws SQLException, ClassNotFoundException {
        Statement statement = getStatement();
        if (contactList != null) {
            for (String contact1 : contactList) {
                statement.executeUpdate("INSERT into contacts(id_customer, type, contact) values ("
                        + contact.getPersonId() + ", " + i + ", \'" + contact1 + "\')");
            }
        }
    }
}
