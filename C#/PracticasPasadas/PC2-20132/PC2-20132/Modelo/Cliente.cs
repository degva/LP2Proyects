using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PC2_20132.Modelo
{
    class Cliente : Persona
    {
        private List<Servicio> _servicios;

        internal List<Servicio> Servicios
        {
            get { return _servicios; }
            set { _servicios = value; }
        }

        public Cliente(int id, String nombre)
            : base(id, nombre)
        {

        }
    }
}
