package pl.golabm.fileReader;

import pl.golabm.model.Customer;

public interface IFileReader {

    Customer loadData(String path);
}
