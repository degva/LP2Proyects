using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PC2_20132.Modelo
{
    class PersonaJuridica : Persona
    {
        private String _ruc;

        public PersonaJuridica(int id, String razonSocial, String ruc)
            : base(id, razonSocial)
        {
            Ruc = ruc;
        }

        public String RazonSocial
        {
            get { return Nombre; }
            set { Nombre = value; }
        }

        public String Ruc
        {
            get { return _ruc; }
            set { _ruc = value; }
        }

    }
}
