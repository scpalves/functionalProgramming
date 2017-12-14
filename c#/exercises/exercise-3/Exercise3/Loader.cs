using System.Collections.Generic;
using System.IO;

namespace Exercise3
{
    public class Loader
    {
        public List<Person> Persons { get; }

        public Loader(string filePath)
        {
            Persons = new List<Person>();

            using(var streamReader = File.OpenText(filePath))
            {
                var personLine = "";
                while((personLine = streamReader.ReadLine()) != null)
                {
                    var unparsedPerson = personLine.Split(';');
                    
                    var firstName = unparsedPerson[0];
                    var lastName = unparsedPerson[1];
                    var address = unparsedPerson[2];
                    var city = unparsedPerson[3];
                    var dob = unparsedPerson[4];
                    var email = unparsedPerson[5];

                    var person = new Person(firstName, lastName, address, city, dob, email);
                    Persons.Add(person);
                }
            }
        }
    }
}