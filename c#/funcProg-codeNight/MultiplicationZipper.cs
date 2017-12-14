using System;
using System.Linq;
using System.Collections.Generic;
using System.Security.Cryptography.X509Certificates;

namespace funcProg_codeNight
{
    public static class MultiplicationZipper
    {
        static readonly Func<int, int> MultiplyBy2 = x => x * 2;

        public static List<string> ParallelMultiplyBy2(List<int> numbers)
            => numbers.AsParallel()
                .Select(MultiplyBy2)
                .Zip(Enumerable.Range(1, numbers.Count).AsParallel(), (val, count) => $"{count} x 2 = {val}")
                .ToList();
    }
}