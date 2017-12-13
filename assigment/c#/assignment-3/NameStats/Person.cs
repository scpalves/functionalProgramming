using System;

namespace NameStats
{
    public class Person
    {
        private readonly DateTime _dob;

        public Person(string firstName, string lastName, string address, string city, string dateOfBirth, string emailAddress)
        {
            FirstName = firstName;
            LastName = lastName;
            Address = address;
            City = city;
            DateOfBirth = dateOfBirth;
            EmailAddress = emailAddress;
            _dob = DateTime.Parse(dateOfBirth);
        }

        public string DateOfBirth { get; }

        public string FirstName { get; }

        public string LastName { get; }

        public string Address { get; }

        public string City { get; }

        public string EmailAddress { get; }

        public override string ToString() => "Person{" +
                                    "firstName='" + FirstName + '\'' +
                                    ", lastName='" + LastName + '\'' +
                                    ", address='" + Address + '\'' +
                                    ", city='" + City + '\'' +
                                    ", dateOfBirth='" + DateOfBirth + '\'' +
                                    ", emailAddress='" + EmailAddress + '\'' +
                                    '}';

        public int GetAgeAtSpecificDate()
        {
            DateTime parse;
            parse = DateTime.Parse("2020-10-10");

            return (parse - _dob).Days;
        }
    }
}