using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    public class ParticipantePucp : EquipoParticipante
    {

        private List<MiembroPucp> _equipoPucp;

        public ParticipantePucp(string tema,
            string fechaParticipacion,
            int horaParticipacion,
            string nombreArchivo)
            : base(tema, fechaParticipacion, horaParticipacion, nombreArchivo)
        {
            _equipoPucp = new List<MiembroPucp>();
        }


        public void AgregarMiembroPucp(MiembroPucp miembroPucp)
        {
            _equipoPucp.Add(miembroPucp);
        }


        public void GetNombresIntegrantes()
        {
            Console.WriteLine("Integrantes:");
            int counter = 1;
            foreach (var item in _equipoPucp)
            {
                if (counter == 1)
                {
                    Console.Write(item.Nombre);
                }
                else
                {
                    Console.WriteLine("," + item.Nombre);
                }
            }
        }
    }
}
