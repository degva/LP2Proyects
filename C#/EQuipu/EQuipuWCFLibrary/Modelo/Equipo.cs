using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace EQuipuWCFLibrary.Modelo
{
    [DataContract]
    [Serializable]
    public class Equipo
    {

        private List<Miembro> listaMiembros;
        private string nombre;
        private string interes;
        private string categoria;
        private double fondo;

        private int entradas;

        public Equipo(string nombre, string interes, string categoria)
        {
            this.nombre = nombre;
            this.interes = interes;
            this.categoria = categoria;
            this.listaMiembros = new List<Miembro>();

            this.entradas = 0;
        }

        public void AddMiembro(Miembro miembro)
        {
            this.listaMiembros.Add(miembro);
        }

        public Miembro GetByCodigo(int codigo)
        {
            Miembro objMiembro = null;
            for (int i = 0; i < listaMiembros.Count; i++)
            {
                if (listaMiembros[i].Codigo == codigo)
                {
                    objMiembro = listaMiembros[i];
                }
            }
            return objMiembro;
        }

        [DataMember]
        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        [DataMember]
        public string Interes
        {
            get { return interes; }
            set { interes = value; }
        }

        [DataMember]
        public string Categoria
        {
            get { return categoria; }
            set { categoria = value; }
        }

        [DataMember]
        public double Fondo
        {
            get { return fondo; }
            set { fondo = value; }
        }

        [DataMember]
        public List<Miembro> ListaMiembros
        {
            get { return listaMiembros; }
            set { listaMiembros = value; }
        }

        [DataMember]
        public int Entradas
        {
            get { return entradas; }
            set { entradas = value; }
        }
    }
}
