using System.Collections.Generic;

namespace NameStats
{
    public interface IStatistics 
    {
        long GetNumberOfUsersWithFirstName(string firstName);

        Dictionary<string, long> GetCompleteNameCount();

        IEnumerable<string> GetUniqueCities();

        IEnumerable<Person> GetPersonsInCity(string cityName);

        Dictionary<string, List<Person>> GetPersonsGroupedByCity();

        IEnumerable<Person> GetOldestPersonsInCity(string city);

        string GetBiggestCity();

        string GetCityWithHighestStandardDeviation();

        string GetCityWithLowestStandardDeviation();

        double GetHighestStandardDeviation();
    }    
}
