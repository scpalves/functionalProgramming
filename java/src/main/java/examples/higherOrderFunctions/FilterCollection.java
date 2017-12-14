package examples.higherOrderFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilterCollection {

    private static final List<String> strings = Arrays.asList("Scania", "Volvo", "MAN", "Mercedes", "Renault", "BMW",
            "Toyota", "Tesla", "Skoda", "Volkswagen", "Nissan", "Honda");

    public static void main(String[] args) {
        final List<String> filteredList = new ArrayList<>();
        for (String s : strings){
            if (s.length()%2 == 0){
                filteredList.add(s);
            }
        }
        filteredList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println(filteredList);

    }
}
