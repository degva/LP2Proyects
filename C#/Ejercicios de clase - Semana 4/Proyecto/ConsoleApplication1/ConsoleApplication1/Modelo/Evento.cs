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
        List<MiembroPucp> _organizadores;


        public Evento(int codigo, string nombre, string fInaguracion,string fInicio, string fFin)
        {
            _codigo = codigo;
            _nombre = nombre;
            _fechaInaguracion = fInaguracion;
            _fechaInicio = fInicio;
            _fechaFin = fFin;
            _equiposParticipantes = new List<EquipoParticipante>();
            _organizadores = new List<MiembroPucp>();
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
            string tema, fechaP, nomArch, hora, nombreEncuesta;
            int option;
                        
            Console.WriteLine("Seleccione el tipo de equipo:");
            Console.WriteLine("1) Participantes PUCP\n2) Participantes Externos");
            option = int.Parse(Console.ReadLine());

            Console.Write("Ingrese el tema: ");
            tema = Console.ReadLine();
            Console.Write("Ingrese la fecha de participacion: ");
            fechaP = Console.ReadLine();
            Console.Write("Ingrese la hora de participacion: ");
            hora = Console.ReadLine();
            Console.Write("Ingrese el nombre del archivo: ");
            nomArch = Console.ReadLine();
            Console.Write("Ingrese el nombre del archivo de encuesta del equipo: ");
            nombreEncuesta = Console.ReadLine();


            if (option == 1)
            {
                ParticipantePucp equipoPucp;
                equipoPucp = new ParticipantePucp(tema, fechaP, hora, nomArch, nombreEncuesta);
                equipoPucp.AgregarIntegrantes();
                _equiposParticipantes.Add(equipoPucp);
            }
            else if (option == 2)
            {
                Console.WriteLine("Ingrese el lugar de proveniencia: ");
                string lugarProv = Console.ReadLine();
                ParticipanteExterno equipoExterno;
                equipoExterno = new ParticipanteExterno(lugarProv, tema, fechaP, hora, nomArch, nombreEncuesta);
                equipoExterno.AgregarIntegrantes();
                _equiposParticipantes.Add(equipoExterno);
            }

            
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

        public void AgregarOrganizadores()
        {
            bool deseoAgregarOrganizadores = true;
            int a;
            while (deseoAgregarOrganizadores)
            {
                string codigoPucp, dni, nombre, fNac, correo, cargo, respons;
                int tipoOrg, rol;

                Console.WriteLine("Desea agregar a un organizador? 1 - SI | 2 - SALIR DE ESTA OPCION");
                a = int.Parse(Console.ReadLine());
                if (a != 1)
                {
                    deseoAgregarOrganizadores = false;
                    break;
                }

                Console.Write("Ingrese Nombre: ");
                nombre = Console.ReadLine();

                Console.Write("Ingrese codigo: ");
                codigoPucp = Console.ReadLine();

                Console.Write("Ingrese dni: ");
                dni = Console.ReadLine();

                Console.Write("Ingrese Fecha de nacimiento: ");
                fNac = Console.ReadLine();

                Console.Write("Ingrese correo: ");
                correo = Console.ReadLine();

                tipoOrg = 1;

                Console.Write("Ingrese cargo: ");
                cargo = Console.ReadLine();

                Console.Write("Ingrese responsabilidad: ");
                respons = Console.ReadLine();

                Console.Write("Es Alumno (1) o Trabajador (0): ");
                rol = int.Parse(Console.ReadLine());

                MiembroPucp miembroPucp = new MiembroPucp(codigoPucp, rol);
                miembroPucp.Dni = dni;
                miembroPucp.Nombre = nombre;
                miembroPucp.FechaNacimiento = fNac;
                miembroPucp.Correo = correo;
                miembroPucp.TipoOrganizador = tipoOrg;
                miembroPucp.Cargo = cargo;
                miembroPucp.Responsabilidades = respons;

                _organizadores.Add(miembroPucp);
            }
        }

        public void ModificarEncuestaDeUnEquipo()
        {
            int codigo;
            Console.WriteLine("Ingrese el nuemro de equipo: ");
            codigo = int.Parse(Console.ReadLine());

            int contador = 0;
            foreach (EquipoParticipante equipo in _equiposParticipantes)
            {
                contador++;
                if (contador == codigo) equipo.ModificarEncuesta();
            }
        }
    }
}
