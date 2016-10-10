using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    [Serializable]
    public class Exposicion
    {
        private Equipo _equipoParticipante;
        private string _fechaParticipacion;
        private int _horaParticipacion;
        private string _lugarParticipacion;
        private int _cantidadAsistentes;

        public Exposicion(Equipo e, string dia, int hora, string lugar, int cant)
        {
            _equipoParticipante = e;
            _fechaParticipacion = dia;
            _horaParticipacion = hora;
            _lugarParticipacion = lugar;
            _cantidadAsistentes = cant;
        }

        public Equipo EquipoParticipante
        {
            get { return _equipoParticipante; }
            set { _equipoParticipante = value; }
        }
        
        public string FechaParticipacion
        {
            get { return _fechaParticipacion; }
            set { _fechaParticipacion = value; }
        }
        
        public int HoraParticipacion
        {
            get { return _horaParticipacion; }
            set { _horaParticipacion = value; }
        }

        public string LugarParticipacion
        {
            get { return _lugarParticipacion; }
            set { _lugarParticipacion = value; }
        }
       
        public int CantidadAsistentes
        {
            get { return _cantidadAsistentes; }
            set { _cantidadAsistentes = value; }
        }
    }
}
