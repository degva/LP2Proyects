using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Runtime.Serialization;

namespace EQuipuWCFLibrary.Modelo
{
    [DataContract]
    [Serializable]
    public class Alumno : Miembro
    {
        private long codigoAlumno;
        private double craest;

        public Alumno(int codigo, string nombre, string fechaNacimiento, string direccion, string email, char sexo, long codigoAlumno, double craest)
            : base(codigo, nombre, fechaNacimiento, direccion, email, sexo)
        {
            this.codigoAlumno = codigoAlumno;
            this.craest = craest;
        }

        [DataMember]
        public long CodigoAlumno
        {
            get { return codigoAlumno; }
            set { codigoAlumno = value; }
        }

        [DataMember]
        public double Craest
        {
            get { return craest; }
            set { craest = value; }
        }
    }
}
