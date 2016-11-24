using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
 * Nombre: Diego Pavel Vargas Flores
 * Examen 1
 */

namespace EQuipu.Modelo
{
    [Serializable]
    public class Feria
    {
        /*
         * El indice de la lista es el stand donde se ubica el equipo
         */
        private List<Equipo> _equipos;
        private string _nombre;
        private DateTime _fecha;

        public Feria(string nombre, DateTime fecha)
        {
            _nombre = nombre;
            _fecha = fecha;
            _equipos = new List<Equipo>();
        }

        //Creo un indizador para obtener un Usuario
        public Equipo this[int indice]
        {
            get
            {
                return this._equipos[indice];
            }
            set
            {
                this._equipos[indice] = value;
            }
        }

        public string Nombre
        {
            get { return _nombre; }
            set { _nombre = value; }
        }

        public DateTime Fecha
        {
            get { return _fecha; }
            set { _fecha = value; }
        }

        public void AddEquipo(Equipo e, int i)
        {
            _equipos.Insert(i, e);
        }

        public Equipo ObtenerEquipo(int idx)
        {
            return _equipos[idx];
        }
    }
}
