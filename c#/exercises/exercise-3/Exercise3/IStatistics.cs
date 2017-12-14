using System.Collections.Generic;

namespace Exercise3
{
    public interface IStatistics 
    {
        long GetNumberOfUsersWithFirstName(string firstName);

        Dictionary<string, long> GetCompleteNameCount();

        HashSet<string> GetUniqueCities();

        IList<Person> GetPersonsInCity(string cityName);

        Dictionary<string, List<Person>> GetPersonsGroupedByCity();

        IList<Person> GetOldestPersonsInCity(string city);

        string GetBiggestCity();

        string GetCityWithHighestStandardDeviation();

        string GetCityWithLowestStandardDeviation();

        double GetHighestStandardDeviation();
    }    
}
