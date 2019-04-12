package pl.golabm;

import pl.golabm.exceptions.FileFormatException;
import pl.golabm.service.MigrationService;

public class App {
    public static void main(String[] args) {
        try {
            new MigrationService().migrate(args[0]);
        } catch (FileFormatException e) {
            System.out.println("Unsupported file format.");
        }
    }
}
