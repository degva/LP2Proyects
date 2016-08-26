using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    class Persona
    {
        // datos miembro de persona
        private string dni;
        private string nombre;

        // Metodos
        // Constructor
        public Persona(string dni, string nombre)
        {
            this.dni = dni;
            this.nombre = nombre;
        }
    }
}
