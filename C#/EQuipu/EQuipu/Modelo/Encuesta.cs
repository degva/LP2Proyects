using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    [Serializable]
    public class Encuesta
    {
        private List<Pregunta> _preguntas;

        public Encuesta()
        {
            _preguntas = new List<Pregunta>();
        }

        public void AddQuestion(Pregunta a) {
            _preguntas.Add(a);
        }

        public int Size()
        {
            return _preguntas.Count;
        }

        public List<Pregunta> Preguntas
        {
            get { return _preguntas; }
            set { _preguntas = value; }
        }

        //Creo un indizador para obtener un Usuario
        public Pregunta this[int indice]
        {
            get
            {
                return this._preguntas[indice];
            }
            set
            {
                this._preguntas[indice] = value;
            }
        }
    }
}
