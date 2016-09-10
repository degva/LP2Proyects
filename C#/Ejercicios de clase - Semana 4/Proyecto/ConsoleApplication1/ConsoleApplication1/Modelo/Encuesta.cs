using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApplication1.Modelo
{
    class Encuesta
    {
        private String _nombreEncuesta;
        private int _nPreguntas;
        private List<int> _rersultados;

        public Encuesta(string nombreEncuesta)
        {
            this._nombreEncuesta = nombreEncuesta;
            this._nPreguntas = 0;
        }

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

        public int NPreguntas
        {
            get
            {
                return _nPreguntas;
            }

            set
            {
                _nPreguntas = value;
            }
        }

        public void agregarPreguntas()
        {
            FileStream archivoOut;
            if(_nPreguntas == 0) //si es la primera pregunta, creamos el archivo
                archivoOut = new FileStream(this._nombreEncuesta, FileMode.Create, FileAccess.Write);
            else //sino agregarmos
                archivoOut = new FileStream(this._nombreEncuesta, FileMode.Append, FileAccess.Write);

            StreamWriter escritor = new StreamWriter(archivoOut);

            bool deseaAgregarPreguntas = true;
            int opcion;
            while (deseaAgregarPreguntas)
            {
                string pregunta;
                Console.WriteLine("Ingrese la pregunta que desea agregar a al aencuesta: ");
                pregunta = Console.ReadLine();
                _nPreguntas++;
                escritor.WriteLine(_nPreguntas + ". " + pregunta + "\n");
                Console.WriteLine("Desea agregar otra preugnta? 1-SI|0-NO");
                opcion = int.Parse(Console.ReadLine());
                switch (opcion)
                {
                    case 1:
                        break;
                    case 2:
                        deseaAgregarPreguntas = false;
                        break;
                    default:
                        Console.WriteLine("Esta no es un opcion valida...");
                        deseaAgregarPreguntas = false;
                        break;
                }

            }

        }

        public void modificarPreguntas()
        {

        }

        public void eliminarPreguntas()
        {

        }

        public void consultarPreguntas()
        {

        }
    }
}
