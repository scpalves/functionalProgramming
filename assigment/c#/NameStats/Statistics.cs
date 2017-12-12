using System;
using System.Collections.Generic;

namespace NameStats
{
    public class Statistics : IStatistics
    {
        private readonly List<Person> _persons;

        public Statistics()
        {
            _persons = new Loader("names.csv").Persons;
        }

        public long GetNumberOfUsersWithFirstName(string firstName)
        {
            int count = 0;
            foreach(var person in _persons)
            {
                if(person.FirstName == firstName)
                    count++;
            }
            
            return count;
        }

        public Dictionary<string, long> GetCompleteNameCount()
        {
            throw new NotImplementedException();
        }

        public IEnumerable<string> GetUniqueCities()
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Person> GetPersonsInCity(string cityName)
        {
            throw new NotImplementedException();
        }

        public Dictionary<String, IEnumerable<Person>> GetPersonsGroupedByCity()
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Person> GetOldestPersonsInCity(string city)
        {
            throw new NotImplementedException();
        }

        public string GetBiggestCity()
        {
            throw new NotImplementedException();
        }

        public string GetCityWithHighestStandardDeviation()
        {
            throw new NotImplementedException();
        }

        public string GetCityWithLowestStandardDeviation()
        {
            throw new NotImplementedException();
        }

        public double GetHighestStandardDeviation()
        {
            throw new NotImplementedException();
        }
    }
}