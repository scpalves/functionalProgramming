package composeFunction;

import composeFunction.Article.Tag;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Articles {

    private static Function<List<Article>, List<Article>> sortToRating =
            a -> a.stream()
                    .sorted(Comparator.comparing(Article::getRating))
                    .collect(Collectors.toList());

    private static Function<List<Article>, Optional<Article>> first =
            a -> a.stream().findFirst();
    private static BiFunction<String, List<Article>, List<Article>> byAuthor =
            (name, articles) -> articles.stream()
                    .filter(a -> a.getAuthor().equals(name))
                    .collect(Collectors.toList());

    private static BiFunction<Tag, List<Article>, List<Article>> byTag =
            (tag, articles) -> articles.stream()
                    .filter(a -> a.getTags().contains(tag))
                    .collect(Collectors.toList());

    //Composing
    private static BiFunction<String, List<Article>, Optional<Article>> bestByAuthor =
            byAuthor.andThen(sortToRating).andThen(first);

    //Composing
    private static BiFunction<Tag, List<Article>, Optional<Article>> bestByTag =
            byTag.andThen(sortToRating).andThen(first);

    public static void main(String... args) {
        final List<Article> inventory = new ArrayList<>();
        updateInventory(inventory);
        final Optional<Article> danbrownsBest = bestByAuthor.apply("Dan Brown", inventory);
        System.out.println("Dan Brown's best: "+ danbrownsBest.get().toString());

        final Optional<Article> bestThriller = bestByTag.apply(Tag.THRILLER, inventory);
        System.out.println("Best Thriller: "+ danbrownsBest.get().toString());

    }

    private static void updateInventory(List<Article> inventory) {
        inventory.add(new Article("Dan Brown", 3, Tag.THRILLER));
        inventory.add(new Article("Dan Brown", 4, Tag.THRILLER, Tag.FANTASY));
        inventory.add(new Article("Dan Brown", 5, Tag.THRILLER));
        inventory.add(new Article("J K Rowling", 5, Tag.FANTASY, Tag.KIDS));
        inventory.add(new Article("J K Rowling", 5, Tag.FANTASY, Tag.KIDS));
        inventory.add(new Article("J K Rowling", 4, Tag.FANTASY, Tag.KIDS, Tag.THRILLER));
        inventory.add(new Article("J K Rowling", 4, Tag.FANTASY, Tag.KIDS));
        inventory.add(new Article("Astrid Lindgren", 2, Tag.KIDS));
        inventory.add(new Article("Astrid Lindgren", 3, Tag.KIDS));
        inventory.add(new Article("Astrid Lindgren", 4, Tag.KIDS, Tag.FANTASY));
        inventory.add(new Article("Astrid Lindgren", 3, Tag.KIDS));
    }
}
