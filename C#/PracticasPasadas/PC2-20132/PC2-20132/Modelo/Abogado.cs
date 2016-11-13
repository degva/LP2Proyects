using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PC2_20132.Modelo
{
    class Abogado : PersonaNatural
    {
        private List<Servicio> _listaServicios;
        public Abogado(int id, string nombre, int dni)
            : base(id, nombre, dni)
        {
            _listaServicios = new List<Servicio>();
        }
    }
}
