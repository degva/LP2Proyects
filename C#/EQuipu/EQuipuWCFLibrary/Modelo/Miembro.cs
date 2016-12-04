using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Runtime.Serialization;

namespace EQuipuWCFLibrary.Modelo
{
    [DataContract]
    [KnownType(typeof(Alumno))]
    [KnownType(typeof(Profesor))]
    [KnownType(typeof(Externo))]
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

        [DataMember]
        public char Sexo
        {
            get { return sexo; }
            set { sexo = value; }
        }

        [DataMember]
        public int Codigo
        {
            get { return codigo; }
            set { codigo = value; }
        }

        [DataMember]
        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        [DataMember]
        public string FechaNacimiento
        {
            get { return fechaNacimiento; }
            set { fechaNacimiento = value; }
        }

        [DataMember]
        public string Email
        {
            get { return email; }
            set { email = value; }
        }

        [DataMember]
        public string Direccion
        {
            get { return direccion; }
            set { direccion = value; }
        }
    }
}
