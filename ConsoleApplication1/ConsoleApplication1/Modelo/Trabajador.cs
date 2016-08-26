using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    class Trabajador
    {
        private string especialidad;
        private string grado;
        private string horaEntrada;
        private string horaSalida;
        private int tipoTrabajador;//1 Docente - 2 Administartivo

        public string Especialidad
        {
            get
            {
                return especialidad;
            }

            set
            {
                especialidad = value;
            }
        }

        public string Grado
        {
            get
            {
                return grado;
            }

            set
            {
                grado = value;
            }
        }

        public string HoraEntrada
        {
            get
            {
                return horaEntrada;
            }

            set
            {
                horaEntrada = value;
            }
        }

        public string HoraSalida
        {
            get
            {
                return horaSalida;
            }

            set
            {
                horaSalida = value;
            }
        }

        public int TipoTrabajador
        {
            get
            {
                return tipoTrabajador;
            }

            set
            {
                tipoTrabajador = value;
            }
        }
    }
}
