package exercises.streams;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class AgeComparator implements Comparator<Person> {
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public int compare(Person o1, Person o2) {
        try {
            Date dateOfBirth1 = df.parse(o1.getDateOfBirth());
            Date dateOfBirth2 = df.parse(o2.getDateOfBirth());

            return dateOfBirth1.before(dateOfBirth2) ? -1 : (dateOfBirth1.after(dateOfBirth2) ? 1 : 0);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
