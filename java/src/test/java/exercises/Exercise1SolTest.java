package exercises;

/* Adapted from:
* HOL3970 - Lambda Programming Lab
* JavaOne San Francisco 2013
*/

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class Exercise1SolTest {

    static List<String> listOfWords = Arrays.asList(
            "every", "problem", "in", "computer", "science",
            "can", "be", "solved", "by", "adding", "another",
            "level", "of", "indirection", "except", "too",
            "many", "levels", "of", "indirection");


    // Exercise 1: Print out all the words in listOfWords
    @Test
    public void printAllWords() {
        listOfWords.forEach(System.out::print);

    }


    // Exercise 2: Convert all words in wordList to upper case
    @Test
    public void makeUpperCase() {
        List<String> output = listOfWords.stream().
                map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(Arrays.asList(
                "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                "LEVEL", "OF", "INDIRECTION", "EXCEPT", "TOO",
                "MANY", "LEVELS", "OF", "INDIRECTION"), output);
    }


    // Exercise 3: Find all the words in wordList that have even length
    @Test
    public void findEvenLengthWords() {
        final Predicate<String> stringLengthIsEven = s -> s.length() % 2 == 0;
        List<String> output = listOfWords.stream()
                .filter(s->s.length()%2==0)
                .collect(Collectors.toList());

        assertEquals(Arrays.asList("in", "computer", "be", "solved", "by", "adding", "of",
                "except", "many", "levels", "of"), output);
    }

    // Exercise 4: count the words in wordList
    @Test
    public void countNumberOfWords() {
        final long count = listOfWords.size();

        assertEquals(20, count);
    }

    // Exercise 5: count the total amount of characters in the words in wordList
    @Test
    public void countNumberOfCharactersInWords() {
        //final long count = listOfWords.stream()
        // .collect(Collectors.summingLong(String::length));
        final long count = listOfWords.stream()
                .mapToLong(String::length)
                .sum();



        listOfWords.stream()
                .map(String::length)
                .reduce((x,y)-> x+y)
                .orElse(0);

        assertEquals(105, count);
    }

    // Exercise 6: Find the first square that is divisible by five
    @Test
    public void findFirstSquareThatIsDivisibleBy5() {
        // HINT: IntStream.range(1, 100) creates a stream 1, 2, ... 99
        final IntUnaryOperator squareOperator = x -> x * x;
        final IntPredicate divisibleBy5 = s -> s % 5 == 0;
        final int first =
                IntStream.range(1, 50)
                        .map(squareOperator)
                        .filter(divisibleBy5)
                        .findFirst()
                        .orElse(0);


        assertEquals(25, first);
    }
}
