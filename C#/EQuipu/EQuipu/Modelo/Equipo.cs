using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using System.Threading;

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

        private Thread hilo;
        private ListBox _lb;
        private TextBox _texb;
        private int entradas;
        
        public Equipo(string nombre, string interes, string categoria)
        {
            this.nombre = nombre;
            this.interes = interes;
            this.categoria = categoria;
            this.listaMiembros = new List<Miembro>();

            this.entradas = 0;
        }

        public void CreateThread(ListBox lb, Label l, TextBox tb)
        {
            l.Text = nombre;
            _texb = tb;
            _texb.Text = "0";
            _lb = lb;
            hilo = new Thread(KeepOnGoing);
            hilo.Name = nombre;
        }

        public void Start()
        {
            Console.WriteLine("Iniciando Hilo [" + this.nombre + "]");
            hilo.Start();
        }

        public void Join()
        {
            hilo.Join();
        }

        public void Interrupt()
        {
            hilo.Interrupt();
        }

        public void KeepOnGoing()
        {
            for (int i = 0; i < _lb.Items.Count; i++)
            {
                if (_lb.Items[i].ToString() == this.nombre)
                {
                    // _lb.Items.RemoveAt(0);
                    entradas += 1;
                }
            }
            Console.WriteLine("Acabo bien con " + entradas + "Entradas");
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
                        informacion = informacion + " ";// +objAlumno.getInformacion();
                    }
                    else
                    {
                        Profesor objProfesor = (Profesor)(this.listaMiembros[i]);
                        informacion = informacion + " ";// +objProfesor.getInformacion();
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
        public int Entradas
        {
            get { return entradas; }
            set { entradas = value; }
        }
    }
}
