using System;
using System.Collections.Generic;

namespace NameStats
{
    public class AgeComparator : IComparer<Person>
    {
        public int Compare(Person x, Person y)
        {
            var xDateOfBirth = DateTime.Parse(x?.DateOfBirth);
            var yDateOfBirth = DateTime.Parse(y?.DateOfBirth);

            return xDateOfBirth.CompareTo(yDateOfBirth);
        }
    }
}