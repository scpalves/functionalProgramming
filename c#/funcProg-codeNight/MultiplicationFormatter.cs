using System.Collections.Generic;
using System.Linq;

namespace funcProg_codeNight
{
    public static class MultiplicationFormatter
    {
        private static int _counter;
        static string Counter(int val) => $"{++_counter} x 2 = {val}";

        public static List<string> Format(List<int> numbers)
            => numbers
                .Select(Extensions.MultiplyBy2)
                .Select(Counter)
                .ToList();

        public static List<string> ParallelFormat(List<int> numbers)
            => numbers
                .AsParallel()
                .Select(Extensions.MultiplyBy2)
                .Select(Counter)
                .ToList();
    }

    internal static class Extensions
    {
        internal static int MultiplyBy2(this int value)
            => value * 2;
    }
}