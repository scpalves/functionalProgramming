using System;
using System.Collections.Generic;

namespace NameStats
{
    public class StandardDeviation
    {
        public static double CalculateStandardDeviation(IList<long> values)
        {
            return Math.Sqrt(GetSumOfDiffsSquared(values, GetAverage(values)));
        }

        private static double GetSumOfDiffsSquared(IList<long> values, double average)
        {
            double sum = 0.0d;
            foreach (var value in values)
            {
                sum += Math.Pow((value - average), 2);
            }

            return sum / values.Count;
        }

        private static double GetAverage(IList<long> values)
        {
            double sum = 0.0d;
            foreach (var value in values)
            {
                sum += value;
            }

            return sum / values.Count;
        }
    }
}