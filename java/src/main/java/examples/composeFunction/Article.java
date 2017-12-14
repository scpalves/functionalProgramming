package examples.composeFunction;

import java.util.Arrays;
import java.util.List;

public class Article {
    public enum Tag {
        FANTASY,
        THRILLER,
        KIDS;


    }
    private final String author;

    private final Integer rating;
    private final List<Tag> tags;
    Article(String author, Integer rating, Tag... tags) {
        this.author = author;
        this.rating = rating;
        this.tags = Arrays.asList(tags);
    }

    String getAuthor() {
        return author;
    }

    List<Tag> getTags() {
        return tags;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Article{" +
                "Author= " + author +
                ", tags= " + tags.toString() +
                '}';
    }
}
