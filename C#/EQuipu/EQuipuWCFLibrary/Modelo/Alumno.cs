using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Runtime.Serialization;

namespace EQuipuWCFLibrary.Modelo
{
    [DataContract]
    public class Alumno : Miembro, Consultable
    {
        [DataMember]
        private long codigoAlumno;
        [DataMember]
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

        public String getInformacion()
        {
            return this.codigoAlumno.ToString() + "-" + this.nombre + "-" + this.craest.ToString() + "\n";
        }
    }
}
