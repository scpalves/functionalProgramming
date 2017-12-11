using System;
using System.Linq;

namespace funcProg_codeNight
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("1. Circle stats");
            Console.WriteLine("2. Triples (Enumerable 1 - 3)");
            Console.WriteLine("3. DaysSince");
            Console.WriteLine("4. DaysSince pure");
            Console.Write("Select an example: ");
            var userSelection = Console.ReadLine();
            
            switch(userSelection)
            {
                case "1":
                    var circle = new Circle(5);
                    Console.WriteLine(circle.Stats);
                    break;
                case "2":
                    var triples = new Triples().Triple(Enumerable.Range(1,3));
                    Console.WriteLine(String.Join(", ", triples.Select(n => n.ToString())));
                    break;
                case "3":
                    Console.WriteLine(new DateComparer().DaysSince(new DateTime(1987, 07, 03)));
                    break;
                case "4":
                    Console.WriteLine(new DateComparer().DaysSincePure(new DateTime(1987, 07, 03), DateTime.Now));
                    break;
                default:
                    break;
            }
        }
    }
}
