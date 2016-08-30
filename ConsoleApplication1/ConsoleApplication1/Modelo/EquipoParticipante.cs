using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    public class EquipoParticipante
    {
        private string tema;
        private string fechaParticipacion;
        private int horaParticipacion;
        private string nombreArchivo;



        public EquipoParticipante(string tema, string fechaParticipacion, int horaParticipacion, string nombreArchivo)
        {
            this.tema = tema;
            this.fechaParticipacion = fechaParticipacion;
            this.horaParticipacion = horaParticipacion;
            this.nombreArchivo = nombreArchivo;
        }


        public string Tema{
            get
            {
             return tema;
            }
            set
            {
                tema = value;
            }
        }


        public string FechaParticipacion {
            get 
            {
                return fechaParticipacion;
            }
            set 
            {
                fechaParticipacion = value;
            } 
        }


        public int HoraParticipacion { 
            get
            {
                return horaParticipacion;
            }
            set
            {
                horaParticipacion = value;
            } 
        }


        public string NombreArchivo
        {
            get
            {
                return nombreArchivo;
            }
            set
            {
                nombreArchivo = value;
            }
        }     
    }
}
