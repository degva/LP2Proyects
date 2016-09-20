using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PC2_20132.Modelo
{
    class PersonaNatural : Persona
    {
        private int _dni;

        public PersonaNatural(int id, String nombre, int dni)
            : base(id, nombre)
        {
            Dni = dni;
        }

        public int Dni
        {
            get { return _dni; }
            set { _dni = value; }
        }

        public override String ACadena()
        {
            String aux = "Persona Id: " + Id.ToString() + "\nNombre: " + Nombre + "\nDNI: " + Dni.ToString();
            return aux;
        }

    }
}
