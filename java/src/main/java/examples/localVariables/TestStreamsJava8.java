package examples.localVariables;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStreamsJava8 {

    private static final List<Integer> numbers = Arrays.asList(6, 2, 3, 1, 4, 5);

    public static void main(String... args) {
        final Optional<Integer> optionalSum = numbers.stream().reduce((i, j) -> i + j);

        System.out.println(optionalSum.orElse(0));
    }
}
