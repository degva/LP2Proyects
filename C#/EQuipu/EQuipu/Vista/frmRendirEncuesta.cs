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
    public partial class frmRendirEncuesta : Form
    {
        private GestorEncuesta _gestorEncuesta;
        private GestorEquipos _gestorEquipos;
        private int _contador;
        private Timer _temporizador;

        public frmRendirEncuesta()
        {
            InitializeComponent();
            this._gestorEncuesta = new GestorEncuesta();
            this._gestorEquipos = new GestorEquipos();
            this.timerLabel.Text = "0/120 seg";
            _contador = 0;
            _temporizador = new Timer();
            _temporizador.Interval = 1000;
            _temporizador.Tick += new EventHandler(ChangeTime);
            _temporizador.Enabled = false;
            this.equipoComboBox.Enabled = false;
        }

        public void ChangeTime(object sender, EventArgs args)
        {

        }

        private void frmRendirEncuesta_Load(object sender, EventArgs e)
        {
            this._gestorEquipos.Deserializar();
            this._gestorEncuesta.Deserializar();
        }

        private void CargarGrilla(Encuesta encuesta)
        {
            this.preguntasGrid.Rows.Clear();
            for (int i = 0; i < encuesta.Size(); i++)
            {
                string[] row = new string[2];
                row[0] = encuesta[i].Texto;
                row[1] = Convert.ToString(encuesta[i].Calificacion);
                this.preguntasGrid.Rows.Add(row);
            }
        }

        private void categoriaComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            string categoria = this.categoriaComboBox.SelectedItem.ToString();
            List<Equipo> listaEquipos = this._gestorEquipos.BuscarEquipos(categoria);
            foreach (Equipo eq in listaEquipos)
            {
                this.equipoComboBox.Items.Add(eq.Nombre);
            }
            this.equipoComboBox.Enabled = true;
        }

        private void equipoComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.CargarGrilla(this._gestorEncuesta.Encuesta);
            _temporizador.Enabled = true;
        }

        private void btnOk_Click(object sender, EventArgs e)
        {
            this._gestorEncuesta.Serializar();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void frmRendirEncuesta_FormClosed(object sender, FormClosedEventArgs e)
        {
            //
        }

        private void preguntasGrid_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (this.preguntasGrid.SelectedRows.Count != 0)
            {
                MessageBox.Show(this.preguntasGrid.SelectedRows[0].Cells[0].Value.ToString());
            }
            
        }
    }
}
