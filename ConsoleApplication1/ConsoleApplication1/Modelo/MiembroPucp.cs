using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Modelo
{
    public class MiembroPucp
    {
        private string codigoPucp;
        private string dni;
        private string nombre;
        private string fechaNacimiento;
        private string correo;
        private int tipoOrganizador; // 1 es organizador - 0 no es organizador
        private string cargo;
        private string responsabilidades;
        private int rol;

        public string CodigoPucp
        {
            get { return codigoPucp; }
            set { codigoPucp = value; }
        }

        public string Dni
        {
            get { return dni; }
            set { dni = value; }
        }

        public string Nombre
        {
            get {return nombre; }
            set {nombre = value; }
        }

        public string FechaNacimiento
        {
            get {return fechaNacimiento; }
            set {fechaNacimiento = value; }
        }

        public string Correo
        {
            get {return correo; }
            set {correo = value; }
        }

        public int TipoOrganizador
        {
            get {return tipoOrganizador; }
            set {tipoOrganizador = value; }
        }

        public string Cargo
        {
            get {return cargo; }
            set {cargo = value; }
        }

        public string Responsabilidades
        {
            get {return responsabilidades; }
            set {responsabilidades = value; }
        }

<<<<<<< HEAD

        public MiembroPucp(string codigo, int rol) //rol = 1 para alumno y rol = 2 para trabajador
        {
            codigoPucp = codigo;
            this.rol = rol;
        }
=======
        public void ImprimeNombre()
        {
            Console.Write(Nombre + ", ");
        }

        /*diego pls, no crees tonterias*/
>>>>>>> degva
    }
}
