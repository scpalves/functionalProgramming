using System;

namespace NameStats
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var statistics = new Statistics();
            string name = args[0];
            Console.WriteLine($"Persons with name {name}: {statistics.GetNumberOfUsersWithFirstName(name)}");
            statistics.GetCompleteNameCount();
        }
    }
}
