using System.Diagnostics;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace NameStats.Tests
{
    [TestClass]
    public class StatisticsTests
    {
        private IStatistics _statistics;
        [TestInitialize]
        public void InitTests()
        {
            _statistics = new Statistics();
        }

        [TestMethod]
        public void GetNumberOfUsersWithFirstName_Lindsey_returns_55()
        {
            var numberOfLindseys = _statistics.GetNumberOfUsersWithFirstName("Lindsey");
            Debug.WriteLine($"{numberOfLindseys} named Lindsey");

            Assert.AreEqual(55, numberOfLindseys);
        }

        [TestMethod]
        public void GetCompleteNameCount_returns_538_records()
        {
            var nameCount = _statistics.GetCompleteNameCount();
            Debug.WriteLine($"{nameCount.Count} complete name count");

            Assert.AreEqual(538, nameCount.Count);
        }

        [TestMethod]
        public void GetUniqueCities_return_477()
        {
            var uniqueCities = _statistics.GetUniqueCities().ToList();
            Debug.WriteLine($"{uniqueCities.Count} unique cities");

            Assert.AreEqual(477, uniqueCities.Count);
        }

        [TestMethod]
        public void GetPersonsInCity_Chester_returns_64_people_in_Chester()
        {
            var personsInChester = _statistics.GetPersonsInCity("Chester").ToList();
            Debug.WriteLine($"{personsInChester.Count} persons in Chester");

            Assert.AreEqual(64, personsInChester.Count);
        }

        [TestMethod]
        public void GetPersonsGroupedByCity_Chester_contains_64_persons()
        {
            var personsByCities = _statistics.GetPersonsGroupedByCity();
            var personsInChester = personsByCities["Chester"].Count;
            Debug.WriteLine($"{personsInChester} persons in Chester");

            Assert.AreEqual(64, personsInChester);
        }

        [TestMethod]
        public void GetOldestPersonsInCity_for_Chester_has_5_with_same_age()
        {
            var oldestInChester = _statistics.GetOldestPersonsInCity("Chester").ToList();
            Debug.WriteLine($"{oldestInChester.Count} persons are born on {oldestInChester.FirstOrDefault()?.DateOfBirth}");

            Assert.AreEqual(5, oldestInChester.Count);
        }

        [TestMethod]
        public void GetBiggestCity_is_Alma()
        {
            var biggestCity = _statistics.GetBiggestCity();
            Debug.WriteLine($"{biggestCity} is the biggest city.");
            Assert.AreEqual("Alma", biggestCity);
        }

        [TestMethod]
        public void GetCityWithHighestStandardDeviation_is_Leefield()
        {
            var cityWithHighestStandardDeviation = _statistics.GetCityWithHighestStandardDeviation();
            Debug.WriteLine($"{cityWithHighestStandardDeviation} is the city with the highest standard deviation.");

            Assert.AreEqual("Leefield", cityWithHighestStandardDeviation);
        }

        [TestMethod]
        public void GetCityWithLowestStandardDeviation_is_Holt()
        {
            var cityWithLowestStandardDeviation = _statistics.GetCityWithLowestStandardDeviation();
            Debug.WriteLine($"{cityWithLowestStandardDeviation} is the city with the lowest standard deviation.");

            Assert.AreEqual("Holt", cityWithLowestStandardDeviation);
        }

        [TestMethod]
        public void GetHighestStandardDeviation_is_around_3692()
        {
            var highestStandardDeviation = _statistics.GetHighestStandardDeviation();
            Debug.WriteLine($"{highestStandardDeviation} is the highest standard deviation.");

            Assert.AreEqual(3692.186963227698, highestStandardDeviation);
        }
    }
}
