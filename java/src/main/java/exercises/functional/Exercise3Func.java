package exercises.functional;


import exercises.streams.Person;
import exercises.streams.StandardDeviation;
import exercises.streams.Statistics;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Exercise3Func implements Statistics {
    private final Collection<Person> persons;

    public Exercise3Func(Collection<Person> persons) {
        this.persons = persons;
    }

    @Override
    public long getNumberOfPeopleWithFirstName(String firstName) {
        final Predicate<Person> matchesFirstName =
                p -> p.getFirstName().equalsIgnoreCase(firstName);
        return persons.stream()
                .filter(matchesFirstName)
                .count();
    }

    @Override
    public Map<String, Long> getCompleteNameCount() {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getFirstName, Collectors.counting()));
    }

    @Override
    public Collection<String> getUniqueCities() {
        return persons.stream()
                .map(Person::getCity)
                .distinct()
                .collect(toList());
    }

    @Override
    public Collection<Person> getPersonsInCity(String cityName) {
        final Predicate<Person> isFromThisCity = p -> p.getCity().equalsIgnoreCase(cityName);

        return persons.stream()
                .filter(isFromThisCity)
                .collect(toList());
    }

    @Override
    public Map<String, List<Person>> getPersonsGroupedByCity() {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public List<Person> getOldestPersonsInCity(String city) {
        final Predicate<Person> isFromThisCity = p -> p.getCity().equalsIgnoreCase(city);

        final Map<Long, List<Person>> groupedByAge = persons.stream()
                .filter(isFromThisCity)
                .collect(Collectors.groupingBy(Person::getAgeAtSpecificDate));

        final Long oldestAge = groupedByAge.keySet().stream()
                .max(Long::compareTo)
                .get();
        return groupedByAge.get(oldestAge);
    }

    @Override
    public String getBiggestCity() {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get().getKey();

    }

    @Override
    public String getCityWithHighestStandardDeviation() {
        final Map<String, List<Long>> agesGroupedByCity = getAgesPerCity();

        Map<String, Double> standardDevByCity = new HashMap<>();
        agesGroupedByCity.keySet()
                .forEach((k) ->
                        standardDevByCity.put(k, StandardDeviation.calculateStdDeviation(agesGroupedByCity.get(k))));


        return standardDevByCity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .findFirst()
                .get().getKey();
    }

    @Override
    public String getCityWithLowestStandardDeviation() {
        return null;
    }

    @Override
    public Double getHighestStandardDeviation() {
        final Map<String, List<Long>> agesPerCity = getAgesPerCity();
        Map<String, Double> standardDevByCity = new HashMap<>();
        agesPerCity.keySet()
                .forEach((k) ->
                        standardDevByCity.put(k, StandardDeviation.calculateStdDeviation(agesPerCity.get(k))));


        return standardDevByCity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .findFirst()
                .get().getValue();
    }

    private Map<String, List<Long>> getAgesPerCity() {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getCity,
                        Collectors.mapping(Person::getAgeAtSpecificDate,
                                Collectors.toList())));
    }
}
