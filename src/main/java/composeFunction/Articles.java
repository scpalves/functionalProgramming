package composeFunction;

public class Books {
    BiFunction<String, List<Article>, List<Article>> byAuthor =
            (name, articles) -> articles.stream()
                    .filter(a -> a.getAuthor().equals(name))
                    .collect(Collectors.toList());

    BiFunction<String, List<Article>, List<Article>> byTag =
            (tag, articles) -> articles.stream()
                    .filter(a -> a.getTags().contains(tag))
                    .collect(Collectors.toList());

}
