using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    public class Alumno: MiembroPucp
    {
        private int craest;
        private int nivel;

        public int Craest
        {
            get
            {
                return craest;
            }

            set
            {
                craest = value;
            }
        }

        public int Nivel
        {
            get
            {
                return nivel;
            }

            set
            {
                nivel = value;
            }
        }

        public Alumno(int nivel, int craest, string codigo) : base(codigo, 1)
        {
            this.nivel = nivel;
            this.craest = craest;
        }
    }
}
