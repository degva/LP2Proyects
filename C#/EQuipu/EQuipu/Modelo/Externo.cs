using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    [Serializable]
    public class Externo : Miembro
    {
        private string dedicacion;

        public Externo(int codigo, string nombre, string fechaNacimiento, string direccion, string email, char sexo, string dedicacion)
            : base(codigo, nombre, fechaNacimiento, direccion, email, sexo)
        {
            this.dedicacion = dedicacion;
        }

        public string Dedicacion
        {
            get { return dedicacion; }
            set { dedicacion = value; }
        }
    }
}
