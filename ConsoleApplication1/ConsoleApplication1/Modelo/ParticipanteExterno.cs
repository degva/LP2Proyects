using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    class ParticipanteExterno : EquipoParticipante
    {
        private string lugarProveniencia;
        List<Persona> listaPersonas;

        public ParticipanteExterno(
            string lugarProveniencia, 
            string tema,
            string fechaParticipacion,
            int horaParticipacion,
            string nombreArchivo)
            : base(tema, fechaParticipacion, horaParticipacion, nombreArchivo)
        {
            this.lugarProveniencia = lugarProveniencia;
            this.listaPersonas = new List<Persona>();

        }

    }
}
