using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Runtime.Serialization;

namespace EQuipuWCFLibrary.Modelo
{
    [DataContract]
    public class Profesor : Miembro, Consultable
    {
        [DataMember]
        private long codigoProfesor;
        [DataMember]
        private string estado;

        public Profesor(int codigo, string nombre, string fechaNacimiento, string direccion, string email, char sexo, long codigoProfesor, string estado)
            : base(codigo, nombre, fechaNacimiento, direccion, email, sexo)
        {
            this.codigoProfesor = codigoProfesor;
            this.estado = estado;
        }

        [DataMember]
        public string Estado
        {
            get { return estado; }
            set { estado = value; }
        }

        [DataMember]
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
