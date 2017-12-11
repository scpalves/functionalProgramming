using System;
using System.Linq;
using System.Collections.Generic;

namespace funcProg_codeNight
{
    public class Triples
    {
        static Func<int, int> triple = x => x * 3;
        public IEnumerable<int> Triple(IEnumerable<int> range)
            => range.Select(triple);
    }
}