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
            string horaParticipacion,
            string nombreArchivo,
            string nombreEncuesta)
            : base(tema, fechaParticipacion, horaParticipacion, nombreArchivo, nombreEncuesta)
        {
            this.lugarProveniencia = lugarProveniencia;
            listaPersonas = new List<Persona>();
        }

        
        public void AgregarIntegrantes()
        {
           
        }
        

        public void AgregarPersonas()
        {
            string nombre, dni, lProveniencia;
            
            Console.Write("Ingrese Nombre: ");
            nombre = Console.ReadLine();

            Console.Write("Ingrese Dni: ");
            dni = Console.ReadLine();

            Console.Write("Ingrese lugar de Provaniencia: ");
            lProveniencia = Console.ReadLine();

            Persona persona = new Persona(dni, nombre);
            listaPersonas.Add(persona);

        }

        public String GetNombresIntegrantes()
        {
            String nombresIntegrantes = "Integrantes: ";
            int counter = 1;
            foreach (var item in listaPersonas)
            {
                if (counter == 1)
                {
                    nombresIntegrantes += item.Nombre;
                }
                else
                {
                    nombresIntegrantes += "," + item.Nombre;
                }
            }
            return nombresIntegrantes;
        }

    }
}
