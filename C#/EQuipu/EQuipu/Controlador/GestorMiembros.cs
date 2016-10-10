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
    public class GestorMiembros
    {
        private List<Miembro> listaMiembros;

        public GestorMiembros()
        {
            listaMiembros = new List<Miembro>();
        }
        public List<Miembro> ListaMiembros
        {
            get { return listaMiembros; }
            set { listaMiembros = value; }
        }
        //Creo un indizador para obtener un Usuario
        public Miembro this[int indice]
        {
            get
            {
                return this.listaMiembros[indice];
            }
            set
            {
                this.listaMiembros[indice] = value;
            }
        }

        public void AgregarMiembro(Miembro objMiembro)
        {
            this.listaMiembros.Add(objMiembro);
        }

        public Miembro ObtenerMiembro(int codigo)
        {
            Miembro objMiembro = null;
            for (int i = 0; i < this.listaMiembros.Count; i++)
            {
                if (this.listaMiembros[i].Codigo == codigo)
                {
                    objMiembro = this.listaMiembros[i];
                    break;
                }
            }
            return objMiembro;
        }

        public List<Miembro> BuscarMiembro(int codigo, string tipo)
        {
            List<Miembro> listaMiembrosBuscados = new List<Miembro>();
            for (int i = 0; i < this.listaMiembros.Count; i++)
            {
                if (tipo != null) { 
                    if ((this.listaMiembros[i].Codigo == codigo) || Type.GetType("EQuipu.Modelo." + tipo).IsAssignableFrom(this.listaMiembros[i].GetType()))
                    {
                        listaMiembrosBuscados.Add(this.listaMiembros[i]);
                    }
                }
                else
                {
                    if (this.listaMiembros[i].Codigo == codigo)
                    {
                        listaMiembrosBuscados.Add(this.listaMiembros[i]);
                    }
                }
            }
            return listaMiembrosBuscados;
        }

        public void Serializar()
        {
            Stream stream = File.Open("miembros.bin", FileMode.Create);
            BinaryFormatter bin = new BinaryFormatter();
            // El serialize no funciona y por tiempo no lo termine de debugear
            bin.Serialize(stream, this.listaMiembros);
            stream.Close();
        }

        public void Deserializar()
        {
            try
            {
                Stream stream = File.Open("miembros.bin", FileMode.Open);
                BinaryFormatter bin = new BinaryFormatter();
                this.listaMiembros = (List<Miembro>)bin.Deserialize(stream);
                stream.Close();
            }
            catch (FileNotFoundException ex)
            {

            }
        }

        public void ActualizarMiembro(Miembro objMiembro)
        {
            if (objMiembro == null) return;
            for (int i = 0; i < this.listaMiembros.Count; i++)
            {
                if (this.listaMiembros[i].Codigo == objMiembro.Codigo)
                {
                    this.listaMiembros[i] = objMiembro;
                    break;
                }
            }
        }

        public void EliminarMiembro(int codigo)
        {
            for (int i = 0; i < this.listaMiembros.Count; i++)
            {
                if (this.listaMiembros[i].Codigo == codigo)
                {
                    this.listaMiembros.RemoveAt(i);
                    break;
                }
            }
        }
    }
}
