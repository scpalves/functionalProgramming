using System;
using System.IO;
using System.Collections.Generic;

namespace NameStats
{
    public class Loader
    {
        public List<Person> Persons { get; }

        public Loader(string filePath)
        {
            if(!File.Exists(filePath))
                throw new Exception();

            Persons = new List<Person>();

            using(StreamReader streamReader = File.OpenText(filePath))
            {
                string personLine = "";
                while((personLine = streamReader.ReadLine()) != null)
                {
                    var unparsedPerson = personLine.Split(";");
                    
                    string firstName = unparsedPerson[0];
                    string lastName = unparsedPerson[1];
                    string address = unparsedPerson[2];
                    string city = unparsedPerson[3];
                    string dob = unparsedPerson[4];
                    string email = unparsedPerson[5];

                    var person = new Person(firstName, lastName, address, city, dob, email);
                    Persons.Add(person);
                }
            }
        }
    }
}