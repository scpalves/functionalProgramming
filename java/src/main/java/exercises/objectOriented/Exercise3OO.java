package exercises.objectOriented;

import exercises.streams.AgeComparator;
import exercises.streams.Person;
import exercises.streams.StandardDeviation;
import exercises.streams.Statistics;

import java.util.*;

public class Exercise3OO implements Statistics {
    private final Collection<Person> persons;

    public Exercise3OO(Collection<Person> persons) {
        this.persons = persons;
    }

    @Override
    public long getNumberOfPeopleWithFirstName(String name) {
        int count = 0;
        for (Person person : persons) {
            if (person.getFirstName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<String, Long> getCompleteNameCount() {
        final Map<String, Long> result = new HashMap<>();
        for (Person person : persons) {
            Long count = result.get(person.getFirstName());
            if (count == null) {
                count = 0L;
            }
            result.put(person.getFirstName(), ++count);
        }
        return result;
    }

    @Override
    public Collection<String> getUniqueCities() {
        Collection<String> uniqueCities = new HashSet<>();

        for (Person person : persons) {
            uniqueCities.add(person.getCity());
        }
        return uniqueCities;
    }

    @Override
    public Collection<Person> getPersonsInCity(String springfield) {
        Collection<Person> liveInCity = new ArrayList<>();
        for (Person person : persons) {
            if (person.getCity().equals(springfield)) {
                liveInCity.add(person);
            }
        }
        return liveInCity;
    }

    @Override
    public Map<String, List<Person>> getPersonsGroupedByCity() {
        final Map<String, List<Person>> result = new HashMap<>();
        for (Person person : persons) {
            List<Person> personsInCity = result.get(person.getCity());
            if (personsInCity == null) {
                personsInCity = new ArrayList<>();
                result.put(person.getCity(), personsInCity);
            }
            personsInCity.add(person);

        }
        return result;
    }

    @Override
    public List<Person> getOldestPersonsInCity(String city) {
        // Really bad implementation. Surely this could be better!
        final List<Person> personsInCity = getPersonsGroupedByCity().get(city);

        Collections.sort(personsInCity, new AgeComparator());
        Person oldest = personsInCity.get(0);

        final List<Person> peopleOfOldestAge = new ArrayList<>();
        for (Person person : personsInCity) {
            if (person.getDateOfBirth().equals(oldest.getDateOfBirth())) {
                peopleOfOldestAge.add(person);
            }
        }

        return peopleOfOldestAge;
    }

    @Override
    public String getBiggestCity() {
        Map<String, List<Person>> personsGroupedByCity = getPersonsGroupedByCity();
        String city = null;
        int maxSize = 0;
        for (Map.Entry<String, List<Person>> entry : personsGroupedByCity.entrySet()) {
            if (entry.getValue().size() > maxSize) {
                maxSize = entry.getValue().size();
                city = entry.getKey();
            }
        }
        return city;
    }

    @Override
    public String getCityWithHighestStandardDeviation() {
        Map<String, List<Person>> personsGroupedByCity = getPersonsGroupedByCity();
        String city = null;
        double maxStdDev = 0.0;


        for (Map.Entry<String, List<Person>> entry : personsGroupedByCity.entrySet()) {
            // convert persons to ages
            List<Long> ages = convertPersonsToAges(entry.getValue());
            double stdDev = StandardDeviation.calculateStdDeviation(ages);
            if (stdDev > maxStdDev) {
                maxStdDev = stdDev;
                city = entry.getKey();
            }
        }
        return city;
    }


    @Override
    public String getCityWithLowestStandardDeviation() {
        Map<String, List<Person>> personsGroupedByCity = getPersonsGroupedByCity();
        String city = null;
        double minStdDev = Double.MAX_VALUE;


        for (Map.Entry<String, List<Person>> entry : personsGroupedByCity.entrySet()) {
            // convert persons to ages
            List<Long> ages = convertPersonsToAges(entry.getValue());
            double stdDev = StandardDeviation.calculateStdDeviation(ages);
            if (stdDev < minStdDev) {
                minStdDev = stdDev;
                city = entry.getKey();
            }
        }
        return city;
    }

    @Override
    public Double getHighestStandardDeviation() {
        Map<String, List<Person>> personsGroupedByCity = getPersonsGroupedByCity();
        double maxStdDev = 0.0;


        for (Map.Entry<String, List<Person>> entry : personsGroupedByCity.entrySet()) {
            // convert persons to ages
            List<Long> ages = convertPersonsToAges(entry.getValue());
            double stdDev = StandardDeviation.calculateStdDeviation(ages);
            if (stdDev > maxStdDev) {
                maxStdDev = stdDev;
            }
        }
        return maxStdDev;
    }

    private List<Long> convertPersonsToAges(List<Person> persons) {
        List<Long> ages = new ArrayList<>();

        for (Person person : persons) {
            ages.add(person.getAgeAtSpecificDate());
        }

        return ages;
    }
}
