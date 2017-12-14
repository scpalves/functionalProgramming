using System;
using System.Collections.Generic;

namespace Exercise3
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
            var count = 0;
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

        public HashSet<string> GetUniqueCities()
        {
            var cities = new HashSet<string>();
            foreach(var person in _persons)
                cities.Add(person.City);

            return cities;
        }

        public IList<Person> GetPersonsInCity(string cityName)
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

        public IList<Person> GetOldestPersonsInCity(string city)
        {
            var personsInCity = GetPersonsGroupedByCity()[city];
            personsInCity.Sort(new AgeComparator().Compare);

            var oldestPerson = personsInCity[0];

            var oldestPersons = new List<Person>();
            foreach (var person in _persons)
            {
                if(person.DateOfBirth.Equals(oldestPerson.DateOfBirth))
                    oldestPersons.Add(person);
            }

            return oldestPersons;
        }

        public string GetBiggestCity()
        {
            var personsByCities = GetPersonsGroupedByCity();
            var maxValue = 0;
            var city = "";

            foreach (var personsInCity in personsByCities)
            {
                if (personsInCity.Value.Count > maxValue)
                {
                    maxValue = personsInCity.Value.Count;
                    city = personsInCity.Key;
                }
            }

            return city;
        }

        public string GetCityWithHighestStandardDeviation()
        {
            var personsByCities = GetPersonsGroupedByCity();
            var city = "";
            var maxStandardDeviation = 0.0d;

            foreach (var personsByCity in personsByCities)
            {
                var ages = ConvertPersonsToAges(personsByCity.Value);
                var standardDeviation = StandardDeviation.CalculateStandardDeviation(ages);

                if (standardDeviation > maxStandardDeviation)
                {
                    maxStandardDeviation = standardDeviation;
                    city = personsByCity.Key;
                }
            }

            return city;
        }

        public string GetCityWithLowestStandardDeviation()
        {
            var personsByCities = GetPersonsGroupedByCity();
            var city = "";
            var minStandardDeviation = double.MaxValue;

            foreach (var personsByCity in personsByCities)
            {
                var ages = ConvertPersonsToAges(personsByCity.Value);
                var standardDeviation = StandardDeviation.CalculateStandardDeviation(ages);

                if (standardDeviation < minStandardDeviation)
                {
                    minStandardDeviation = standardDeviation;
                    city = personsByCity.Key;
                }
            }

            return city;
        }

        public double GetHighestStandardDeviation()
        {
            var personsByCities = GetPersonsGroupedByCity();
            var maxStandardDeviation = 0.0d;

            foreach (var personsByCity in personsByCities)
            {
                var ages = ConvertPersonsToAges(personsByCity.Value);
                var standardDeviation = StandardDeviation.CalculateStandardDeviation(ages);

                if (standardDeviation > maxStandardDeviation)
                    maxStandardDeviation = standardDeviation;
            }

            return maxStandardDeviation;
        }

        private List<long> ConvertPersonsToAges(List<Person> persons)
        {
            var ages = new List<long>();

            foreach (var person in persons)
            {
                ages.Add(person.GetAgeAtSpecificDate());
            }

            return ages;
        }
    }
}