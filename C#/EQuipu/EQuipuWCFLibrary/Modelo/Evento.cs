using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace EQuipuWCFLibrary.Modelo
{
    [DataContract]
    [Serializable]
    public class Evento
    {
        private string _nombre;
        private string _categoriaEquipo;
        private int _numEntradas;
        private double _precioEntrada;
        private List<Equipo> _equipos;
        private List<Exposicion> _exposiciones;

        //Permite crear un evento
        public Evento(string nombre, string categoria, int numEntradas, double precio)
        {
            this._nombre = nombre;
            this._categoriaEquipo = categoria;
            this._numEntradas = numEntradas;
            this._precioEntrada = precio;
            this._equipos = new List<Equipo>();
            this._exposiciones = new List<Exposicion>();

        }

        public void AgregarEquipo(Equipo e)
        {
            _equipos.Add(e);
        }

        public void AgregarExposicion(Exposicion e)
        {
            _exposiciones.Add(e);
        }

        [DataMember]
        public List<Equipo> Equipos
        {
            get { return _equipos; }
            set { _equipos = value; }
        }

        [DataMember]
        internal List<Exposicion> Exposiciones
        {
            get { return _exposiciones; }
            set { _exposiciones = value; }
        }

        [DataMember]
        public int NumEntradas
        {
            get { return _numEntradas; }
            set { _numEntradas = value; }
        }

        [DataMember]
        public double PrecioEntrada
        {
            get { return _precioEntrada; }
            set { _precioEntrada = value; }
        }

        [DataMember]
        public string Nombre
        {
            get { return _nombre; }
            set { _nombre = value; }
        }

        [DataMember]
        public string CategoriaEquipo
        {
            get { return _categoriaEquipo; }
            set { _categoriaEquipo = value; }
        }
    }
}
