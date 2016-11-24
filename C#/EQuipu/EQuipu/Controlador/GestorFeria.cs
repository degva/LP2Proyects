using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using EQuipu.Modelo;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

/*
 * Nombre: Diego Pavel Vargas Flores
 * Examen 1
 */

namespace EQuipu.Controlador
{
    public class GestorFeria
    {
        private List<Feria> _ferias;

        public GestorFeria()
        {
            _ferias = new List<Feria>();
        }

        internal List<Feria> Ferias
        {
            get { return _ferias; }
            set { _ferias = value; }
        }

        public void Serializar()
        {
            Stream stream = File.Open("ferias.bin", FileMode.Create);
            BinaryFormatter bin = new BinaryFormatter();
            bin.Serialize(stream, this._ferias);
            stream.Close();
        }

        public void Deserializar()
        {
            try
            {
                Stream stream = File.Open("ferias.bin", FileMode.Open);
                BinaryFormatter bin = new BinaryFormatter();
                this._ferias = (List<Feria>)bin.Deserialize(stream);
                stream.Close();
            }
            catch (FileNotFoundException ex)
            {

            }
        }
        
        //Creo un indizador para obtener un Usuario
        public Feria this[int indice]
        {
            get
            {
                return this._ferias[indice];
            }
            set
            {
                this._ferias[indice] = value;
            }
        }

        public void AgregarFeria(Feria objFeria)
        {
            this._ferias.Add(objFeria);
        }

        public Feria ObtenerEvento(string nombre)
        {
            Feria objFeria = null;
            for (int i = 0; i < this._ferias.Count; i++)
            {
                if (this._ferias[i].Nombre == nombre)
                {
                    objFeria = this._ferias[i];
                    break;
                }
            }
            return objFeria;
        }

        public void ActualizarFeria(Feria objFeria)
        {
            for (int i = 0; i < this._ferias.Count; i++)
            {
                if (this._ferias[i].Nombre == objFeria.Nombre)
                {
                    this._ferias[i] = objFeria;
                    break;
                }
            }
        }
    }
}
