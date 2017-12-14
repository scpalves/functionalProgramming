package exercises;


import exercises.objectOriented.Exercise3OO;
import exercises.streams.Loader;
import exercises.streams.Person;
import exercises.streams.Statistics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Exercise3Test {
    private Statistics statistics;

    @Before
    public void setUp() {
        Loader loader = new Loader(new File("src/main/resources/names.csv"));
        Collection<Person> persons = loader.readPersons();

        // TODO this implementation uses Java 7
        statistics = new Exercise3OO(persons);
    }

    @Test
    public void verifyNameCount() {
        Assert.assertEquals(71, statistics.getNumberOfPeopleWithFirstName("Dave"));
        Assert.assertEquals(56, statistics.getNumberOfPeopleWithFirstName("Sam"));
        Assert.assertEquals(58, statistics.getNumberOfPeopleWithFirstName("Sally"));
    }

    @Test
    public void verifyLivesInCity() {
        Collection<Person> personsInCity = statistics.getPersonsInCity("Springfield");
        Assert.assertEquals(64, personsInCity.size());
    }

    @Test
    public void verifyUniqueCities() {
        Collection<String> uniqueCities = statistics.getUniqueCities();
        Assert.assertEquals(477, uniqueCities.size());
    }

    @Test
    public void verifyCompleteNameCount() {
        Map<String, Long> completeNameCount = statistics.getCompleteNameCount();

        Assert.assertEquals(71, completeNameCount.get("Dave").intValue());
        Assert.assertEquals(56, completeNameCount.get("Sam").intValue());
    }

    @Test
    public void verifyPeopleInCities() {
        Map<String, List<Person>> personsGroupedByCity = statistics.getPersonsGroupedByCity();
        Assert.assertEquals(64, personsGroupedByCity.get("Springfield").size());
    }

    @Test
    public void verifyOldestPeople() {
        List<Person> oldestPersons = statistics.getOldestPersonsInCity("Lumpkin");
        Assert.assertEquals(2, oldestPersons.size());
        Assert.assertEquals("Jeffery", oldestPersons.get(0).getFirstName());
        Assert.assertEquals("Ewing", oldestPersons.get(0).getLastName());

        Assert.assertEquals("Erik", oldestPersons.get(1).getFirstName());
        Assert.assertEquals("Thorstenpys", oldestPersons.get(1).getLastName());

        List<Person> oldestPersonsInAlma = statistics.getOldestPersonsInCity("Alma");
        Assert.assertEquals(1, oldestPersonsInAlma.size(), 1);
        Assert.assertEquals("Chad", oldestPersonsInAlma.get(0).getFirstName());
        Assert.assertEquals("Weber", oldestPersonsInAlma.get(0).getLastName());
    }

    @Test
    public void verifyBiggestCity() {
        Assert.assertEquals("Alma", statistics.getBiggestCity(), "Alma");
    }

    // Takes ~0.111s on my laptop
    @Test
    public void verifyGetCItyWithHighestStandardDeviation() {
        String cityWithHighestStdDev = statistics.getCityWithHighestStandardDeviation();
        Assert.assertEquals(cityWithHighestStdDev, "Leefield");
        Double highestStdDeviation = statistics.getHighestStandardDeviation();
        Assert.assertEquals((Double)3692.072706214177, highestStdDeviation);
    }

    @Test
    public void verifyGetCItyWithLowestStandardDeviation() {
        String cityWithLowestStdDev = statistics.getCityWithLowestStandardDeviation();
        Assert.assertEquals(cityWithLowestStdDev, "Holt");
    }
}