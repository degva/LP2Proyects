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
        private String paginaWeb;

        public Infosoft()
        {
            gestor = new GestorEventos();
        }

        public void Start()
        {
            Console.WriteLine("Bienvenido a Infosoft");
            int a, option_d;
            bool f = true;
            while (f)
            {
                Console.WriteLine("¿Que desea hacer?:");
                Console.WriteLine("1. Muestrame todos los eventos");
                Console.WriteLine("2. Muestarme un evento específico");
                Console.WriteLine("3. Crear un nuevo evento");
                Console.WriteLine("4. Agregar Equipo");
                Console.WriteLine("5. Dar mantenimiento a la encuesta de un Equipo");
                Console.WriteLine("6. Exit \n");
                Console.Write("> ");
                a = int.Parse(Console.ReadLine());

                switch (a)
                {
                    case 1:
                        Console.WriteLine("\nHaz elegido el nuemero #1, esta es la lista de eventos");
                        gestor.ImprimirCodigosEventos();
                        break;
                    case 2:
                        Console.WriteLine("\nEscriba el codigo del evento que desea ver: ");
                        option_d = int.Parse(Console.ReadLine());
                        gestor.ObtenerEvento(option_d);
                        break;
                    case 3:
                        Console.WriteLine("\nHaz elegido el numero #3");
                        gestor.AgregarEvento();
                        break;
                    case 4:
                        Console.WriteLine("\nADVERTENCIA: EL CODIGO DEL EVENTO DEBE EXISTIR");
                        Console.WriteLine("Escribe el codigo del Evento: ");
                        option_d = int.Parse(Console.ReadLine());
                        gestor.AgregarEquipo(option_d);
                        break;
                    case 5:
                        Console.WriteLine("\nADVERTENCIA: EL CODIGO DEL EVENTO DEBE EXISTIR");
                        Console.WriteLine("Escribe el codigo del Evento: ");
                        option_d = int.Parse(Console.ReadLine());
                        break;
                    case 6:
                        Console.WriteLine("Adiós\n");
                        Console.Read();
                        f = false;
                        break;
                    default:
                        Console.WriteLine("Esa no es una opción válida \n");
                        break;
                }
            }
        }



        public string PaginaWeb
        {
            get
            {
                return paginaWeb;
            }

            set
            {
                paginaWeb = value;
            }
        }

    }
}

