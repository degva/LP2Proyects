using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.IO;
using EQuipu.Controlador;
using EQuipu.Modelo;

namespace EQuipu.Vista
{
    public partial class frmProcesarEntrada : Form
    {
        private GestorFeria _gestor;
        
        private FileStream archivo;
        private StreamReader lector;

        private Feria _feria;

        public frmProcesarEntrada()
        {
            InitializeComponent();
            _gestor = new GestorFeria();
            archivo = new FileStream("Entradas.txt", FileMode.Open, FileAccess.Read);
            lector = new StreamReader(archivo);
        }

        private void frmProcesarEntrada_Load(object sender, EventArgs e)
        {
            _gestor.Deserializar();
            frmBuscarFeria b = new frmBuscarFeria(_gestor.Ferias);
            b.ShowDialog();
            string feria_name = b.getFeria();
            b.Dispose();

            _feria = _gestor.ObtenerEvento(feria_name);

            _feria[0].CreateThread(this.entradasListHeh, this.equipo1Label, this.equipo1Box);
            _feria[1].CreateThread(this.entradasListHeh, this.equipo2Label, this.equipo2Box);
            _feria[2].CreateThread(this.entradasListHeh, this.equipo3Label, this.equipo3Box);
            _feria[3].CreateThread(this.entradasListHeh, this.equipo4Label, this.equipo4Box);
            _feria[4].CreateThread(this.entradasListHeh, this.equipo5Label, this.equipo5Box);
            _feria[5].CreateThread(this.entradasListHeh, this.equipo6Label, this.equipo6Box);
            _feria[6].CreateThread(this.entradasListHeh, this.equipo7Label, this.equipo7Box);
            _feria[7].CreateThread(this.entradasListHeh, this.equipo8Label, this.equipo8Box);
        }

        private void beginBtn_Click(object sender, EventArgs e)
        {
            LeerArchivo();
        }

        private void LeerArchivo()
        {
            while (true)
            {
                string linea = lector.ReadLine();
                if (linea == null)
                    break;
                this.entradasListHeh.Items.Add(linea);
            }
            lector.Close();
            archivo.Close();

            for (int i = 0; i < 8; i++)
            {
                _feria[i].Start();
            }

            for (int i = 0; i < 8; i++)
            {
                _feria[i].Join();
            }

            this.equipo1Box.Text = _feria[0].Entradas.ToString();
            this.equipo2Box.Text = _feria[1].Entradas.ToString();
            this.equipo3Box.Text = _feria[2].Entradas.ToString();
            this.equipo4Box.Text = _feria[3].Entradas.ToString();
            this.equipo5Box.Text = _feria[4].Entradas.ToString();
            this.equipo6Box.Text = _feria[5].Entradas.ToString();
            this.equipo7Box.Text = _feria[6].Entradas.ToString();
            this.equipo8Box.Text = _feria[7].Entradas.ToString();

        }
    }
}
