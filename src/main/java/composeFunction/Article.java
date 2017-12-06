package lambda;

public class Apple {
    public enum Color {
        GREEN("green"), RED("red"), YELLOW("yellow");

        private final String color;

        private Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    };

    private final Color color;
    private final Integer weight;

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }
}
