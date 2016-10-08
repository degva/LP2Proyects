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
    public partial class frmMantEquipos : Form
    {
        private GestorEquipos _gestorEquipo;
        private GestorMiembros _gestorMiembro;
        public frmMantEquipos()
        {
            InitializeComponent();
            this._gestorEquipo = new GestorEquipos();
            this._gestorMiembro = new GestorMiembros();
        }

        private void cargarGrilla(List<Equipo> listaEquipos)
        {
            this.dataGridView1.Rows.Clear();
            foreach (Equipo equi in listaEquipos)
            {
                string[] row = new string[4];
                row[0] = equi.Nombre;
                row[1] = equi.Interes;
                row[2] = equi.Categoria;
                row[3] = Convert.ToString(equi.Fondo);

                this.dataGridView1.Rows.Add(row);
            }
        }

        private void frmMantEquipos_Load(object sender, EventArgs e)
        {
            this._gestorEquipo.Deserializar();
            this._gestorMiembro.Deserializar();
            this.cargarGrilla(_gestorEquipo.ListaEquipos);
        }

        private void frmMantEquipos_FormClosed(object sender, FormClosedEventArgs e)
        {
            this._gestorEquipo.Serializar();
        }

        private void buscarBtn_Click(object sender, EventArgs e)
        {
            string categoria;
            try
            {
                categoria = this.comboBox1.SelectedItem.ToString();
            }
            catch
            {
                categoria = null;
            }
            List<Equipo> lista = null;

            lista = _gestorEquipo.BuscarEquipos(categoria);
            this.cargarGrilla(lista);
        }

        private void nuevoBtn_Click(object sender, EventArgs e)
        {
            frmMantEquiEditor editor = new frmMantEquiEditor(this._gestorEquipo, this._gestorMiembro);
            editor.ShowDialog();
            this.cargarGrilla(this._gestorEquipo.ListaEquipos);
        }
    }
}
