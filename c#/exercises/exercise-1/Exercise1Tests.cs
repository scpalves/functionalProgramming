using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace exercise_1
{
    [TestClass]
    public class Exercise1Tests
    {
        static List<string> _words = new List<string>()
        {
            "every",
            "problem",
            "in",
            "computer",
            "science",
            "can",
            "be",
            "solved",
            "by",
            "adding",
            "another",
            "level",
            "of",
            "indirection",
            "except",
            "too",
            "many",
            "levels",
            "of",
            "indirection"
        };

        // Exercise 1: Print out all the words in _words.
        [TestMethod]
        public void PrintAllWords()
        {
            //TODO
        }

        // Exercise 2: Convert all words in _words to upper case.
        [TestMethod]
        public void MakeUpperCase()
        {
            var output = new List<string>();

            CollectionAssert.AreEqual(new[]
            {
                "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                "LEVEL", "OF", "INDIRECTION", "EXCEPT", "TOO",
                "MANY", "LEVELS", "OF", "INDIRECTION"
            }, output);
        }

        // Exercise 3: Find all words that have an even length.
        [TestMethod]
        public void FindEvenLenghtWords()
        {
            var output = _words
                .Where(word => word.Length % 2 == 0)
                .ToList();

            CollectionAssert.AreEqual(new[]
            {
                "in", "computer", "be", "solved", "by", "adding", "of",
                "except", "many", "levels", "of"
            }, output);
        }

        // Exercise 4: Count the words in _words.
        [TestMethod]
        public void CountWords()
        {
            var count = _words.Count;

            Assert.AreEqual(20, count);
        }


        // Exercise 5: Count the total amount of characters in _words.
        [TestMethod]
        public void CountNumberOfCharactersInWords()
        {
            var count = _words.Select(word => word.Length).Sum();

            Assert.AreEqual(105, count);
        }

        // Exercise 6: Find the first square that is divisible by 5.
        [TestMethod]
        public void FindFirstSquareThatIsDivisibleBy5()
        {
            // Hint Enumerable.Range(1, 100), creates a list of numbers 1, 2, 3.. 100.
            var first = Enumerable.Range(1, 50)
                .Select(x => x * x)
                .FirstOrDefault(x => x % 5 == 0);

            Assert.AreEqual(25, first);
        }
    }
}
