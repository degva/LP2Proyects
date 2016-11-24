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
    public class GestorEncuesta
    {
        private Encuesta _encuesta;

        public GestorEncuesta()
        {
            _encuesta = new Encuesta();
        }

        public void AddQuestion(Pregunta a) {
            _encuesta.AddQuestion(a);
        }

        public Encuesta Encuesta
        {
            get { return _encuesta; }
            set { _encuesta = value; }
        }

        public void Serializar()
        {
            Stream stream = File.Open("encuesta.bin", FileMode.Create);
            BinaryFormatter bin = new BinaryFormatter();
            bin.Serialize(stream, this._encuesta);
            stream.Close();
        }

        public void Deserializar()
        {
            try
            {
                Stream stream = File.Open("encuesta.bin", FileMode.Open);
                BinaryFormatter bin = new BinaryFormatter();
                this._encuesta = (Encuesta)bin.Deserialize(stream);
                stream.Close();
            }
            catch (FileNotFoundException ex)
            {

            }
        }
        public void ActualizarPregunta (string text, int calif)
        {
            for (int i = 0; i < this._encuesta.Size(); i++)
            {
                if (this._encuesta[i].Texto == text)
                {
                    this._encuesta[i].Calificacion = calif;
                }
            }
        }
    }
}
