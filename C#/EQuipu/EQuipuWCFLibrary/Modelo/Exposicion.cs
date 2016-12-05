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
    public class Exposicion
    {
        private int _id;
        private Equipo _equipoParticipante;
        private string _fechaParticipacion;
        private int _horaParticipacion;
        private string _lugarParticipacion;
        private int _cantidadAsistentes;

        public Exposicion(int id, Equipo e, string dia, int hora, string lugar, int cant)
        {
            _id = id;
            _equipoParticipante = e;
            _fechaParticipacion = dia;
            _horaParticipacion = hora;
            _lugarParticipacion = lugar;
            _cantidadAsistentes = cant;
        }

        public Exposicion(Equipo e, string dia, int hora, string lugar, int cant)
        {
            _id = -1;
            _equipoParticipante = e;
            _fechaParticipacion = dia;
            _horaParticipacion = hora;
            _lugarParticipacion = lugar;
            _cantidadAsistentes = cant;
        }

        [DataMember]
        public int Id
        {
            get { return _id; }
            set { _id = value; }
        }

        [DataMember]
        public Equipo EquipoParticipante
        {
            get { return _equipoParticipante; }
            set { _equipoParticipante = value; }
        }

        [DataMember]
        public string FechaParticipacion
        {
            get { return _fechaParticipacion; }
            set { _fechaParticipacion = value; }
        }

        [DataMember]
        public int HoraParticipacion
        {
            get { return _horaParticipacion; }
            set { _horaParticipacion = value; }
        }

        [DataMember]
        public string LugarParticipacion
        {
            get { return _lugarParticipacion; }
            set { _lugarParticipacion = value; }
        }

        [DataMember]
        public int CantidadAsistentes
        {
            get { return _cantidadAsistentes; }
            set { _cantidadAsistentes = value; }
        }
    }
}
