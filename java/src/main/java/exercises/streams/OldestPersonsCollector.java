package exercises.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by vagrant on 2016-12-15.
 */
public class OldestPersonsCollector implements Collector<Person, List<Person>, List<Person>> {


    private static AgeComparator ageComparator = new AgeComparator();

    @Override
    public Supplier<List<Person>> supplier() {
        return new Supplier<List<Person>>() {
            @Override
            public List<Person> get() {
                return new ArrayList<Person>();
            }
        };
    }

    @Override
    public BiConsumer<List<Person>, Person> accumulator() {

        return new BiConsumer<List<Person>, Person>() {
            @Override
            public void accept(List<Person> persons, Person person) {
                    if (persons.isEmpty()) {
                        persons.add(person);
                    } else if (ageComparator.compare(person, persons.get(0)) > 0) {
                        persons.clear();
                        persons.add(person);
                    } else if (ageComparator.compare(person, persons.get(0)) == 0) {
                        persons.add(person);
                    }

            }
        };
    }


    @Override
    public BinaryOperator<List<Person>> combiner() {
        return new BinaryOperator<List<Person>>() {
            @Override
            public List<Person> apply(List<Person> persons, List<Person> persons2) {
                persons.addAll(persons2);
                return persons;
            }
        };
    }

    @Override
    public Function<List<Person>, List<Person>> finisher() {
        return list -> list;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}
