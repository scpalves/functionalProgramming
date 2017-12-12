using System;
using System.IO;
using System.Linq;
using System.Collections.Generic;

namespace NameStats
{
    class Program
    {
        static void Main(string[] args)
        {
            var statistics = new Statistics();
            string name = args[0];
            Console.WriteLine($"Persons with name {name}: {statistics.GetNumberOfUsersWithFirstName(name)}");
            statistics.GetCompleteNameCount();
        }
    }
}
