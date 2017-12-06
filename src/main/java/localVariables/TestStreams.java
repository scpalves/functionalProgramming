package localVariables;

import java.util.Arrays;
import java.util.List;

public class TestStreams {

    private static final List<Integer> numbers = Arrays.asList(6, 2, 3, 1, 4, 5);

    public static void main(String... args) {
        int sum = 0;

        for (Integer number : numbers) {
            sum = sum + number; //sum is not immutable
        }
        System.out.println("Sum of numbers: "+ sum);

    }
}
