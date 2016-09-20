using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    public class EquipoParticipante
    {
        private string tema;
        private string fechaParticipacion;
        private string horaParticipacion;
        private string nombreArchivo;
        //ponemos el nombre de encuesta aqui porque creo que es por equipo participante
        private Encuesta encuestaEquipo;



        public EquipoParticipante(string tema, string fechaParticipacion, string horaParticipacion, string nombreArchivo, string nombreEncuesta)
        {
            this.tema = tema;
            this.fechaParticipacion = fechaParticipacion;
            this.horaParticipacion = horaParticipacion;
            this.nombreArchivo = nombreArchivo;
            encuestaEquipo = new Encuesta(nombreEncuesta);
            encuestaEquipo.NombreEncuesta = nombreEncuesta;
        }


        public string Tema{
            get
            {
             return tema;
            }
            set
            {
                tema = value;
            }
        }


        public string FechaParticipacion {
            get 
            {
                return fechaParticipacion;
            }
            set 
            {
                fechaParticipacion = value;
            } 
        }


        public string HoraParticipacion { 
            get
            {
                return horaParticipacion;
            }
            set
            {
                horaParticipacion = value;
            } 
        }


        public string NombreArchivo
        {
            get
            {
                return nombreArchivo;
            }
            set
            {
                nombreArchivo = value;
            }
        }

        /*
        public string NombreEncuesta
        {
            get
            {
                return _nombreEncuesta;
            }

            set
            {
                _nombreEncuesta = value;
            }
        }
        */

        public void ModificarEncuesta()
        {
            int opcion;

            Console.WriteLine("Que desea hacer con la encuesta: ");
            Console.WriteLine("1. Agregar preguntas");
            Console.WriteLine("2. Modificar preguntas");
            Console.WriteLine("3. Eliminar preugntas");
            Console.WriteLine("4. Consultar preugntas");
            Console.WriteLine("5. Nada");
            Console.Write("> ");
            opcion = int.Parse(Console.ReadLine());

            switch (opcion)
            {
                case 1:
                    encuestaEquipo.agregarPreguntas();
                    break;
                case 2:
                    encuestaEquipo.modificarPreguntas();
                    break;
                case 3:
                    encuestaEquipo.eliminarPreguntas();
                    break;
                case 4:
                    encuestaEquipo.consultarPreguntas();
                    break;
                case 5:
                    Console.WriteLine("Saliendo de esta opcion...");
                    break;
                default:
                    Console.WriteLine("Esta no es una opcion valida...");
                    break;
            }
        }
    }
}
