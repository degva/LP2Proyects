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
            string horaParticipacion,
            string nombreArchivo)
            : base(tema, fechaParticipacion, horaParticipacion, nombreArchivo)
        {
            _equipoPucp = new List<MiembroPucp>();
        }

        public void AgregarIntegrantes()
        {
            int a;
            bool f = true;
            while (f)
            {
                Console.WriteLine("\nDesea agregar un particpante? 1 - SI | 2 - SALIR DE ESTA OPCION");
                a = int.Parse(Console.ReadLine());

                if (a == 1)
                {
                    AgregarMiembroPucp();
                }
                else
                {
                    f = false;
                }
                  
            }
        }

        public void AgregarMiembroPucp()
        {
            string codigoPucp, dni, nombre, fNac, correo, cargo, respons;
            int tipoOrg, rol;

            Console.Write("Ingrese Nombre: ");
            nombre = Console.ReadLine();

            Console.Write("Ingrese codigo: ");
            codigoPucp = Console.ReadLine();

            Console.Write("Ingrese dni: ");
            dni = Console.ReadLine();

            Console.Write("Ingrese Fecha de nacimiento: ");
            fNac = Console.ReadLine();

            Console.Write("Ingrese correo: ");
            correo = Console.ReadLine();

            Console.Write("Es organizador?? (1 SI - 0 NO): ");
            tipoOrg = int.Parse(Console.ReadLine());

            if (tipoOrg == 1)
            {
                Console.Write("Ingrese cargo: ");
                cargo = Console.ReadLine();

                Console.Write("Ingrese responsabilidad: ");
                respons = Console.ReadLine();
            }
            else
            {
                cargo = " ";
                respons = " ";
            }

            Console.Write("Es Alumno (1) o Trabajador (0): ");
            rol = int.Parse(Console.ReadLine());
           
            MiembroPucp miembroPucp = new MiembroPucp(codigoPucp, rol);
            miembroPucp.Dni = dni;
            miembroPucp.Nombre = nombre;
            miembroPucp.FechaNacimiento = fNac;
            miembroPucp.Correo = correo;
            miembroPucp.TipoOrganizador = tipoOrg;
            miembroPucp.Cargo = cargo;
            miembroPucp.Responsabilidades = respons;

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
