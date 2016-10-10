using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PC2_20132.Modelo
{
    class Contrato : Servicio
    {
        private string _textoContrato;

        public Contrato(Abogado abogado, string fIni, string fFin, string stdo, Persona contra, string contrato)
            : base(abogado, fIni, fFin, stdo, contra)
        {
            _textoContrato = contrato;
        }
    }
    // TODO: A Cadena
}
