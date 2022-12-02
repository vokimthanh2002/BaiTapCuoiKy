using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace thanh
{

    class Program

    {
        static void Hien_Thi()
        {
            XElement xelement = XElement.Load("../../thanh1.xml");
            IEnumerable<XElement> employees = xelement.Elements();
            // Read the entire XML
            foreach (var employee in employees)
            {
                Console.WriteLine(employee);
            }
            //Console.ReadKey();
        }
        static void Hien_Thi_Mot_Element()
        {
            XElement xelement = XElement.Load("..\\..\\thanh1.xml");
            IEnumerable<XElement> employees = xelement.Elements();
            Console.WriteLine("Hien thi Name cac element :");
            foreach (var employee in employees)
            {
                Console.WriteLine(employee.Element("Name").Value);
            }
            // Console.ReadKey();

        }

        static void Hien_Thi_Nhieu_Element()
        {
            XElement xelement = XElement.Load("..\\..\\thanh1.xml");
            IEnumerable<XElement> employees = xelement.Elements();
            Console.WriteLine("Hien thi Name va Id cua Employee Names:");
            foreach (var employee in employees)
            {
                Console.WriteLine("{0} co ID Employee {1}",
                employee.Element("Name").Value,
                employee.Element("EmpId").Value);
            }


        }
        static void Main(string[] args)
        {
            Hien_Thi_Mot_Element();
            Hien_Thi();
            Hien_Thi_Nhieu_Element();
            Console.ReadKey();

        }
        
    }
}
