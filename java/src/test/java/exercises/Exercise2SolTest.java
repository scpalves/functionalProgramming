package exercises;

/* Adapted from:
* HOL3970 - Lambda Programming Lab
* JavaOne San Francisco 2013
*/

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Exercise2SolTest {

    static private final String REGEXP = "\\W+"; // for splitting into words

    private BufferedReader reader;

    @Before
    public void setUpBufferedReader() throws IOException, URISyntaxException {
        URL resource = ClassLoader.getSystemClassLoader().getResource("Scania.txt");
        assert resource != null;
        reader = Files.newBufferedReader(Paths.get(resource.toURI()), StandardCharsets.UTF_8);
    }

    @After
    public void closeBufferedReader() throws IOException {
        reader.close();
    }


// Exercise 1: Count the number of lines in a file. The field *reader*
// is a BufferedReader which will be opened for you on the text file.
// See the JUnit @Before and @After methods at the top of this file.

    @Test
    public void countLinesInFile() throws IOException {
        long count = reader.lines().count();
        assertEquals(11, count);
    }


// Exercise 2: Join lines 2-3 from the text file into a single string.

    @Test
    public void joinLineRange() throws IOException {
        String output = reader.lines().skip(1).
                limit(2).reduce(String::concat).orElse("");

        assertEquals(
                "Scania is introducing a new truck range, the result of ten years of" +
                        "development work and investments in the region of SEK 20 billion.",
                output);
    }

// Exercise 3: Find the length of the longest line in the file.

    @Test
    public void lengthOfLongestLine() throws IOException {

        int longest = reader.lines()
                .max(Comparator.comparingLong(String::length))
                .orElse("")
                .length();

        assertEquals(longest, 79);
    }

// Exercise 4: Collect all the words from the text file into a list.
// Hint: use String.split(REGEXP) to split a string into words.
// Splitting this way results in "words" that are the empty string,
// which should be discarded. REGEXP is defined at the top of this file.

    @Test
    public void listOfAllWords() throws IOException {
        List<String> output = reader.lines()
                .flatMap(l -> Stream.of(l.split(REGEXP))).
                        collect(Collectors.toList());

        assertEquals(
                Arrays.asList(
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
                        "and", "area", "of", "application"),
                output);
    }

// Exercise 5: Create a list containing the words, lowercased, in alphabetical order.

    @Test
    public void sortedLowerCase() throws IOException {
        List<String> output =
                reader.lines()
                        .flatMap(l -> Stream.of(l.split(REGEXP)))
                        .map(String::toLowerCase)
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toList());


        assertEquals(
                Arrays.asList(
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
                        "well", "will", "with", "work", "work", "years"),
                output);
    }

// Exercise 6: Sort unique, lower-cased words by length, then alphabetically
// within length, and place the result into an output list.

    @Test
    public void sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
        List<String> output =
                reader.lines()
                        .flatMap(l -> Stream.of(l.split(REGEXP)))
                        .map(String::toLowerCase)
                        .sorted(Comparator.comparingLong(String::length).thenComparing(Comparator.naturalOrder()))
                        .collect(Collectors.toList());

        assertEquals(
                Arrays.asList(
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
                        "transportation", "transportation"),
                output);
    }

// Exercise 7: Categorize the words into a map, where the map's key is
// the length of each word, and the value corresponding to a key is a
// list of words of that length. Don't bother with uniqueness or lower-
// casing the words. Don't count empty words.

    @Test
    public void mapLengthToWordList() throws IOException {
        Map<Integer, List<String>> map =
                reader.lines()
                        .flatMap(l-> Stream.of(l.split(REGEXP)))
                .collect(Collectors.groupingBy(String::length));

        assertEquals(19, map.get(2).size());
        assertEquals(Arrays.asList("connectivity", "productivity"), map.get(12));
        assertEquals(Arrays.asList("comprehensive"), map.get(13));
        assertEquals(Arrays.asList("a", "a", "s"), map.get(1));
        assertEquals(14, map.keySet().size());
    }

// Exercise 8: Gather the words into a map, accumulating a count of the
// number of occurrences of each word. Don't worry about upper case and
// lower case.

    @Test
    public void wordFrequencies() throws IOException {
        Map<String, Long> map = null; // TODO

        assertEquals(2L, (long) map.get("transportation"));
        assertEquals(5L, (long) map.get("the"));
        assertEquals(7L, (long) map.get("of"));
        assertEquals(2L, (long) map.get("to"));
        assertEquals(4L, (long) map.get("Scania"));
        assertFalse(map.containsKey("Mercedes"));
    }

// Exercise 9: Create a nested grouping, where the outer map is a map
// from the first letter of the word to a submap. (Use a string of length
// one as the key.) The submap, in turn, is a mapping from the length of the
// word to a list of words with that length. Don't bother with any downcasing
// or uniquifying of the words.
//
// For example, given the words "foo bar baz bazz" the top level map would have
// a keys of "f" and "b". The value corresponding to "b" would be a map with
// a key of 3 with a value of [bar baz] (a list of Strings) and a key of 4
// with a value of [bazz] (a one-element list of String).

    @Test
    public void nestedGrouping() throws IOException {
        Map<String, Map<Integer, List<String>>> map = null; // TODO

        assertEquals("[able, area]", map.get("a").get(4).toString());
        assertEquals("[billion]", map.get("b").get(7).toString());
        assertEquals("[the, ten, the, the, the, the]",
                map.get("t").get(3).toString());
        assertEquals("{4=[more, most], 7=[modular]}", map.get("m").toString());
    }
}
