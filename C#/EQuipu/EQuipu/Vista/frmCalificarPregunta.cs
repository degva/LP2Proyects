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
    public partial class frmCalificarPregunta : Form
    {
        private GestorEncuesta _gestor;
        private int min, max;
        private string text;

        public frmCalificarPregunta(GestorEncuesta g, string text, int min, int max)
        {
            InitializeComponent();
            _gestor = g;
            this.text = text;
            this.min = min;
            this.max = max;
        }

        private void frmCalificarPregunta_Load(object sender, EventArgs e)
        {
            this.pregBox.Text = this.text;
        }

        private void btnOk_Click(object sender, EventArgs e)
        {
            int calificacion = Int16.Parse(this.califBox.Text);
            if (calificacion < min || calificacion > max)
            {
                MessageBox.Show("La calificacion sale de los limites!");
            }
            else
            {
                // llamamos al Gestor Actualizar Pregunta
            }
        }
    }
}
