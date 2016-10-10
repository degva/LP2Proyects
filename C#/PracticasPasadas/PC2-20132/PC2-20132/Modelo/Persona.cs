using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PC2_20132.Modelo
{
    class Persona : Imprimible
    {
        private int _id;
        private String _nombre;

        public Persona(int id, String nombre)
        {
            Id = id;
            Nombre = nombre;
        }

        public String ACadena()
        {
            String aux = "Persona Id: " + Id.ToString() +"\nNombre: " + Nombre;
            return aux;
        }

        public String Nombre
        {
            get { return _nombre; }
            set { _nombre = value; }
        }
        
        public int Id
        {
            get { return _id; }
            set { _id = value; }
        }

    }
}
