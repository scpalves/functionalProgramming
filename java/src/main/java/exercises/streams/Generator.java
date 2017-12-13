package exercises.streams;

import org.fluttercode.datafactory.impl.DataFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Generator {
    public static void main(String[] args) throws FileNotFoundException {
        DataFactory dataFactory = new DataFactory();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");


        File names = new File("src/main/resources/names.csv");
        names.getParentFile().mkdirs();
        try (FileWriter fileWriter = new FileWriter(names)) {
            for (int i = 0; i < 30000; i++) {
                String firstName = dataFactory.getFirstName();
                String lastName = dataFactory.getLastName();
                String address1 = dataFactory.getAddress();
                String city = dataFactory.getCity();
                String email = dataFactory.getEmailAddress();
                Date dateOfBirth = dataFactory.getBirthDate();
                fileWriter.write(firstName + ";" + lastName + ";" + address1 + ";" + city + ";" + df.format(dateOfBirth) + ";" + email);
                fileWriter.write("\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
