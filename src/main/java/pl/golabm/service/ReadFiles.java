package pl.golabm.service;

import pl.golabm.exceptions.FileFormatException;
import pl.golabm.fileReader.IFileReader;
import pl.golabm.fileReader.ReadCSV;
import pl.golabm.fileReader.ReadXML;
import pl.golabm.model.Customer;

public class ReadFiles {

    public Customer readFiles(String filePath) throws FileFormatException {

        IFileReader fileReader = null;

        if (filePath.endsWith(".xml")) {
            fileReader = new ReadXML();
        } else if (filePath.endsWith(".csv")) {
            fileReader = new ReadCSV();
        } else {
            throw new FileFormatException("Incorrect file format.");
        }

        return fileReader.loadData(filePath);
    }
}
