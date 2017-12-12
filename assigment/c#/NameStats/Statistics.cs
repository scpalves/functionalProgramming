using System;
using System.Linq;
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
            var nameCounts = new Dictionary<string, long>();
            foreach(var person in _persons)
            {
                if(!nameCounts.ContainsKey(person.FirstName))
                    nameCounts.Add(person.FirstName, 0);

                ++nameCounts[person.FirstName];
            }

            return nameCounts;
        }

        public IEnumerable<string> GetUniqueCities()
        {
            var cities = new HashSet<string>();
            foreach(var person in _persons)
                cities.Add(person.City);

            return cities;
        }

        public IEnumerable<Person> GetPersonsInCity(string cityName)
        {
            var livesInCity = new List<Person>();

            foreach(var person in _persons)
            {
                if(person.City.Equals(cityName))
                    livesInCity.Add(person);
            }

            return livesInCity;
        }

        public Dictionary<String, List<Person>> GetPersonsGroupedByCity()
        {
            var cityPeople = new Dictionary<string, List<Person>>();
            foreach(var person in _persons)
            {
                if(cityPeople.ContainsKey(person.City))
                    cityPeople[person.City].Add(person);
                else
                    cityPeople.Add(person.City, new List<Person>() {person});
            }

            return cityPeople;
        }

        public IEnumerable<Person> GetOldestPersonsInCity(string city)
        {
            var personsInCity = GetPersonsGroupedByCity()[city];
            
            return personsInCity;
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