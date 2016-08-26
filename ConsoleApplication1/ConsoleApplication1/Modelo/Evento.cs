using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    public class Evento
    {
        private int _codigo;
        private string _nombre;
        private string _fechaInaguracion;
        private string _fechaInicio;
        private string _fechaFin;

        List<EquipoParticipante> _equiposParticipantes;


        public Evento(int codigo, string nombre, string fInaguracion,string fInicio, string fFin)
        {
            _codigo = codigo;
            _nombre = nombre;
            _fechaInaguracion = fInaguracion;
            _fechaInicio = fInicio;
            _fechaFin = fFin;
            _equiposParticipantes = new List<EquipoParticipante>();
        }


        public int Codigo
        {
            get
            {
                return _codigo;
            }
            set
            {
                _codigo = value;
            }
        }


        public string Nombre
        {
            get
            {
                return _nombre;
            }
            set
            {
                _nombre = value;
            }
        }


        public string FechaInaguracion
        {
            get
            {
                return _fechaInaguracion;
            }
            set
            {
                _fechaInaguracion = value;
            }
        }


        public string FechaInicio
        {
            get
            {
                return _fechaInicio;
            }
            set
            {
                _fechaInicio = value;
            }
        }


        public string FechaFin
        {
            get
            {
                return _fechaFin;
            }
            set
            {
                _fechaFin = value;
            }
        }


        public void AgregarEquipo()
        {
            EquipoParticipante equipo;
            string tema, fechaP, nomArch;
            int hora;

            Console.Write("Ingrese el tema: ");
            tema = Console.ReadLine();
            Console.Write("Ingrese la fecha de participacion: ");
            fechaP = Console.ReadLine();
            Console.Write("Ingrese el nombre del archivo: ");
            nomArch = Console.ReadLine();
            Console.Write("Ingrese la hora de participacion: ");
            hora = int.Parse(Console.ReadLine());

            equipo = new EquipoParticipante(tema,fechaP,hora,nomArch);

            _equiposParticipantes.Add(equipo);
        }


        public void ImprimirEvento()
        {
            Console.WriteLine("-------------------------------------------------------------");
            Console.WriteLine("Evento: " + Nombre);
            Console.WriteLine("Codigo: " + Codigo);
            Console.WriteLine("Fecha de Inaguracion: " + FechaInaguracion);
            Console.WriteLine("Fecha Inicio: " + FechaInicio);
            Console.WriteLine("Fecha Fin: " + FechaFin);
            Console.WriteLine("Equipos participantes:");

            int counter = 1;

            foreach (var equipo in _equiposParticipantes)
            {
                Console.WriteLine("Equipo numero " + counter + ":");
                Console.WriteLine("\tHora de participacion: " + equipo.HoraParticipacion);
                Console.WriteLine("\tTema: " + equipo.Tema);
                Console.WriteLine("\tFecha de Participacion: " + equipo.FechaParticipacion);
                Console.WriteLine("\tNombre del archivo: " + equipo.NombreArchivo);
                Console.WriteLine();
                counter++;
            }

            Console.WriteLine("-------------------------------------------------------------");

        }
    }
}
