package exercises;

/* Adapted from:
* HOL3970 - Lambda Programming Lab
* JavaOne San Francisco 2013
*/

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Exercise1Test {

    static List<String> listOfWords = Arrays.asList(
            "every", "problem", "in", "computer", "science",
            "can", "be", "solved", "by", "adding", "another",
            "level", "of", "indirection", "except", "too",
            "many", "levels", "of", "indirection");


    // Exercise 1: Print out all the words in listOfWords
    @Test
    public void printAllWords() {
        // TODO
    }


    // Exercise 2: Convert all words in wordList to upper case
    @Test
    public void makeUpperCase() {
        List<String> output = null; // TODO

        assertEquals( Arrays.asList(
                "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                "LEVEL", "OF", "INDIRECTION", "EXCEPT", "TOO",
                "MANY", "LEVELS", "OF", "INDIRECTION"), output);
    }


    // Exercise 3: Find all the words in wordList that have even length
    @Test
    public void findEvenLengthWords() {
        List<String> output = null; // TODO

        assertEquals(Arrays.asList("in", "computer", "be", "solved", "by", "adding", "of",
                "except", "many", "levels", "of"), output);
    }

    // Exercise 4: count the words in wordList
    @Test
    public void countNumberOfWords() {
        final long count = 0; //TODO

        assertEquals(20, count);
    }

    // Exercise 5: count the total amount of characters in the words in wordList
    @Test
    public void countNumberOfCharactersInWords() {
        final long count = 0; //TODO

        assertEquals(105, count);
    }

    // Exercise 6: Find the first square that is divisible by five
    @Test
    public void findFirstSquareThatIsDivisibleBy5() {
        // HINT: IntStream.range(1, 100) creates a stream 1, 2, ... 99
        final int first = 0; // TODO

        assertEquals(25, first);
    }
}
