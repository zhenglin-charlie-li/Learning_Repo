using System;
using Tomlet;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            string myTomlString =
                @"
Rule1 = '*,EW,*,ErrorAndWarning'
Rule2 = '*,I,*,Info'
MaxFiles = 10
[ErrorAndWarning]
MaxFileSize = 10000000
FileNameBase = 'Local\ErrorAndWarning'
BufferSize = 10000";
            TomlParser parser = new TomlParser();
            Tomlet.Models.TomlDocument document = parser.Parse(myTomlString);
            Console.WriteLine("document");

            int someInt = document.GetInteger("MaxFiles");
            string someString = document.GetString("Rule1");
            Console.WriteLine(someInt);
            Console.WriteLine(someString);

            int subTableInt = document.GetSubTable("ErrorAndWarning").GetInteger("BufferSize");
            string subTableString = document.GetSubTable("ErrorAndWarning").GetString("FileNameBase");
            Console.WriteLine(subTableInt);
            Console.WriteLine(subTableString);
        }
    }
}
