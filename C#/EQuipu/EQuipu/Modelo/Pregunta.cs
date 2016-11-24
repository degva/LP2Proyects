using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    [Serializable]
    public class Pregunta
    {
        private string _texto;
        private int _ptMax;
        private int _ptMin;
        private int _calificacion;

        public Pregunta(string texto, int pMin, int pMax)
        {
            _texto = texto;
            _ptMax = pMax;
            _ptMin = pMin;
            _calificacion = 0;
        }

        public int Calificacion
        {
            get { return _calificacion; }
            set { _calificacion = value; }
        }

        public string Texto
        {
            get { return _texto; }
            set { _texto = value; }
        }

        public int PtMax
        {
            get { return _ptMax; }
            set { _ptMax = value; }
        }


        public int PtMin
        {
            get { return _ptMin; }
            set { _ptMin = value; }
        }

    }
}
