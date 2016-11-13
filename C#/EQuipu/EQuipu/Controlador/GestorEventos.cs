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
    public class GestorEventos
    {
        private List<Evento> listaEventos;

        public GestorEventos()
        {
            listaEventos = new List<Evento>();
        }

        public List<Evento> ListaEventos
        {
            get { return listaEventos; }
            set { listaEventos = value; }
        }

        //Creo un indizador para obtener un Usuario
        public Evento this[int indice]
        {
            get
            {
                return this.listaEventos[indice];
            }
            set
            {
                this.listaEventos[indice] = value;
            }
        }

        public void AgregarEvento(Evento objEvento)
        {
            this.ListaEventos.Add(objEvento);
        }

        public Evento ObtenerEvento(string nombre)
        {
            Evento objEvento = null;
            for (int i = 0; i < this.listaEventos.Count; i++)
            {
                if (this.listaEventos[i].Nombre == nombre)
                {
                    objEvento = this.listaEventos[i];
                    break;
                }
            }
            return objEvento;
        }

        public List<Evento> BuscarEventos(string nombre)
        {
            List<Evento> listaEventosBuscados = new List<Evento>();
            for (int i = 0; i < this.listaEventos.Count; i++)
            {
                if (this.listaEventos[i].Nombre == nombre)
                {
                    listaEventosBuscados.Add(this.listaEventos[i]);
                }
            }
            return listaEventosBuscados;
        }

        public List<Evento> BuscarEventosPorCategoria(string categoria)
        {
            List<Evento> listaEventosBuscados = new List<Evento>();
            for (int i = 0; i < this.listaEventos.Count; i++)
            {
                if (this.listaEventos[i].CategoriaEquipo == categoria)
                {
                    listaEventosBuscados.Add(this.listaEventos[i]);
                }
            }
            return listaEventosBuscados;
        }

        public void Serializar()
        {
            Stream stream = File.Open("eventos.bin", FileMode.Create);
            BinaryFormatter bin = new BinaryFormatter();
            bin.Serialize(stream, this.ListaEventos);
            stream.Close();
        }

        public void Deserializar()
        {
            try
            {
                Stream stream = File.Open("eventos.bin", FileMode.Open);
                BinaryFormatter bin = new BinaryFormatter();
                this.ListaEventos = (List<Evento>)bin.Deserialize(stream);
                stream.Close();
            }
            catch (FileNotFoundException ex)
            {

            }
        }

        public void ActualizarEvento(Evento objEvento)
        {
            for (int i = 0; i < this.listaEventos.Count; i++)
            {
                if (this.listaEventos[i].Nombre == objEvento.Nombre)
                {
                    this.listaEventos[i] = objEvento;
                    break;
                }
            }
        }

        public void EliminarEvento(string nombreEvento)
        {
            for (int i = 0; i < this.listaEventos.Count; i++)
            {
                if (this.listaEventos[i].Nombre == nombreEvento)
                {
                    this.listaEventos.RemoveAt(i);
                    break;
                }
            }
        }
    }
}
