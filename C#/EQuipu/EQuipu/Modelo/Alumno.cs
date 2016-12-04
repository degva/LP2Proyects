using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
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

        public long CodigoAlumno
        {
            get { return codigoAlumno; }
            set { codigoAlumno = value; }
        }

        public double Craest
        {
            get { return craest; }
            set { craest = value; }
        }
    }
}
