using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace exercise_2
{
    [TestClass]
    public class Exercise2Tests
    {
        // Regexp to split on words
        private readonly string REGEXP = "\\W+";

        private StreamReader _streamReader;

        [TestInitialize]
        public void Init()
        {
            _streamReader = File.OpenText("Scania.txt");
        }

        [TestCleanup]
        public void Cleanup()
        {
            _streamReader.Close();
        }


        // Exercise 1: Count the number of lines in a file.
        [TestMethod]
        public void CountLinesInFile()
        {
            var lineCount = 0;

            Assert.AreEqual(11, lineCount);
        }

        //Exercise 2: Join lines 2-3 from the text file into a single string.
        [TestMethod]
        public void JoinLineRange()
        {
            var output = "";

            Assert.AreEqual("Scania is introducing a new truck range, the result of ten years of" +
                            "development work and investments in the region of SEK 20 billion.", output);
        }

        // Exercise 3: Find the length of the longest line in the file.
        [TestMethod]
        public void LenghtOfLongestLine()
        {
            var lineLenght = 0;

            Assert.AreEqual(79, lineLenght);
        }

        // Exercise 4: Collect all the words, from the input file, into a list. Remove empty words, there's a REGEXP at the top of the file that can be used.
        [TestMethod]
        public void ListOfAllWords()
        {
            var allWords = new List<string>();

            CollectionAssert.AreEqual(new[]
            {
                "Scania", "introduces", "new", "truck", "range", "Scania", "is", "introducing", "a", "new",
                "truck", "range", "the", "result", "of", "ten", "years", "of", "development", "work", "and",
                "investments", "in", "the", "region", "of", "SEK", "20", "billion", "With", "the", "new",
                "range", "Scania", "is", "extending", "its", "offering", "and", "can", "now", "thanks",
                "to", "its", "unique", "modular", "system", "supply", "more", "performance", "stages",
                "connectivity", "and", "a", "comprehensive", "palette", "of", "productivity", "enhancing",
                "services", "as", "well", "as", "sustainable", "transportation", "solutions", "that", "are",
                "precisely", "customised", "for", "each", "type", "of", "customer", "in", "the", "highly",
                "competitive", "transportation", "industry", "The", "promise", "is", "that", "Scania", "s",
                "customers", "will", "always", "be", "able", "to", "carry", "out", "their", "work", "in",
                "the", "most", "sustainable", "and", "profitable", "way", "regardless", "of", "industry",
                "and", "area", "of", "application"
            }, allWords);
        }

        // Exercise 5: Create a list containing all the words, lowercased, in alphabetical order.
        [TestMethod]
        public void SortedLowerCase()
        {
            var sortedLowerCaseWords = new List<string>();

            CollectionAssert.AreEqual(new[]
            {
                "20", "a", "a", "able", "always", "and", "and", "and", "and", "and", "application", "are",
                "area", "as", "as", "be", "billion", "can", "carry", "competitive", "comprehensive",
                "connectivity", "customer", "customers", "customised", "development", "each", "enhancing",
                "extending", "for", "highly", "in", "in", "in", "industry", "industry", "introduces",
                "introducing", "investments", "is", "is", "is", "its", "its", "modular", "more", "most",
                "new", "new", "new", "now", "of", "of", "of", "of", "of", "of", "of", "offering", "out",
                "palette", "performance", "precisely", "productivity", "profitable", "promise", "range",
                "range", "range", "regardless", "region", "result", "s", "scania", "scania", "scania",
                "scania", "sek", "services", "solutions", "stages", "supply", "sustainable", "sustainable",
                "system", "ten", "thanks", "that", "that", "the", "the", "the", "the", "the", "the", "their",
                "to", "to", "transportation", "transportation", "truck", "truck", "type", "unique", "way",
                "well", "will", "with", "work", "work", "years"
            }, sortedLowerCaseWords);
        }

        // Exercise 6: Sort unique, lowercased, words by length, then alphabetically.
        [TestMethod]
        public void SortedLowerCaseDistinctByLengthThenAlphabetically()
        {
            var sortedLowerCaseWords = new List<string>();

            CollectionAssert.AreEqual(new[]
            {
                "a", "a", "s", "20", "as", "as", "be", "in", "in", "in", "is", "is", "is", "of", "of",
                "of", "of", "of", "of", "of", "to", "to", "and", "and", "and", "and", "and", "are", "can",
                "for", "its", "its", "new", "new", "new", "now", "out", "sek", "ten", "the", "the", "the",
                "the", "the", "the", "way", "able", "area", "each", "more", "most", "that", "that", "type",
                "well", "will", "with", "work", "work", "carry", "range", "range", "range", "their", "truck",
                "truck", "years", "always", "highly", "region", "result", "scania", "scania", "scania",
                "scania", "stages", "supply", "system", "thanks", "unique", "billion", "modular", "palette",
                "promise", "customer", "industry", "industry", "offering", "services", "customers",
                "enhancing", "extending", "precisely", "solutions", "customised", "introduces", "profitable",
                "regardless", "application", "competitive", "development", "introducing", "investments",
                "performance", "sustainable", "sustainable", "connectivity", "productivity", "comprehensive",
                "transportation", "transportation"
            }, sortedLowerCaseWords);
        }

        // Exercise 7: Categorize words into a dictionary, where the key is the length of the words,
        // and the value is a list of the words that matches the keys length. Don't count empty words.
        [TestMethod]
        public void WordsByLength()
        {
            var wordsByLength = new Dictionary<int, List<string>>();

            Assert.AreEqual(19, wordsByLength[2].Count);
            Assert.AreEqual(14, wordsByLength.Count);
            CollectionAssert.AreEqual(new[] { "connectivity", "productivity" }, wordsByLength[12]);
            CollectionAssert.AreEqual(new[] { "comprehensive" }, wordsByLength[13]);
            CollectionAssert.AreEqual(new[] { "a", "a", "s" }, wordsByLength[1]);
        }


        // Exercise 8: Create a dictionary which contains each word, and their number of occurences.
        // Disregard casing (upper/lower), and empty words.
        [TestMethod]
        public void WordFrequencies()
        {
            var wordFrequencies = new Dictionary<string, int>();

            Assert.AreEqual(2, wordFrequencies["transportation"]);
            Assert.AreEqual(5, wordFrequencies["the"]);
            Assert.AreEqual(7, wordFrequencies["of"]);
            Assert.AreEqual(2, wordFrequencies["to"]);
            Assert.AreEqual(4, wordFrequencies["Scania"]);
            Assert.IsFalse(wordFrequencies.ContainsKey("Mercedes"));
        }

        // Exercise 9: Create a nested dictionary, where the outer dictionary holds the firs letter of
        // a word (key), and a sub dictionary. The sub dictionary holds all words that starts on the given
        // letter, grouped by their length. 
        //
        // For example: Given the words "foo bar baz bazz", the top level dictionary would contain the keys "f", and "b".
        // The nested dictionary for key "b" would contain the keys 3, and 4, with the corresponding values [bar, baz], and
        // [bazz].
        [TestMethod]
        public void NestedGrouping()
        {
            var nestedDictionary = new Dictionary<string, Dictionary<int, List<string>>>();

            CollectionAssert.AreEqual(new[] { "able", "area" }, nestedDictionary["a"][4]);
            CollectionAssert.AreEqual(new[] { "billion" }, nestedDictionary["b"][7]);
            CollectionAssert.AreEqual(new[] { "the", "ten", "the", "the", "the", "the", "the" }, nestedDictionary["t"][3]);
            CollectionAssert.AreEqual(new[] { "more", "most" }, nestedDictionary["m"][4]);
            CollectionAssert.AreEqual(new[] { "modular" }, nestedDictionary["m"][7]);
        }
    }
}
