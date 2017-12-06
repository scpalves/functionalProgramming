package higherOrderFunctions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterCollectionFunc {

    private static final List<String> strings = Arrays.asList("Scania", "Volvo", "MAN", "Mercedes", "Renault", "BMW",
            "Toyota", "Tesla", "Skoda", "Volkswagen", "Nissan", "Honda");


    //Return function
    private static Predicate<String> isStringLengthEven() {
        return string -> string.length() %2 == 0;
    }

    public static void main(String[] args) {
        final List<String> filteredList = strings.stream().
                filter(isStringLengthEven())
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(filteredList);

    }


}
