package exercises.streams;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Statistics {
    /**
     * Returns the number of Person instances with the specified first name.
     * @param firstName the name to search for
     * @return the number of Person instances
     */
    long getNumberOfPeopleWithFirstName(String firstName);

    /**
     * Returns the number of Person instances grouped by first name.
     * @return Map from first name to count
     */
    Map<String, Long> getCompleteNameCount();

    /**
     * Returns the number of unique cities.
     * @return city count
     */
    Collection<String> getUniqueCities();

    /**
     * Returns all the Person instances for the given city.
     * @param cityName the name of the city
     * @return all the people on the city
     */
    Collection<Person> getPersonsInCity(String cityName);

    /**
     * Groups all people according to the city where they live.
     * @return Map of people
     */
    Map<String, List<Person>> getPersonsGroupedByCity();

    /**
     * Returns a list of the oldest people in a city.
     * @param city the city name
     * @return a list of people
     */
    List<Person> getOldestPersonsInCity(String city);

    /**
     * Returns the city with the highest population. In case of multiple cities, city returned is unspecified.
     * @return the name of the biggest city
     */
    String getBiggestCity();

    /**
     * Returns the city with the highest person AGE standard deviation. See wikipedia for definition of standard deviation.
     * @return the city with the highest standard deviation
     */
    String getCityWithHighestStandardDeviation();

    /**
     * Returns the city with the lowest person AGE standard deviation. See wikipedia for definition of standard deviation.
     * @return the city with the lowest standard deviation
     */
    String getCityWithLowestStandardDeviation();

    /**
     * Returns the highest person AGE standard deviation. See wikipedia for definition of standard deviation.
     * @return the highest standard deviation
     */
    Double getHighestStandardDeviation();
}
