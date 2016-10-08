using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    [Serializable]
    public class Miembro
    {
        protected int codigo;
        protected string nombre;
        protected string fechaNacimiento;
        protected string direccion;
        protected string email;
        protected char sexo;

        public Miembro(int codigo, string nombre, string fechaNacimiento, string direccion, string email, char sexo)
        {
            this.codigo = codigo;
            this.direccion = direccion;
            this.email = email;
            this.fechaNacimiento = fechaNacimiento;
            this.nombre = nombre;
            this.sexo = sexo;
        }

        public char Sexo
        {
            get { return sexo; }
            set { sexo = value; }
        }

        public int Codigo
        {
            get { return codigo; }
            set { codigo = value; }
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public string FechaNacimiento
        {
            get { return fechaNacimiento; }
            set { fechaNacimiento = value; }
        }

        public string Email
        {
            get { return email; }
            set { email = value; }
        }

        public string Direccion
        {
            get { return direccion; }
            set { direccion = value; }
        }
    }
}
