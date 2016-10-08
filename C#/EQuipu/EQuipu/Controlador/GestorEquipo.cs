using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using EQuipu.Modelo;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace EQuipu.Controlador
{
    public class GestorEquipos
    {
        private List<Equipo> listaEquipos;

        public GestorEquipos()
        {
            listaEquipos = new List<Equipo>();
        }

        public List<Equipo> ListaEquipos
        {
            get { return listaEquipos; }
            set { listaEquipos = value; }
        }

        //Creo un indizador para obtener un Usuario
        public Equipo this[int indice]
        {
            get
            {
                return this.listaEquipos[indice];
            }
            set
            {
                this.listaEquipos[indice] = value;
            }
        }

        public void AgregarEquipo(Equipo objEquipo)
        {
            this.listaEquipos.Add(objEquipo);
        }

        public Equipo ObtenerEquipo(string categoria)
        {
            Equipo objEquipo = null;
            for (int i = 0; i < this.listaEquipos.Count; i++)
            {
                if (this.listaEquipos[i].Categoria == categoria)
                {
                    objEquipo = this.listaEquipos[i];
                    break;
                }
            }
            return objEquipo;
        }

        public int NumeroEquipos()
        {
            return this.listaEquipos.Count;
        }

        public List<Equipo> BuscarEquipos(string categoria)
        {
            if (categoria == null) return this.listaEquipos;
            List<Equipo> listaEquiposBuscados = new List<Equipo>();
            for (int i = 0; i < this.listaEquipos.Count; i++)
            {
                if (this.listaEquipos[i].Categoria == categoria)
                {
                    listaEquiposBuscados.Add(this.listaEquipos[i]);
                }
            }
            return listaEquiposBuscados;
        }

        public void Serializar()
        {
            Stream stream = File.Open("Equipu.bin", FileMode.Create);
            BinaryFormatter bin = new BinaryFormatter();
            bin.Serialize(stream, this.listaEquipos);
            stream.Close();
        }

        public void Deserializar()
        {
            try
            {
                Stream stream = File.Open("Equipu.bin", FileMode.Open);
                BinaryFormatter bin = new BinaryFormatter();
                this.listaEquipos = (List<Equipo>)bin.Deserialize(stream);
                stream.Close();
            }
            catch (FileNotFoundException ex)
            {

            }
        }

        public void ActualizarEvento(Equipo objEquipo)
        {
            for (int i = 0; i < this.listaEquipos.Count; i++)
            {
                if (this.listaEquipos[i].Nombre == objEquipo.Nombre)
                {
                    this.listaEquipos[i] = objEquipo;
                    break;
                }
            }
        }

        public void EliminarEquipo(string nombreEquipo)
        {
            for (int i = 0; i < this.listaEquipos.Count; i++)
            {
                if (this.listaEquipos[i].Nombre == nombreEquipo)
                {
                    this.listaEquipos.RemoveAt(i);
                    break;
                }
            }
        }
    }
}
