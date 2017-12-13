package exercises.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Loader {
    private final File dataFile;

    public Loader(File dataFile) {
        this.dataFile = dataFile;
    }

    public Collection<Person> readPersons() {
        Collection<Person> result = new ArrayList<>();
        try (FileReader fileReader = new FileReader(dataFile);
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(";");
                String firstName = tokens[0];
                String lastName = tokens[1];
                String address = tokens[2];
                String city = tokens[3];
                String dob = tokens[4];
                String email = tokens[5];
                Person p = new Person(firstName, lastName, address, city, dob, email);
                result.add(p);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}