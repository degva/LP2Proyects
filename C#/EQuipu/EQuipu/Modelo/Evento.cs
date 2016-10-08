using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    public class Evento
    {
        private string nombre;
        private string categoriaEquipo;
        private List<ExposicionEvento> exposiciones;
        private List<Entrada> entradas;

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public string CategoriaEquipo
        {
            get { return categoriaEquipo; }
            set { categoriaEquipo = value; }
        }
    }
}
