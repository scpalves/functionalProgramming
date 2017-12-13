package exercises.streams;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    public static final int MILLISECONDS_IN_DAY = (24 * 60 * 60 * 1000);
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String dateOfBirth;
    private final String emailAddress;
    private final Date dob;
    private int age;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Person(String firstName, String lastName, String address, String city, String dateOfBirth, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        try {
            this.dob = dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public long getAgeAtSpecificDate() {
        Date parse;
        try {
            parse = dateFormat.parse("2020-10-10");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return (parse.getTime() - dob.getTime()) / MILLISECONDS_IN_DAY;
    }


}
