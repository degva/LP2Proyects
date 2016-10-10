using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    public class Entrada
    {
        private double precioEntrada;
        private string fechaExposicion;
        private int horaExposicion;
        private string lugarExposicion;

        public double PrecioEntrada
        {
            get { return precioEntrada; }
            set { precioEntrada = value; }
        }
        
        public string FechaExposicion
        {
            get { return fechaExposicion; }
            set { fechaExposicion = value; }
        }
        
        public int HoraExposicion
        {
            get { return horaExposicion; }
            set { horaExposicion = value; }
        }
        
        public string LugarExposicion
        {
            get { return lugarExposicion; }
            set { lugarExposicion = value; }
        }
    }
}
