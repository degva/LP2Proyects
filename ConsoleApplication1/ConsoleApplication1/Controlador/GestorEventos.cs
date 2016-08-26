using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ConsoleApplication1.Modelo;

namespace ConsoleApplication1.Controlador
{
    class GestorEventos
    {
        List<Evento> eventos;

        public GestorEventos()
        {
            this.eventos = new List<Evento>();
        }

        public void AgregarEvento()
        {
            // int codigo, string nombre, string fInaguracion,string fInicio, string fFin
            int codigo;
            string nombre;
            string fInaguracion;
            string fInicio;
            string fFin;

            Console.WriteLine("Ingrese el codigo: ");
            codigo = int.Parse(Console.ReadLine());
            Console.WriteLine("Ingrese el nombre: ");
            nombre = Console.ReadLine();
            Console.WriteLine("Ingrese fecha inaguracion: ");
            fInaguracion = Console.ReadLine();
            Console.WriteLine("Ingrese fecha inicio: ");
            fInicio = Console.ReadLine();
            Console.WriteLine("Ingrese fecha Fin: ");
            fFin = Console.ReadLine();

            Evento e = new Evento(codigo, nombre, fInaguracion, fInicio, fFin);
            eventos.Add(e);
        }

        public void ImprimirCodigosEventos()
        {
            if (this.eventos.Count == 0)
            {
                Console.WriteLine("There's nothing here...");
            }
            else
            {
                Evento aux;
                for (int i = 0; i < this.eventos.Count; i++)
                {
                    aux = eventos[i];
                    Console.WriteLine(aux.Codigo);
                }
                Console.WriteLine();
            }
            
        }

        public void AgregarEquipo(int codigo)
        {
            Evento aux;
            for (int i = 0; i < this.eventos.Count; i++)
            {
                aux = eventos[i];
                if (aux.Codigo == codigo)
                {
                    aux.AgregarEquipo();
                    return;
                }
            }
            Console.WriteLine("QUE CHUCHA DIJE! >:v \n");
        }

        public void ObtenerEvento(int codigo)
        {
            Evento aux;
            for (int i = 0; i < this.eventos.Count; i++)
            {
                aux = eventos[i];
                if (aux.Codigo == codigo)
                {
                    aux.ImprimirEvento();
                }
            }
        }
    }
}
