package pl.golabm.fileReader;

import org.apache.commons.csv.CSVRecord;
import pl.golabm.model.Contact;

public class ContactFactory {

    public Contact createContact(CSVRecord csvRecord, Contact contact, Integer i) {
        if (csvRecord.get(i).matches("([0-9+-]*\\)*\\(*\\s*)+") && csvRecord.get(i).length() >= 9) {
            contact.addPhoneNumber(csvRecord.get(i));
        } else if (csvRecord.get(i).contains("@")) {
            contact.addEmail(csvRecord.get(i));
        } else if (csvRecord.get(i).matches("\\d+")) {
            contact.addICQ(csvRecord.get(i));
        } else {
            contact.addJabber(csvRecord.get(i));
        }
        return contact;
    }
}
