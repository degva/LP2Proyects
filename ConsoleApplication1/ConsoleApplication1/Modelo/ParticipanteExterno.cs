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
            listaPersonas = new List<Persona>();
        }


        public void AgregarParticipanteExterno(Persona persona)
        {
            listaPersonas.Add(persona);
        }


        public void GetNombresIntegrantes()
        {
            Console.WriteLine("Integrantes:");
            int counter = 1;
            foreach (var item in listaPersonas)
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
