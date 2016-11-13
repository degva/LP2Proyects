using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EQuipu.Modelo
{
    [Serializable]
    public class Equipo
    {
        private List<Miembro> listaMiembros;
        private string nombre;
        private string interes;
        private string categoria;
        private double fondo;

        public Equipo(string nombre, string interes, string categoria)
        {
            this.nombre = nombre;
            this.interes = interes;
            this.categoria = categoria;
            this.listaMiembros = new List<Miembro>();
        }

        public string ConsultarMiembrosPUCP()
        {
            string informacion = "";
            for (int i = 0; i < this.listaMiembros.Count; i++)
            {
                if (this.listaMiembros[i] is Alumno || this.listaMiembros[i] is Profesor)
                {
                    if (this.listaMiembros[i] is Alumno)
                    {
                        Alumno objAlumno = (Alumno)(this.listaMiembros[i]);
                        informacion = informacion + " " + objAlumno.getInformacion();
                    }
                    else
                    {
                        Profesor objProfesor = (Profesor)(this.listaMiembros[i]);
                        informacion = informacion + " " + objProfesor.getInformacion();
                    }
                }
            }
            return informacion;
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

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }
        public string Interes
        {
            get { return interes; }
            set { interes = value; }
        }
        public string Categoria
        {
            get { return categoria; }
            set { categoria = value; }
        }
        public double Fondo
        {
            get { return fondo; }
            set { fondo = value; }
        }
        public List<Miembro> ListaMiembros
        {
            get { return listaMiembros; }
            set { listaMiembros = value; }
        }
    }
}
