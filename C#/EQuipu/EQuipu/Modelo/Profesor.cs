using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    [Serializable]
    public class Profesor : Miembro, Consultable
    {
        private long codigoProfesor;
        private string estado;

        public Profesor(int codigo, string nombre, string fechaNacimiento, string direccion, string email, char sexo, long codigoProfesor, string estado)
            : base(codigo, nombre, fechaNacimiento, direccion, email, sexo)
        {
            this.codigoProfesor = codigoProfesor;
            this.estado = estado;
        }

        public string Estado
        {
            get { return estado; }
            set { estado = value; }
        }

        public long CodigoProfesor
        {
            get { return codigoProfesor; }
            set { codigoProfesor = value; }
        }

        public String getInformacion()
        {
            return this.codigoProfesor.ToString() + "-" + this.nombre + "-" + this.estado + "\n";
        }
    }
}
