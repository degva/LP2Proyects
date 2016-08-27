using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ConsoleApplication1.Controlador;

namespace ConsoleApplication1.Modelo
{
    class Infosoft
    {
        GestorEventos gestor;
        public Infosoft()
        {
            this.gestor = new GestorEventos();
        }
        public void Start()
        {
            Console.WriteLine("Sup m8s\nGuelcom to Infosoft");
            int a, option_d;
            bool f = true;
            while (f)
            {
                Console.WriteLine("What you wanna do?:");
                Console.WriteLine("1. Show me the events");
                Console.WriteLine("2. Show me an specific event");
                Console.WriteLine("3. Create a new event");
                Console.WriteLine("4. Agregar Equipo");
                Console.WriteLine("5. Exit :v\n");
                Console.Write("> ");
                a = Convert.ToInt16(Console.ReadLine());

                switch (a)
	            {
                    case 1:
                        Console.WriteLine("You have chose #1");
                        this.gestor.ImprimirCodigosEventos();
                        break;
                    case 2:
                        Console.WriteLine("Write the code");
                        option_d = int.Parse(Console.ReadLine());
                        this.gestor.ObtenerEvento(option_d);
                        break;
                    case 3:
                        Console.WriteLine("You have chose #3");
                        this.gestor.AgregarEvento();
                        break;
                    case 4:
                        Console.WriteLine("WARNING: The team code needs to exists");
                        Console.WriteLine("Write the code");
                        option_d = int.Parse(Console.ReadLine());
                        this.gestor.AgregarEquipo(option_d);
                        break;
                    case 5:
                        Console.WriteLine("Bai.\n");
                        Console.Read();
                        f = false;
                        break;
		            default:
                        Console.WriteLine("The fuck, that's not an option\n");
                        break;
	            }
            }   
        }
    }
}
