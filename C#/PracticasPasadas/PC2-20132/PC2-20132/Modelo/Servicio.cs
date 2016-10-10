using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PC2_20132.Modelo
{
    class Servicio : Imprimible
    {
        private Abogado _abogadoEncargado;
        private string _fechaInicio;
        private string _fechaFin;
        private string _estado; // puede ser iniciado, paralizado, finalizado
        private Persona _contraparte;
        private string _veredicto;

        public string Veredicto
        {
            get { return _veredicto; }
            set { _veredicto = value; }
        }

        public Servicio(Abogado abogado, string fIni, string fFin, string stdo, Persona contra)
        {
            _abogadoEncargado = abogado;
            _fechaInicio = fIni;
            _fechaFin = fFin;
            _estado = stdo;
            _contraparte = contra;
        }

        // Todo: A Cadena
        
    }
}
