using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using EQuipu.Controlador;
using EQuipu.Modelo;

namespace EQuipu.Vista
{
    public partial class frmMantEncuesta : Form
    {
        private GestorEncuesta _gestorEncuesta;

        public frmMantEncuesta()
        {
            this._gestorEncuesta = new GestorEncuesta();
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string text = this.textBox.Text;
            int ptMin = Int32.Parse(this.ptMinBox.Text);
            int ptMax = Int32.Parse(this.ptMaxBox.Text);
            
            Pregunta aux = new Pregunta(text, ptMin, ptMax);
            _gestorEncuesta.AddQuestion(aux);

            this.textBox.Text = "";
            this.ptMinBox.Text = "";
            this.ptMaxBox.Text = "";

            CargarGrilla(this._gestorEncuesta.Encuesta);
        }

        private void CargarGrilla(Encuesta encuesta)
        {
            this.preguntasGrid.Rows.Clear();
            for (int i = 0; i < encuesta.Size(); i++)
            {
                string[] row = new string[3];
                row[0] = encuesta[i].Texto;
                row[1] = Convert.ToString(encuesta[i].PtMin);
                row[2] = Convert.ToString(encuesta[i].PtMax);
                this.preguntasGrid.Rows.Add(row);
            }
        }

        private void btnOk_Click(object sender, EventArgs e)
        {
            this._gestorEncuesta.Serializar();
            this.Close();
        }

        private void frmMantEncuesta_Load(object sender, EventArgs e)
        {
            this._gestorEncuesta.Deserializar();
            CargarGrilla(this._gestorEncuesta.Encuesta);
        }

        private void frmMantEncuesta_FormClosed(object sender, FormClosedEventArgs e)
        {
            this._gestorEncuesta.Serializar();
        }

    }
}
