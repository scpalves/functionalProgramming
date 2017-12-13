package exercises.streams;

import java.util.Collection;

public class StandardDeviation {
    public static double calculateStdDeviation(Collection<Long> values) {
        return Math.sqrt(getSumOfDiffsSquared(values, getAverage(values)));
    }

    private static double getSumOfDiffsSquared(Collection<Long> values, Double average) {
        double sum = 0.0;
        for (Long value : values) {
            sum += Math.pow((value - average), 2);
        }
        return sum / values.size();
    }

    private static double getAverage(Collection<Long> values) {
        double sum = 0.0;
        for (Long value : values) {
            sum += value;
        }
        return sum / values.size();
    }
}
